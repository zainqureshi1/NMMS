package com.e2esp.nestlemilkmanagementsystem.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import com.e2esp.nestlemilkmanagementsystem.R;

public class StartJourney extends AppCompatActivity {

    private TextView textViewUserType;
    private AppCompatButton startJournyCancelButton;
    private AppCompatButton startJournySaveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_journey);
        getReferences();
        textViewUserType.setText(getResources().getString(R.string.user_mt));
        addListenerOnButtonCancel();
        addListenerOnButtonSave();
    }

    private void getReferences(){
        startJournyCancelButton = (AppCompatButton) findViewById(R.id.startJournyCancelButton);
        startJournySaveButton = (AppCompatButton) findViewById(R.id.startJournySaveButton);

        textViewUserType = (TextView) findViewById(R.id.textViewUserType);
    }

    private void addListenerOnButtonCancel(){
        startJournyCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartJourneyCancelButtonClick();
            }
        });
    }

    private void addListenerOnButtonSave(){
        startJournySaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartJourneySaveButtonClick();
            }
        });
    }

    private void onStartJourneyCancelButtonClick(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Alert");
        alertDialogBuilder.setMessage("Are you sure to cancel?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
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


    private void onStartJourneySaveButtonClick(){
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Save Journey");
        alertDialogBuilder.setMessage("Are you sure you want to save journey?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        showAcknowledgement();
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



    public void showAcknowledgement(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Acknowledgement");
        alertDialogBuilder.setMessage("Journey has been saved successfully.");
        alertDialogBuilder.setPositiveButton("Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        finish();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}
