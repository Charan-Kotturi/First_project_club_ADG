package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;

public class editActivity extends AppCompatActivity {

    private RecyclerView editRecView;
    private TextView txtEditDay;
    private Button btnEditPlan;
    private planItemAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        initView();

        adaptor = new planItemAdaptor(this);
        editRecView.setAdapter(adaptor);
        editRecView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();

        if(null != intent){

            String Day = intent.getStringExtra("Day");
            System.out.println(Day);
            
            if(null != Day){

                ArrayList<Plan> editPlans = getDayPlan(Day);

                adaptor.setPlans(editPlans);

                try {
                    txtEditDay.setText(Day);
                }catch (NullPointerException e){
                    e.printStackTrace();
                }


            }
        }
        btnEditPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(editActivity.this,SeeAllActivities.class);
                startActivity(mIntent);
            }
        });

    }
    private void initView(){
        editRecView = findViewById(R.id.editRecView);
        txtEditDay = findViewById(R.id.txtDay);
        btnEditPlan = findViewById(R.id.btnEditPlan);
    }

    private ArrayList<Plan> getDayPlan (String Day) {
        ArrayList<Plan> allPlan = Utils.getPlans();
        ArrayList<Plan> dayPlan = new ArrayList<>();

        for(Plan p: allPlan) {
            if(p.getDay().equalsIgnoreCase(Day)){
                dayPlan.add(p);
            }
        }
        return dayPlan;
    }
}

