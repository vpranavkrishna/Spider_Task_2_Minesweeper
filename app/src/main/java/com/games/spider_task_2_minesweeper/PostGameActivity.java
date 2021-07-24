package com.games.spider_task_2_minesweeper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PostGameActivity extends AppCompatActivity implements View.OnClickListener {
    private Button restart;
    private TextView post;
    private TextView score;
    private TextView highscore;
    private int newhighscore = 0;
    private int playerscore =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.postgameactivity);
            restart = findViewById(R.id.button);
            post = findViewById(R.id.post);
            score = findViewById(R.id.postscore);
            highscore = findViewById(R.id.posthighscore);
            restart.setOnClickListener(this);
            playerscore = getIntent().getIntExtra("score", 0);
            score.setText("SCORE =" + playerscore);
            post.setText(String.valueOf(getIntent().getStringExtra("postgame")));
            SharedPreferences prefs = getApplicationContext().getSharedPreferences("minesweeper", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            if (Model.difficulty == 4) {
                newhighscore = prefs.getInt("easy", playerscore);
                if (playerscore >= newhighscore) {
                    editor.putInt("easy", playerscore);
                    editor.apply();
                    highscore.setText("HIGHSCORE =" + playerscore);

                } else {
                    highscore.setText("HIGHSCORE =" + newhighscore);
                }
            }
            if (Model.difficulty == 8) {
                newhighscore = prefs.getInt("medium", playerscore);
                if (playerscore >= newhighscore) {
                    editor.putInt("medium", playerscore);
                    editor.apply();
                    highscore.setText("HIGHSCORE =" + playerscore);

                } else {
                    highscore.setText("HIGHSCORE =" + newhighscore);
                }
            }

            if (Model.difficulty == 12) {
                newhighscore = prefs.getInt("hard", playerscore);
                if (playerscore >= newhighscore) {
                    editor.putInt("hard", playerscore);
                    editor.apply();
                    highscore.setText("HIGHSCORE =" + playerscore);

                } else {
                    highscore.setText("HIGHSCORE =" + newhighscore);
                }
            }

        }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(PostGameActivity.this, Dashboard.class));
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
