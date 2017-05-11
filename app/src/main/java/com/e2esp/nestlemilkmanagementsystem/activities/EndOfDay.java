package com.e2esp.nestlemilkmanagementsystem.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.RadioButton;

import com.e2esp.nestlemilkmanagementsystem.R;
import com.e2esp.nestlemilkmanagementsystem.fragments.EOD;
import com.e2esp.nestlemilkmanagementsystem.fragments.EODSummary;


public class EndOfDay extends FragmentActivity {

    AppCompatButton eodCancelButton, eodBackButton, endOfDayButton;
    int counter = 1;

    EOD endOfDayFragment = new EOD();

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

    private void onEndOfDayBackButtonClick(){

        EOD eodFragment = new EOD();
        Bundle args = new Bundle();
        eodFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerEndOfDay, eodFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        eodBackButton.setVisibility(View.GONE);
        endOfDayButton.setBackgroundResource(R.drawable.dark_skin_borders);
        endOfDayButton.setTextColor(getResources().getColor(R.color.dark_skin));
        counter--;
    }

    private void onEndOfDayButtonClick() {

        if (counter == 1) {
            EODSummary eodSummaryFragment = new EODSummary();
            Bundle args = new Bundle();
            eodSummaryFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerEndOfDay, eodSummaryFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            eodBackButton.setVisibility(View.VISIBLE);
            endOfDayButton.setBackgroundResource(R.color.gray_purple);
            endOfDayButton.setTextColor(getResources().getColor(R.color.black));
            counter++;
        }

        else if(counter == 2){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Confirm End of Day");
            alertDialogBuilder.setMessage("Do you want to end your day?");
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
    }
}

