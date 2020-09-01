package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;

import org.w3c.dom.Text;

public class SeeListItemEach extends AppCompatActivity implements PlanDialogDetails.PassPlanDetails {

    @Override
    public void getPlan(Plan plan) {
        if (Utils.addPlan(plan)){
            // TODO: 20-08-2020 Take them to the respect activity but for now its just toast.
            Intent intent = new Intent(SeeListItemEach.this,plans_activiity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private ImageView imageEachItem;
    private TextView txtEachName;
    private TextView txtLongDec;
    private Button btnAddToPlans;
    public static final String TRAINING_KEY = "training";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_list_item_each);

        initView();

        Intent intent = getIntent();
        if(null != intent) {
            final studyItems newItem = intent.getParcelableExtra(TRAINING_KEY);
            if(null != newItem){
                txtEachName.setText(newItem.getName());
                txtLongDec.setText(newItem.getLongDec());
                Glide.with(this)
                        .asBitmap()
                        .load(newItem.getImageUrl())
                        .into(imageEachItem);
                btnAddToPlans.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: 20-08-2020 have to add an custom dialogue
                        PlanDialogDetails dialog = new PlanDialogDetails();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(TRAINING_KEY, newItem);
                        dialog.setArguments(bundle);
                        dialog.show(getSupportFragmentManager(), "plan detail dialog.");
                    }
                });
            }
        }

    }
    private void initView(){
        imageEachItem = findViewById(R.id.btnImageViewEachItem);
        btnAddToPlans = findViewById(R.id.btnAddPlan);
        txtLongDec = findViewById(R.id.txtLongDecEach);
        txtEachName = findViewById(R.id.txtEachItemName);
    }
}