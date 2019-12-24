package com.example.brydinh.ceg4410_hw2;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class DigitalClock extends ClockView  {

    private TextView digitalClock;

    public DigitalClock(Context context, ClockController c) {
        super(context, c);
        digitalClock = new TextView(context);
        digitalClock.setText(GetHour() + ":" + GetMinute() + ":" + GetSecond());
    }

    public View GetDigitalClock()
    {
        return digitalClock;
    }

    @Override
    public void UpdateClocks(Calendar time) {
       int hour = time.get(Calendar.HOUR_OF_DAY);
       int minute = time.get(Calendar.MINUTE);
       int second = time.get(Calendar.SECOND);
       digitalClock.setText(hour + ":" + minute + ":" + second);
    }
}
