package com.example.brydinh.ceg4410_hw2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ikovac.timepickerwithseconds.MyTimePickerDialog;

// display options screen on here.
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button AddAnalogViewBtn;
    private Button AddDigitalViewBtn;
    private Button ChangeDateBtn;
    private Button ChangeTimeBtn;
    private Button UndoCommandBtn;
    private Button RedoCommandBtn;

    private TextView dateDisplay;

    private DatePicker datePicker;
    private MyTimePickerDialog timePicker;

    private ClockModel clockModel;
    private ClockController clockController;
    private LinearLayout clockLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clockController = new ClockController();
        clockModel = new ClockModel(clockController);
        clockController.RegisterModel(clockModel);

        clockLayout = findViewById(R.id.clockLayout);

        ButtonSetup();
    }

    public void ButtonSetup()
    {
        dateDisplay = findViewById(R.id.dateDisplay);
        dateDisplay.setText(clockController.getMonth() + "/" + clockController.getDay() + "/" + clockController.getYear());

        AddAnalogViewBtn = findViewById(R.id.addAnalogView);
        AddDigitalViewBtn = findViewById(R.id.addDigitalView);
        ChangeDateBtn = findViewById(R.id.changeDate);
        ChangeTimeBtn = findViewById(R.id.changeTime);
        UndoCommandBtn = findViewById(R.id.undoCommand);
        RedoCommandBtn = findViewById(R.id.redoCommand);

        datePicker = findViewById(R.id.simpleDatePicker);
        datePicker.setSpinnersShown(false);

        AddAnalogViewBtn.setOnClickListener(this);
        ChangeDateBtn.setOnClickListener(this);
        ChangeTimeBtn.setOnClickListener(this);
        AddDigitalViewBtn.setOnClickListener(this);
        UndoCommandBtn.setOnClickListener(this);
        RedoCommandBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.addAnalogView:
                AddAnalogView();
                break;
            case R.id.addDigitalView:
                AddDigitalView();
                break;
            case R.id.changeDate:
                ChangeDate();
                break;
            case R.id.changeTime:
                ChangeTime();
                break;
            case R.id.undoCommand:
                UndoCommand();
                break;
            case R.id.redoCommand:
                RedoCommand();
                break;
        }
    }

    // Creates New Digital View
    private void AddDigitalView()
    {
        DigitalClock digitalClock = new DigitalClock(this, clockController);
        clockLayout.addView(digitalClock.GetDigitalClock());
    }

    // Creates New Analog View
    private void AddAnalogView()
    {
        com.example.brydinh.ceg4410_hw2.AnalogClock analogClock = new com.example.brydinh.ceg4410_hw2.AnalogClock(this, clockController);
        clockLayout.addView(analogClock.GetAnalogClock());
    }

    private void ChangeDate()
    {
        Command changeDate = new ChangeDateCommand();
        changeDate.doIt();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();
        int year = datePicker.getYear();

        clockController.SetDate(month, day, year);
        dateDisplay.setText(clockController.getMonth() + "/" + clockController.getDay() + "/" + clockController.getYear());
    }

    private void ChangeTime()
    {
//        Command ChangeTime = new ChangeTimeCommand();
//
//        CommandQ.push(ChangeTime);
//        ChangeTime.doIt();

        timePicker = new MyTimePickerDialog(this, new MyTimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(com.ikovac.timepickerwithseconds.TimePicker view, int hour, int minute, int seconds) {
                clockController.SetTime(hour, minute, seconds);
                clockController.updateViews();
            }
        }, 12, 0, 0, true);
        timePicker.show();
    }

    // TODO: WORK ON LATER
    private void RedoCommand()
    {

        // pop off queue

    }

    // TODO: WORK ON LATER
    private void UndoCommand()
    {
        // pop off stack
    }


}
