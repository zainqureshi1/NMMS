package com.e2esp.nestlemilkmanagementsystem.activities;

import java.util.Calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.e2esp.nestlemilkmanagementsystem.R;

public class UpdateMasterData extends AppCompatActivity {

    private TextView textViewDisplayDate, textViewDisplayTime;
    private Calendar calendar;

    private AppCompatButton masterDataCancelButton, masterDataUpdateButton;
    private LinearLayout updatingInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_master_data);
        getReferences();
        displayDate();
        displayTime();
        onUpdateButtonClicked();
        onCancelButtonClicked();
    }

    private void getReferences(){
        masterDataUpdateButton = (AppCompatButton) findViewById(R.id.masterDataUpdateButton);
        masterDataCancelButton = (AppCompatButton) findViewById(R.id.masterDataCancelButton);
        updatingInformation = (LinearLayout) findViewById(R.id.updatingInformation);
        textViewDisplayDate = (TextView) findViewById(R.id.textViewDisplayDate);
        textViewDisplayTime = (TextView) findViewById(R.id.textViewDisplayTime);
    }


    private void onUpdateButtonClicked(){
        masterDataUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatingInformation.setVisibility(View.VISIBLE);
            }
        });
    }

    private void onCancelButtonClicked(){
        masterDataCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UpdateMasterData.this, HomePage.class);
                startActivity(intent);
            }
        });
    }

    private void displayDate(){

        String days, months;
        int day, month, year;

        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        if(day <= 9){days = "0"+day;}
        else{days = ""+day;}

        month = month+1;
        if (month <= 9){months = "0"+month;}
        else{months = ""+month;}

        textViewDisplayDate.setText(new StringBuilder()
                .append(days).append("-").append(months).append("-").append(year));
    }

    private void displayTime(){
        String hours, minutes, seconds, AM_PM;
        int hr, min, sec;

        calendar = Calendar.getInstance();
        hr = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);
        sec = calendar.get(Calendar.SECOND);
        int ds = calendar.get(Calendar.AM_PM);

        if(hr <= 9){hours = "0"+hr;}
        else{hours = ""+hr;}

        if (min <= 9){minutes = "0"+min;}
        else{minutes = ""+min;}

        if(sec <= 9){seconds = "0"+sec;}
        else{seconds = ""+sec;}

        if(ds == 0){AM_PM="PM";}
        else{AM_PM="AM";}

        textViewDisplayTime.setText(new StringBuilder()
                .append(hours).append(":").append(minutes).append(":").append(seconds).append(" ").append(AM_PM));
    }
}
