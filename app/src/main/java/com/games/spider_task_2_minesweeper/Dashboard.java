package com.games.spider_task_2_minesweeper;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static androidx.core.content.ContextCompat.getSystemService;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
    private Button easy;
    private Button medium;
    private Button hard;
    private TextView highscore_easy;
    private TextView highscore_medium;
    private TextView highscore_hard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        easy = findViewById(R.id.easy);
        medium = findViewById(R.id.medium);
         hard = findViewById(R.id.hard);
         highscore_easy = findViewById(R.id.highscore_easy);
         highscore_medium = findViewById(R.id.highscore_medium);
         highscore_hard = findViewById(R.id.highscore_hard);
        SharedPreferences prefs=getApplicationContext().getSharedPreferences("minesweeper",MODE_PRIVATE);
        highscore_easy.setText(String.valueOf( prefs.getInt("easy",0)));
        highscore_medium.setText(String.valueOf(prefs.getInt("medium",0)));
        highscore_hard.setText( String.valueOf(prefs.getInt("hard",0)));
        easy.setOnClickListener(this);
        medium.setOnClickListener(this);
        hard.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == easy.getId() )
            Model.difficulty = 4;
        if(v.getId() == medium.getId())
            Model.difficulty = 8;
        if(v.getId() == hard.getId())
            Model.difficulty = 12;
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder Builder = new AlertDialog.Builder(this);
        Builder.setTitle("Exit");
        Builder.setMessage("Are you sure u want to exit?");
        Builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
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