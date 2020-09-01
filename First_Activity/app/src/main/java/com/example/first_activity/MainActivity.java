package com.example.first_activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.GenericLifecycleObserver;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "Some bullshit";
    private ImageView camera, imageView;
    private TextView txtToast, txtCount, txtCountView, clear;
    private int mCount = 0;
    private RelativeLayout relativeLayout;
    private Button next;
    public static final int CAMERA_ACTION_CODE = 101;
    public static final int CAMERA_REQUEST_PERMISSION = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this ,new String[] {Manifest.permission.CAMERA} ,CAMERA_REQUEST_PERMISSION);
        }

        initView();

        if(null != savedInstanceState) {
            mCount = savedInstanceState.getInt("name_key");
            Log.d(TAG, "onCreate: the number i is:"+ mCount);
            if( mCount != 0){
                txtCountView.setText(String.valueOf(mCount));
            }
        }

        txtToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.widget.Toast.makeText(MainActivity.this, txtCountView.getText().toString() + " counts done", Toast.LENGTH_SHORT).show();
            }
        });

        txtCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                txtCountView.setText(String.valueOf(mCount));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.INVISIBLE);
                relativeLayout.setVisibility(View.VISIBLE);
                mCount = 0;
                txtCountView.setText(String.valueOf(mCount));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContentPage.class);
                startActivity(intent);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
                relativeLayout.setVisibility(View.INVISIBLE);

                Intent mIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if( mIntent.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(mIntent, CAMERA_ACTION_CODE);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case CAMERA_ACTION_CODE:
                if(resultCode == RESULT_OK && data != null){
                    Bundle bundle = data.getExtras();
                    if (bundle != null) {
                        Bitmap bitmap = (Bitmap) bundle.get("data");
                        Glide.with(this)
                                .asBitmap()
                                .load(bitmap)
                                .into(imageView);
                    }
                }
                break;
            default:
                break;

        }

    }

    private void initView() {
        camera = findViewById(R.id.cameraIcon);
        txtToast = findViewById(R.id.textView);
        txtCount = findViewById(R.id.countIncrement);
        txtCountView = findViewById(R.id.count);
        clear = findViewById(R.id.clear);
        next = findViewById(R.id.next);
        imageView = findViewById(R.id.imageView);
        relativeLayout = findViewById(R.id.relativeLayout);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("name_key", mCount);
        super.onSaveInstanceState(outState);
    }
}