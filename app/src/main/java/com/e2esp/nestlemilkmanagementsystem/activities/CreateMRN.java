package com.e2esp.nestlemilkmanagementsystem.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;
import android.widget.Toast;

import com.e2esp.nestlemilkmanagementsystem.R;
import com.e2esp.nestlemilkmanagementsystem.fragments.MilkMeasurements;
import com.e2esp.nestlemilkmanagementsystem.fragments.SupplierInformation;
import com.e2esp.nestlemilkmanagementsystem.fragments.ViewMRNDetails;


public class CreateMRN extends FragmentActivity {
    AppCompatButton createMRNCancelButton, createMRNNextButton, createMRNBackButton;
    private TextView textViewUserType;
    int counter = 1;
    final static String userType = "USER_TYPE";
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_mrn);
        getReferences();
        setUserType();
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
        textViewUserType = (TextView) findViewById(R.id.textViewUserType);
        createMRNCancelButton = (AppCompatButton) findViewById(R.id.createMRNCancelButton);
        createMRNNextButton = (AppCompatButton) findViewById(R.id.createMRNNextButton);
        createMRNBackButton = (AppCompatButton) findViewById(R.id.createMRNBackButton);
    }

    private void setUserType() {
        value =  getIntent().getStringExtra(userType);
        if(value.equals("MSA")){
            textViewUserType.setText(getResources().getString(R.string.user_msa));
        }
        else if(value.equals("MT")){
            textViewUserType.setText(getResources().getString(R.string.user_mt));
        }
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
            createMRNNextButton.setBackgroundResource(R.color.gray_purple);
            createMRNNextButton.setTextColor(getResources().getColor(R.color.black));
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
            createMRNNextButton.setBackgroundResource(R.drawable.dark_skin_borders);
            createMRNNextButton.setTextColor(getResources().getColor(R.color.dark_skin));
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
                        dialog.dismiss();
                       finish();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
