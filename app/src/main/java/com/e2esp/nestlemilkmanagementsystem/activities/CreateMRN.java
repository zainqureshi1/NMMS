package com.e2esp.nestlemilkmanagementsystem.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.e2esp.nestlemilkmanagementsystem.R;
import com.e2esp.nestlemilkmanagementsystem.fragments.MilkMeasurements;
import com.e2esp.nestlemilkmanagementsystem.fragments.SupplierInformation;
import com.e2esp.nestlemilkmanagementsystem.fragments.ViewMRNDetails;


public class CreateMRN extends FragmentActivity {

    AppCompatButton createMRNCancelButton, createMRNNextButton, createMRNBackButton;
    int counter = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_mrn);

        getReferences();
        addListenerOnButtonCancel();
        addListenerOnButtonNext();
        addListenerOnButtonBack();

        if (findViewById(R.id.fragmentContainerCreateMRN) != null) {
            if (savedInstanceState != null) {
                return;
            }
            SupplierInformation supplierInfoFragment = new SupplierInformation();
            supplierInfoFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerCreateMRN, supplierInfoFragment).commit();
            createMRNBackButton.setVisibility(View.GONE);
        }
    }

    private void getReferences(){
        createMRNCancelButton = (AppCompatButton) findViewById(R.id.createMRNCancelButton);
        createMRNNextButton = (AppCompatButton) findViewById(R.id.createMRNNextButton);
        createMRNBackButton = (AppCompatButton) findViewById(R.id.createMRNBackButton);
    }

    private void addListenerOnButtonCancel(){
        createMRNCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateMRNCancelButtonClick();
            }
        });
    }

    private void addListenerOnButtonNext(){
        createMRNNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateMRNNextButtonClick();
            }
        });
    }

    private void addListenerOnButtonBack(){
        createMRNBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateMRNBackButtonClick();
            }
        });
    }

    private void onCreateMRNCancelButtonClick(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Alert");
        alertDialogBuilder.setMessage("Are you sure to cancel?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(CreateMRN.this, HomePage.class);
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

    private void onCreateMRNNextButtonClick(){

        if(counter == 1) {
            MilkMeasurements milkMeasurementsFragment = new MilkMeasurements();
            Bundle args = new Bundle();
            milkMeasurementsFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerCreateMRN, milkMeasurementsFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            counter++;
        }

        else if(counter == 2) {
            ViewMRNDetails viewMRNDetailsFragment = new ViewMRNDetails();
            Bundle args = new Bundle();
            viewMRNDetailsFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerCreateMRN, viewMRNDetailsFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            counter++;
        }

        else if(counter == 3){
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Confirmation");
            alertDialogBuilder.setMessage("Do you want to save Transaction?");
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


        createMRNBackButton.setVisibility(View.VISIBLE);
    }

    private void onCreateMRNBackButtonClick(){

        if(counter == 3) {
            MilkMeasurements milkMeasurementsFragment = new MilkMeasurements();
            Bundle args = new Bundle();
            milkMeasurementsFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerCreateMRN, milkMeasurementsFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            counter--;
        }

        else if(counter == 2) {
            SupplierInformation supplierInfoFragment = new SupplierInformation();
            Bundle args = new Bundle();
            supplierInfoFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerCreateMRN, supplierInfoFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            counter--;
            createMRNBackButton.setVisibility(View.GONE);
        }

    }

    public void showAcknowledgement(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Acknowledgement");
        alertDialogBuilder.setMessage("MRN Transaction has been saved successfully.");
        alertDialogBuilder.setPositiveButton("Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(CreateMRN.this, HomePage.class);
                        startActivity(intent);
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
