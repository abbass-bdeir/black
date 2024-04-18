package com.example.project;

import android.app.Activity;
import android.widget.ImageView;

import java.util.ArrayList;

public class GameNumber {   private final static int numbers [] = new int [] {
        R.drawable.n0 , R.drawable.n1 , R.drawable.n2 , R.drawable.n3 ,
        R.drawable.n4 , R.drawable.n5 , R.drawable.n6 , R.drawable.n7,
        R.drawable.n8 , R.drawable.n9,R.drawable.n10
};
    private ArrayList<Integer> used = new ArrayList<>();
    private int r;
    private boolean st = false;
    private Activity activity;

    public GameNumber(Activity activity)
    {
        this.activity = activity;
    }
    public boolean gameOver() {

        return used.size() == numbers.length;
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


    public void changeImage(ImageView iv) {
        do {
            r = (int) (Math.random() * numbers.length);
        } while (used.contains(r));
        used.add(r);
        iv.setImageResource(numbers[r]);

    }

    public boolean isCorrect(int i) {
        return r == i;
    }


}
