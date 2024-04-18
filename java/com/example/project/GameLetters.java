package com.example.project;

import android.app.Activity;
import android.widget.ImageView;



import java.util.ArrayList;

public class GameLetters {
    private final static int letter[] = new int[]{
            R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f,
            R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k,
            R.drawable.l, R.drawable.m, R.drawable.n,
            R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r,
            R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v,
            R.drawable.w, R.drawable.x, R.drawable.y, R.drawable.z
    };
    private ArrayList<Integer> used = new ArrayList<>();
    private int r;
    private boolean st = false;
    private Activity activity;


    public GameLetters(Activity activity) {
        this.activity = activity;
    }

    public boolean gameOver() {
        return used.size() == letter.length;
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


    public void changeImage(ImageView iv1) {
        do {
            r = (int) (Math.random() * letter.length);
        } while (used.contains(r));
        used.add(r);
        iv1.setImageResource(letter[r]);
    }

    public boolean isCorrect(int i) {
        return r == i;
    }
}
