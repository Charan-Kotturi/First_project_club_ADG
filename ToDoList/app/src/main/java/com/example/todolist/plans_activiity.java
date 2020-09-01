package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class plans_activiity extends AppCompatActivity {
    private RecyclerView mondayRecView, tuesdayRecView, wednesdayRecView, thursdayRecView, fridayRecView, saturdayRecView, sundayRecView;
    private NestedScrollView scrollPlanLayout;
    private RelativeLayout noPlanLayout;
    private Button btnAddPlan;
    private TextView mondayEdit, tuesdayEdit, wednesdayEdit, thursdayEdit, fridayEdit, saturdayEdit, sundayEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans_activiity);

        initView();

        ArrayList<Plan> plans = Utils.getPlans();

        if(null != plans){
            if(plans.size()>0){
                noPlanLayout.setVisibility(View.GONE);
                scrollPlanLayout.setVisibility(View.VISIBLE);

                initRecView();

                onEditButtonPress();

            }
            else{
                noPlanLayout.setVisibility(View.VISIBLE);
                scrollPlanLayout.setVisibility(View.GONE);

                btnAddPlan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(plans_activiity.this,SeeAllActivities.class);
                        startActivity(intent);
                    }
                });
            }
            
        }
        else{
            noPlanLayout.setVisibility(View.VISIBLE);
            scrollPlanLayout.setVisibility(View.GONE);

            btnAddPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(plans_activiity.this,SeeAllActivities.class);
                    startActivity(intent);
                }
            });
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void initView(){
        mondayRecView = findViewById(R.id.mondayRecView);
        tuesdayRecView = findViewById(R.id.tuesdayRecView);
        wednesdayRecView = findViewById(R.id.wednesdayRecView);
        thursdayRecView = findViewById(R.id.thursdayRecView);
        fridayRecView = findViewById(R.id.fridayRecView);
        saturdayRecView = findViewById(R.id.saturdayRecView);
        sundayRecView = findViewById(R.id.sundayRecView);

        scrollPlanLayout = findViewById(R.id.scrollPlanView);
        noPlanLayout = findViewById(R.id.noPlanView);

        btnAddPlan = findViewById(R.id.btnAddPlans);

        mondayEdit = findViewById(R.id.mondayEdit);
        tuesdayEdit = findViewById(R.id.tuesdayEdit);
        wednesdayEdit = findViewById(R.id.wednesdayEdit);
        thursdayEdit = findViewById(R.id.thursdayEdit);
        fridayEdit = findViewById(R.id.fridayEdit);
        saturdayEdit = findViewById(R.id.saturdayEdit);
        sundayEdit = findViewById(R.id.sundayEdit);
    }

    private void initRecView(){
        planItemAdaptor mondayAdaptor = new planItemAdaptor(this);
        mondayRecView.setAdapter(mondayAdaptor);
        mondayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        mondayAdaptor.setPlans(getDayPlan("Monday"));

        planItemAdaptor tuesdayAdaptor = new planItemAdaptor(this);
        tuesdayRecView.setAdapter(tuesdayAdaptor);
        tuesdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        tuesdayAdaptor.setPlans(getDayPlan("Tuesday"));

        planItemAdaptor wednesdayAdaptor = new planItemAdaptor(this);
        wednesdayRecView.setAdapter(wednesdayAdaptor);
        wednesdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        wednesdayAdaptor.setPlans(getDayPlan("Wednesday"));

        planItemAdaptor thursdayAdaptor = new planItemAdaptor(this);
        thursdayRecView.setAdapter(thursdayAdaptor);
        thursdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        thursdayAdaptor.setPlans(getDayPlan("Thursday"));

        planItemAdaptor fridayAdaptor = new planItemAdaptor(this);
        fridayRecView.setAdapter(fridayAdaptor);
        fridayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        fridayAdaptor.setPlans(getDayPlan("Friday"));

        planItemAdaptor saturdayAdaptor = new planItemAdaptor(this);
        saturdayRecView.setAdapter(saturdayAdaptor);
        saturdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        saturdayAdaptor.setPlans(getDayPlan("Saturday"));

        planItemAdaptor sundayAdaptor = new planItemAdaptor(this);
        sundayRecView.setAdapter(sundayAdaptor);
        sundayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        sundayAdaptor.setPlans(getDayPlan("Sunday"));

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

    private void onEditButtonPress(){

        final Intent intent = new Intent(this, editActivity.class);

        mondayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Day","Monday");
                startActivity(intent);
            }
        });

        tuesdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Day","Tuesday");
                startActivity(intent);
            }
        });
        wednesdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Day","Wednesday");
                startActivity(intent);
            }
        });
        thursdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Day","thursday");
                startActivity(intent);
            }
        });
        fridayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Day","Friday");
                startActivity(intent);
            }
        });
        saturdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Day","Saturday");
                startActivity(intent);
            }
        });
        sundayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Day","Sunday");
                startActivity(intent);
            }
        });
    }

}