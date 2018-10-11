package com.example.brydinh.ceg4410_hw2;

import android.content.Context;
import android.view.View;

import java.util.Calendar;

public class AnalogClock extends ClockView {

    private MyVectorClock analogClock;

    public AnalogClock(Context context, ClockController c) {
        super(context, c);
        analogClock = new MyVectorClock(context);
    }

    public View GetAnalogClock()
    {
        return analogClock;
    }

    @Override
    public void UpdateClocks(Calendar time) {
        analogClock.setCalendar(time);
    }
}
