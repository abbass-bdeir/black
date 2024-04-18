package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class choose_options extends AppCompatActivity {
    private Button butnumber;
    private Button butcolors;
    private Button butletters;
    private Button butonline;
    private ImageButton butback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_options);
        butnumber=findViewById(R.id.butN);
        butletters=findViewById(R.id.butL);
        butcolors=findViewById(R.id.butC);
        butonline=findViewById(R.id.butO);
        butback=findViewById(R.id.imgb);



        butback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                openActivityback();
            }
        });

        butnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                openActivityNumbers();

            }
        });

        butcolors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view3) {
                openActivityColors();
            }
        });


        butletters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view4) {
                openActivityletters();
            }
        });

        butonline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view4) {
                openActivityonline();
            }
        });
    }




    public void openActivityColors(){
        Intent intent1=new Intent(choose_options.this,colors.class);
        startActivity(intent1);
    }




    public void openActivityNumbers(){
        Intent intent2=new Intent(choose_options.this,numbers.class);
        startActivity(intent2);
    }

    public void openActivityletters(){
        Intent intent3=new Intent(choose_options.this,letters.class);
        startActivity(intent3);
    }

    public void openActivityonline(){
        Intent intent5=new Intent(choose_options.this,online.class);
        startActivity(intent5);
    }




    public void openActivityback(){
        Intent intent4=new Intent(choose_options.this,MainActivity.class);
        startActivity(intent4);
    }






}