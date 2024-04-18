package com.example.project;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class letters extends AppCompatActivity {

    private ImageView iv1;
    private Spinner sp1;
    private Button bt1;
    private GameLetters gl1;
    private ImageButton imagb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);

        iv1=findViewById(R.id.imageL);
        sp1=findViewById(R.id.spinnerL);
        bt1=findViewById(R.id.buttonL);
        imagb3=findViewById(R.id.imgbl);


        gl1=new GameLetters(this);
        gl1.changeImage(iv1);
        MediaPlayer coreect =MediaPlayer.create(this,R.raw.correct);
        MediaPlayer Tryagain =MediaPlayer.create(this,R.raw.tryagain);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = sp1.getSelectedItemPosition();
                if (gl1.gameOver() && gl1.isCorrect(i)) {
                    iv1.setImageResource(R.drawable.gameover1);

                    gl1.restart();
                    return;
                }
                if (gl1.isStart())
                    gl1.changeImage(iv1);
                else if (gl1.isCorrect(i)) {
                    coreect.start();
                    gl1.changeImage(iv1);
                    Toast.makeText(letters.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else
                    Tryagain.start();
                    Toast.makeText(letters.this, "Try again", Toast.LENGTH_SHORT).show();
            }
        });

        imagb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backtochoose3();
            }
        });



    }
    public void backtochoose3(){
        Intent intent7=new Intent(letters.this,choose_options.class);
        startActivity(intent7);
    }
}