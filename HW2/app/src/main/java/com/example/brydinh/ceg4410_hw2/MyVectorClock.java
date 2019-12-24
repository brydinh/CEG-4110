package com.example.brydinh.ceg4410_hw2;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.turki.vectoranalogclockview.VectorAnalogClock;

// This is part of the external library I got from Github.
public class MyVectorClock extends VectorAnalogClock {

    private void init(){
        initializeSimple();
    }

    //mandatory constructor
    public MyVectorClock(Context ctx) {
        super(ctx);
        init();
    }

    public MyVectorClock(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyVectorClock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

}