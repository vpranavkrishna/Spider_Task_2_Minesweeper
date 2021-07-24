package com.games.spider_task_2_minesweeper;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static androidx.core.content.ContextCompat.getSystemService;

public class MainActivity extends AppCompatActivity implements MinesweeperView.datatransfer{
    private MinesweeperView minesweeperView;
    private TextView score;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Model.drawmodel();
        Model.setminesboard();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        minesweeperView = findViewById(R.id.Minegrid);
        score = findViewById(R.id.score);
        minesweeperView.intializeinterface(this);
        }
    @Override
    public void update(boolean gameover,boolean win,int Score) {
        if(!gameover)
        {
            score.setText("SCORE ="+Score);
        }

                    if(gameover)
                    {
                        shakeIt(300,10);
                        Intent intent = new Intent(this,PostGameActivity.class);
                        intent.putExtra("postgame","YOU LOST");
                        intent.putExtra("score",Score);
                        startActivity(intent);
                        finish();
                    }
                    if(win)
                    {
                        Intent intent = new Intent(this,PostGameActivity.class);
                        intent.putExtra("postgame","YOU WON");
                        intent.putExtra("score",Score);
                        startActivity(intent);
                        finish();
                    }

    }
    private void shakeIt(int time, int amp)
    {
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(time,amp));
        } else {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(time);
        }
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
