package com.example.project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class online extends AppCompatActivity {
private Button open;
    private Button open1;
    private Button open2;
    private Button open3;
    private ImageView imv;
    private int[] imageIds = {R.drawable.bgames,R.drawable.sonsaur,R.drawable.crazygames,R.drawable.poki  };
    private int currentIndex = 0;
    private Handler handler;
    private Runnable runnable;
    private ImageButton imback;
private WebView wbonline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);
        open = findViewById(R.id.butonline);
        open1 = findViewById(R.id.butonline1);
        open2 = findViewById(R.id.butonline2);
        open3 = findViewById(R.id.butonline3);
        imv = findViewById(R.id.IV_games);
        imback=findViewById(R.id.imgbc);
        wbonline=findViewById(R.id.WB_online);
        wbonline.getSettings().setJavaScriptEnabled(true);
        wbonline.setWebViewClient(new WebViewClient());
        wbonline.loadUrl("https://gameforge.com/en-US/littlegames/link-games/");




        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.Bgames.com"));
                startActivity(intent);
            }
        });

        open1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sonsaur.com/c/racing/"));
                startActivity(intent);
            }
        });


        open2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.crazygames.com/"));
                startActivity(intent);
            }
        });
        open3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://poki.com/ "));
                startActivity(intent);
            }
        });

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                currentIndex = (currentIndex + 1) % imageIds.length;
                imv.setImageResource(imageIds[currentIndex]);
                handler.postDelayed(runnable, 2000);
            }
        };

        handler.postDelayed(runnable, 2000);
imback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backtochoose();
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
    public void backtochoose(){
        Intent intent5=new Intent(online.this,choose_options.class);
        startActivity(intent5);
    }



}