package com.example.project;

import android.app.Activity;
import android.widget.ImageView;
import java.util.ArrayList;

public class GameColor {
    private final static int Colors [] = new int [] {
            R.drawable.yellow , R.drawable.red , R.drawable.black, R.drawable.pink ,
            R.drawable.grey , R.drawable.blue , R.drawable.green , R.drawable.purple
    };
    private ArrayList<Integer> used = new ArrayList<>();
    private int r;
    private boolean st = false;
    private Activity activity;

    public GameColor(Activity activity)
    {
        this.activity = activity;
    }
    public boolean gameOver() {
        return used.size() == Colors.length;
    }


    public void restart() {
        used.clear();
        st = true;
    }

    public boolean isStart() {
        if (st) {
            st = false;
            return true;
        }
        return false;
    }


    public void changeImage(ImageView iv2) {
        do {
            r = (int) (Math.random() * Colors.length);
        } while (used.contains(r));
        used.add(r);
        iv2.setImageResource(Colors[r]);
    }

    public boolean isCorrect(int i) {
        return r == i;
    }
}
