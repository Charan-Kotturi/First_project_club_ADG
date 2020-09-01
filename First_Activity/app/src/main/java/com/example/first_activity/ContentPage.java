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

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContentPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        textView3.setText("In the episode 'be right back,'\n AI is used to attain digital copies of a person's consciousness to help people deal with the grief of losing a loved one.\n In the episode " +
                "'Rachel, Jack and Ashley, too, Ashley's 15th birthday, she gets a robot-doll named Ashely too,\n which not only sings and dances like Ashley,\n but also has the same personality and starts\n " +
                "offering her bits of advices.We and others have written quite a bit about the various types of data science that make up AI.\n" +
                "  Still I hear many folks asking about AI as if it were a single entity.\n " +
                " It is not.  AI is a collection of data science technologies that at this point in development are not even particularly well integrated or even easy to use.\n " +
                " In each of these areas however, we’ve made a lot of progress and that’s caught the attention of the popular press.\n" +
                "This article is not intended to be a deep dive but rather the proverbial 50,000 foot view of what’s going on.\n" +
                "  If you’re a traditional data scientist who’s read some articles but still hasn’t put the big picture together you might find this a way of integrating your current knowledge and even discovering where you’d be interested in focusing.");

    }

    private void initView() {
        btnBack = findViewById(R.id.btnBack);
        textView3 = findViewById(R.id.textView3);
    }
}