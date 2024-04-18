package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
ImageButton first ;
TextView tvk;
ImageButton second;
TextView tvM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    tvk=findViewById(R.id.tvkids);
        first = findViewById(R.id.IB_enter);
        second=findViewById(R.id.IB_music);
        tvM=findViewById(R.id.tvkidsmusic);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityM();
            }
        });
    }
    public void openActivity2(){
        Intent intent=new Intent(MainActivity.this,choose_options.class);
        startActivity(intent);
    }
    public void openActivityM(){
        Intent intent=new Intent(MainActivity.this,choose_music.class);
        startActivity(intent);
    }



    }
