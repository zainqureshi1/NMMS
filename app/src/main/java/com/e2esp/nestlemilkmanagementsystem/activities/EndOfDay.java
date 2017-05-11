package com.e2esp.nestlemilkmanagementsystem.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.e2esp.nestlemilkmanagementsystem.R;
import com.e2esp.nestlemilkmanagementsystem.fragments.EOD;


public class EndOfDay extends FragmentActivity {

    AppCompatButton eodCancelButton, eodBackButton, endOfDayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_of_day);

        getReferences();
        addListenerOnButtonCancel();
        addListenerOnButtonBack();
        addListenerOnButtonEndOfDay();

        if (findViewById(R.id.fragmentContainerEndOfDay) != null) {
            if (savedInstanceState != null) {
                return;
            }
            EOD endOfDayFragment = new EOD();
            endOfDayFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerEndOfDay, endOfDayFragment).commit();
        }
    }

    private void getReferences(){
        eodCancelButton = (AppCompatButton) findViewById(R.id.eodCancelButton);
        eodBackButton = (AppCompatButton) findViewById(R.id.eodBackButton);
        endOfDayButton = (AppCompatButton) findViewById(R.id.endOfDayButton);
    }

    private void addListenerOnButtonCancel(){
        eodCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEndOfDayCancelButtonClick();
            }
        });
    }

    private void addListenerOnButtonBack(){
        eodBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEndOfDayBackButtonClick();
            }
        });
    }

    private void addListenerOnButtonEndOfDay(){
        endOfDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEndOfDayButtonClick();
            }
        });
    }

    private void onEndOfDayCancelButtonClick(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Alert");
        alertDialogBuilder.setMessage("Are you sure to cancel?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(EndOfDay.this, HomePage.class);
                        startActivity(intent);
                        finish();
                    }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void onEndOfDayBackButtonClick(){}

    private void onEndOfDayButtonClick(){}
}
