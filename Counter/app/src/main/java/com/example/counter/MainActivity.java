package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private TextView txtCount;
    private FloatingActionButton adder_action;
    private TextView clearTxt;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCount = findViewById(R.id.txtCount);
        adder_action = findViewById(R.id.adder_btn);
        clearTxt = findViewById(R.id.txtClear);

        adder_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                txtCount.setText(Integer.toString(i));
            }
        });

        clearTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i != 0){
                    txtCount.setText("0");
                    i = 0;
                }
            }
        });

    }
}