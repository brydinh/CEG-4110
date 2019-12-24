package com.example.brydinh.ceg4410_hw2;


import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import java.util.Calendar;

public abstract class ClockView extends View {

    private ClockController c;

    public ClockView(Context context, ClockController c) {
        super(context);
        c.RegisterView(this);
        this.c = c;
    }

    public abstract void UpdateClocks(Calendar time);

    public int GetHour()
    {
        return c.GetHour();
    }

    public int GetMinute()
    {
        return c.GetMinute();
    }

    public int GetSecond()
    {
        return c.GetSeconds();
    }

}
