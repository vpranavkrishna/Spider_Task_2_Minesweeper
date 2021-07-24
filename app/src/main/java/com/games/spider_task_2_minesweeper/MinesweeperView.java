package com.games.spider_task_2_minesweeper;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MinesweeperView extends View {
    private datatransfer game;
    private int playerscore = 0;
    private boolean gameover = false;
    private int[][] gird = Model.model;
    private boolean[][] touch = Model.sense;
    private boolean Screentouch = false;
    private int X;
    private int Y;
    private Paint paint = new Paint();
    private Paint paintline = new Paint();
    private Paint paintRed = new Paint();
    private Paint paintText = new Paint();
    private Paint paintGreen = new Paint();
    private Paint paintflag = new Paint();
    private boolean win = false;
    AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME).setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();
    SoundPool soundPool = new SoundPool.Builder().setMaxStreams(3).setAudioAttributes(audioAttributes).build();
    int sound = soundPool.load(getContext(), R.raw.ping_pong_8bit_beeep, 1);

    public MinesweeperView(Context context) {
        super(context);
    }

    public MinesweeperView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paintText.setColor(Color.BLACK);
        paintflag.setColor(Color.YELLOW);
        paintText.setTextSize(50);
        paintRed.setColor(Color.RED);
        paintGreen.setColor(Color.GREEN);
        paint.setColor(Color.GRAY);
        paintline.setColor(Color.WHITE);
    }

    public MinesweeperView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void drawboard(Canvas canvas) {
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        for (int i = 0; i < 8; i++) {
            canvas.drawLine(0, i * getHeight() / 8, getWidth(), i * getHeight()/ 8, paintline);
            canvas.drawLine(i * getWidth() / 8, 0, i * getWidth() / 8, getHeight(), paintline);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawboard(canvas);
        drawcell(canvas);
        checkwin(canvas);
    }

    private void checkwin(Canvas canvas) {
        win = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (gird[i][j] != -1) {
                    if (touch[i][j]) {
                        win = true;
                    } else {
                        win = false;
                        return;
                    }
                }
            }
        }
        game.update(false, win, playerscore);
    }

    private void drawcell(Canvas canvas) {
        if (Screentouch && !gameover) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (!(gird[i][j] == -1) && touch[i][j]) {
                        canvas.drawRect(i * getWidth() / 8, j * getHeight() / 8, (i+1)*getWidth()/8, (j+1)*getHeight()/8, paintGreen);
                        canvas.drawText(String.valueOf(gird[i][j]), i * (getWidth() / 8) + getWidth() / 16, j * (getHeight() / 8) + getHeight() / 16, paintText);
                        game.update(gameover, win, playerscore);
                    }

                    if ((gird[i][j] == -1) && touch[i][j]) {
                        canvas.drawRect(i * getWidth() / 8, j * getHeight() / 8, (i+1)*getWidth()/8, (j+1)*getHeight()/8, paintRed);
                        gameover = true;
                        game.update(gameover, win, playerscore);
                        invalidate();
                    }
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Screentouch = true;
            int wx = getWidth()/8;
            int wy = getHeight()/8;
            X = (int) (event.getX() /wx);
            Y = (int) (event.getY() / wy);
            if (!touch[X][Y] && gird[X][Y] != -1) {
                playerscore++;
                soundPool.play(sound, 1, 1, 0, 0, 1);
            }
            touch[X][Y] = true;
            invalidate();
        }

        return true;
    }

    public void intializeinterface(datatransfer game) {
        this.game = game;
    }

    public interface datatransfer {
        void update(boolean gameover, boolean win, int score);
    }
}




