package com.example.brydinh.ceg4410_hw2;

import java.util.Calendar;

public class ClockModel {

    private Calendar currentDateTime;
    private int month;
    private int day;
    private int year;
    private int hours;
    private int minutes;
    private int seconds;
    private ClockController c;

    public ClockModel(ClockController c)
    {
        currentDateTime = Calendar.getInstance();
        startTicking();
        this.c = c;
    }

    private void startTicking() {
        // start the thread
        new Thread(new Runnable() {
            public void run(){
                try {
                    while(true) {
                        UpdateTimeFields();
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void UpdateTimeFields()
    {
        seconds++;
        currentDateTime.set(Calendar.SECOND, seconds);
        c.updateViews();
        if (seconds == 60)
        {
            seconds = 0;
            minutes++;
            currentDateTime.set(Calendar.MINUTE, minutes);
            currentDateTime.set(Calendar.SECOND, seconds);
            c.updateViews();
        }
        else if (minutes == 60)
        {
            minutes = 0;
            hours++;
            currentDateTime.set(Calendar.MINUTE, minutes);
            currentDateTime.set(Calendar.SECOND, hours);
            c.updateViews();
        }
        else if (hours == 24)
        {
            hours = 0;
            currentDateTime.set(Calendar.DAY_OF_MONTH, day);
            c.updateViews();
        }
    }

    public int getMonth()
    {
        month = currentDateTime.get(Calendar.MONTH);
        return month + 1;
    }

    public Calendar getCalendar()
    {
        return currentDateTime;
    }

    public void setMonth(int newMonth)
    {
        this.month = newMonth;
        currentDateTime.set(Calendar.MONTH, newMonth);
    }

    public int getDay()
    {
        day =  currentDateTime.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    public void setDay(int newDay)
    {
        this.day = newDay;
        currentDateTime.set(Calendar.DAY_OF_MONTH, newDay);
    }

    public int getYear()
    {
        year = currentDateTime.get(Calendar.YEAR);
        return year;
    }

    public void setYear(int newYear)
    {
        this.year = newYear;
        currentDateTime.set(Calendar.YEAR, newYear);
    }

    public int getHours() {
        hours = currentDateTime.get(Calendar.HOUR_OF_DAY);
        return hours;
    }

    public void setHours(int newHours) {
        this.hours = newHours;
        currentDateTime.set(Calendar.HOUR_OF_DAY, newHours);
    }

    public int getMinutes()
    {
        minutes = currentDateTime.get(Calendar.MINUTE);
        return minutes;
    }

    public void setMinutes(int newMinutes)
    {
        this.minutes = newMinutes;
        currentDateTime.set(Calendar.MINUTE, newMinutes);
    }

    public int getSeconds()
    {
        seconds = currentDateTime.get(Calendar.SECOND);
        return seconds;
    }

    public void setSeconds(int newSeconds)
    {
        this.seconds = newSeconds;
        currentDateTime.set(Calendar.SECOND, newSeconds);
    }

}
