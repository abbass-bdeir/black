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

public class colors extends AppCompatActivity {
    private ImageView iv2;
    private Spinner sp2;
    private Button bt2;
    private GameColor gC1;
    private ImageButton imgb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        iv2=findViewById(R.id.imageC);
        sp2=findViewById(R.id.spinnerC);
        bt2=findViewById(R.id.buttonC);
        gC1=new GameColor(this);
        imgb1=findViewById(R.id.imgbc);
        MediaPlayer coreect =MediaPlayer.create(this,R.raw.correct);
        MediaPlayer Tryagain =MediaPlayer.create(this,R.raw.tryagain);

        gC1.changeImage(iv2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int i = sp2.getSelectedItemPosition();
                if (gC1.gameOver() && gC1.isCorrect(i)) {
                    iv2.setImageResource(R.drawable.gameover1);
                    gC1.restart();
                    return;
                }
                if (gC1.isStart())
                    gC1.changeImage(iv2);
                else if (gC1.isCorrect(i)) {
                    coreect.start();
                    gC1.changeImage(iv2);
                    Toast.makeText(colors.this, "Correct", Toast.LENGTH_SHORT).show();

                }
                else
                    Tryagain.start();
                    Toast.makeText(colors.this, "Try again", Toast.LENGTH_SHORT).show();

            }
        });


        imgb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backtochoose();
            }
        });
    }




    public void backtochoose(){
        Intent intent5=new Intent(colors.this,choose_options.class);
        startActivity(intent5);
    }
}