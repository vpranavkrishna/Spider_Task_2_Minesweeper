package com.games.spider_task_2_minesweeper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splashscreen extends AppCompatActivity {
private boolean onbackpressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);
        ImageView img = findViewById(R.id.imageView);
        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.animation);
        img.startAnimation(slideAnimation);
        Intent intent = new Intent(this,Dashboard.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!onbackpressed)
                    startActivity(intent);
                    finish();
            }
        },3000);
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder Builder = new AlertDialog.Builder(this);
        Builder.setTitle("Exit");
        Builder.setMessage("Are you sure u want to exit?");
        Builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onbackpressed = true;
                finishAffinity();
            }
        });
        Builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        Builder.create().show();
    }
    }
