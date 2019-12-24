package com.example.brydinh.ceg4410_hw2;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ClockController {

    private ClockModel model;
    private ArrayList<ClockView> views;

    public ClockController()
    {
        views = new ArrayList<>();
    }

    public void RegisterModel (ClockModel model)
    {
        this.model = model;
    }

    public void RegisterView (ClockView view)
    {
        views.add(view);
    }

    public void updateViews()
    {
        for(ClockView v: views)
        {
            v.UpdateClocks(model.getCalendar());
        }
    }

    public void SetDate(int month, int day, int year)
    {
        model.setMonth(month);
        model.setDay(day);
        model.setYear(year);
    }

    public void SetTime(int hour, int minute, int seconds)
    {
        model.setHours(hour);
        model.setMinutes(minute);
        model.setSeconds(seconds);
    }

    public int getMonth()
    {
        return model.getMonth();
    }

    public int getDay()
    {
        return model.getDay();
    }

    public int getYear()
    {
        return model.getYear();
    }

    public int GetHour()
    {
        return model.getHours();
    }

    public int GetMinute()
    {
        return model.getMinutes();
    }

    public int GetSeconds()
    {
        return model.getSeconds();
    }

}
