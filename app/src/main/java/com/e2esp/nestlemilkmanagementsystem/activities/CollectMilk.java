package com.e2esp.nestlemilkmanagementsystem.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import com.e2esp.nestlemilkmanagementsystem.R;
import com.e2esp.nestlemilkmanagementsystem.fragments.LocationAndTravelDetailsCM;
import com.e2esp.nestlemilkmanagementsystem.fragments.MilkAndQuality;
import com.e2esp.nestlemilkmanagementsystem.fragments.MilkMeasurements;
import com.e2esp.nestlemilkmanagementsystem.fragments.SupplierInformation;

public class CollectMilk extends FragmentActivity {

    private AppCompatButton collectMilkCancelButton, collectMilkNextButton, collectMilkBackButton;
    private TextView textViewUserType;
    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_milk);
        getReferences();
        textViewUserType.setText(getResources().getString(R.string.user_mt));
        addListenerOnButtonCancel();
        addListenerOnButtonNext();
        addListenerOnButtonBack();

        if (findViewById(R.id.fragmentContainerCollectMilk) != null) {
            if (savedInstanceState != null) {
                return;
            }
            LocationAndTravelDetailsCM locationAndTravelDetailsCMFragment = new LocationAndTravelDetailsCM();
            locationAndTravelDetailsCMFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerCollectMilk,
                    locationAndTravelDetailsCMFragment).commit();
        }
    }

    private void getReferences(){
        textViewUserType = (TextView) findViewById(R.id.textViewUserType);
        collectMilkCancelButton = (AppCompatButton) findViewById(R.id.collectMilkCancelButton);
        collectMilkNextButton = (AppCompatButton) findViewById(R.id.collectMilkNextButton);
        collectMilkBackButton = (AppCompatButton) findViewById(R.id.collectMilkBackButton);
    }

    private void addListenerOnButtonCancel(){
        collectMilkCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCollectMilkCancelButtonClick();
            }
        });
    }

    private void addListenerOnButtonNext(){
        collectMilkNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCollectMilkNextButtonClick();
            }
        });
    }

    private void addListenerOnButtonBack(){
        collectMilkBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCollectMilkBackButtonClick();
            }
        });
    }

    private void onCollectMilkCancelButtonClick(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Alert");
        alertDialogBuilder.setMessage("Are you sure to cancel?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
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

    private void onCollectMilkNextButtonClick(){
        if(counter == 1) {
            MilkAndQuality maqFragment = new MilkAndQuality();
            Bundle args = new Bundle();
            maqFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerCollectMilk, maqFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            collectMilkNextButton.setBackgroundResource(R.color.gray_purple);
            collectMilkNextButton.setTextColor(getResources().getColor(R.color.black));
            collectMilkBackButton.setVisibility(View.VISIBLE);
            counter++;
        }
    }

    private void onCollectMilkBackButtonClick(){
        if(counter == 2) {
            LocationAndTravelDetailsCM locationAndTravelDetailsCMFragment = new LocationAndTravelDetailsCM();
            Bundle args = new Bundle();
            locationAndTravelDetailsCMFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerCollectMilk, locationAndTravelDetailsCMFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            collectMilkNextButton.setBackgroundResource(R.drawable.dark_skin_borders);
            collectMilkNextButton.setTextColor(getResources().getColor(R.color.dark_skin));
            collectMilkBackButton.setVisibility(View.GONE);
            counter--;

        }
    }
}
