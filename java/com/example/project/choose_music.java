package com.example.project;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class choose_music extends AppCompatActivity {

    private MediaPlayer mp1;
    private MediaPlayer mp2;
    private MediaPlayer mp3;
    private boolean isPlaying = false;
    Button btn1;
    Button btn2;
    Button btn3;
    ImageView ivm;
    private int[] im_id = {R.drawable.babyshark,R.drawable.wheel,R.drawable.wheelss  };
    private int currentIndex = 0;
    private Handler handler;
    private Runnable runnable;
    ImageButton imgb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_music);
        btn1=findViewById(R.id.but1);
        btn2=findViewById(R.id.but2);
        btn3=findViewById(R.id.but3);
        ivm= findViewById(R.id.IV_music);
        imgb1=findViewById(R.id.imgbc);
        mp1=MediaPlayer.create(this,R.raw.babyshark);
        mp2=MediaPlayer.create(this,R.raw.kidswheel);
        mp3=MediaPlayer.create(this,R.raw.bingo);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isPlaying) {
                    mp1.start();
                    btn1.setText("Pause");
                    isPlaying = true;
                } else {
                    mp1.pause();
                    btn1.setText("baby shark");
                    isPlaying = false;
                }
            }
        });

btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (!isPlaying) {
            mp2.start();
            btn2.setText("Pause");
            isPlaying = true;
        } else {
            mp2.pause();
            btn2.setText("kids wheels");
            isPlaying = false;
        }
    }
});
btn3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (!isPlaying) {
            mp3.start();
            btn3.setText("Pause");
            isPlaying = true;
        } else {
            mp3.pause();
            btn3.setText("Play");
            isPlaying = false;
        }
    }
});

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                currentIndex = (currentIndex + 1) % im_id.length;
                ivm.setImageResource(im_id[currentIndex]);
                handler.postDelayed(runnable, 2000);
            }
        };

        handler.postDelayed(runnable, 2000);
        imgb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backtochoose();
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
    public void backtochoose(){
        Intent intent5=new Intent(choose_music.this,MainActivity.class);
        startActivity(intent5);
    }
}