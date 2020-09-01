package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SeeAllActivities extends AppCompatActivity {

    private RecyclerView recViewAllActivities;
    private toDoListAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_activities_adaptor);

        recViewAllActivities = findViewById(R.id.RecViewSeeAllActivities);

        adaptor = new toDoListAdaptor(this);

        recViewAllActivities.setAdapter(adaptor);

        recViewAllActivities.setLayoutManager(new GridLayoutManager(this,2));

        adaptor.setStudyItems(Utils.getStudyItem());

    }
}