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

public class numbers extends AppCompatActivity {

    private ImageView iv;
    private Spinner sp;


    private Button bt;
    private GameNumber gn1;
    private ImageButton imgbt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        iv=findViewById(R.id.imageN);
        sp=findViewById(R.id.spinnerN);
        bt=findViewById(R.id.buttonN);
        imgbt2=findViewById(R.id.imgbn);

        gn1=new GameNumber(this);
        gn1.changeImage(iv);
        MediaPlayer coreect =MediaPlayer.create(this,R.raw.correct);
        MediaPlayer Tryagain =MediaPlayer.create(this,R.raw.tryagain);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=sp.getSelectedItemPosition();
                if (gn1.gameOver() && gn1.isCorrect(i)) {
                    iv.setImageResource(R.drawable.gameover1);

                    gn1.restart();
                    return;
                }
                if (gn1.isStart())
                    gn1.changeImage(iv);
                else if (gn1.isCorrect(i)) {
                    coreect.start();
                    gn1.changeImage(iv);
                    Toast.makeText(numbers.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else
                    Tryagain.start();
                    Toast.makeText(numbers.this, "Try again", Toast.LENGTH_SHORT).show();
            }
        });

        imgbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backtochoose2();
            }
        });

    }
    public void backtochoose2(){
        Intent intent6=new Intent(numbers.this,choose_options.class);
        startActivity(intent6);
    }
}