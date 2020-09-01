package com.example.first_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentPage extends AppCompatActivity {

    private ImageView btnBack;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_page);
        initView();
        getSupportActionBar().hide();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContentPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        textView3.setText("In the episode 'be right back,'\n AI is used to attain digital copies of a person's consciousness to help people deal with the grief of losing a loved one.\n In the episode " +
                "'Rachel, Jack and Ashley, too, Ashley's 15th birthday, she gets a robot-doll named Ashely too,\n which not only sings and dances like Ashley,\n but also has the same personality and starts\n " +
                "offering her bits of advices.");

    }

    private void initView() {
        btnBack = findViewById(R.id.btnBack);
        textView3 = findViewById(R.id.textView3);
    }
}