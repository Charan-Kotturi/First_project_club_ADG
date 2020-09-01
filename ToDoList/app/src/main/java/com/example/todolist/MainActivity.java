package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnSeeAllActivities , btnSeeActivityPlans , btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVIew();

        Utils.initList();

        btnSeeAllActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SeeAllActivities.class);
                startActivity(intent);
            }
        });

        btnSeeActivityPlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,plans_activiity.class);
                startActivity(intent);
            }
        });

    }

    private void initVIew(){
        btnAbout = findViewById(R.id.btnAbout);
        btnSeeActivityPlans = findViewById(R.id.btnSeeYourPlans);
        btnSeeAllActivities = findViewById(R.id.btnSeeAllPlans);
    }

}