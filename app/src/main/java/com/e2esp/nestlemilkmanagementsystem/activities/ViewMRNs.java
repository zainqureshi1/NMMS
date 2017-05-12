package com.e2esp.nestlemilkmanagementsystem.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import com.e2esp.nestlemilkmanagementsystem.R;
import com.e2esp.nestlemilkmanagementsystem.fragments.MilkMeasurements;
import com.e2esp.nestlemilkmanagementsystem.fragments.SupplierInformation;
import com.e2esp.nestlemilkmanagementsystem.fragments.UpdateMRNInformation;
import com.e2esp.nestlemilkmanagementsystem.fragments.ViewMRNDetails;

public class ViewMRNs extends FragmentActivity {
    AppCompatButton viewMRNDetailsCancelButton, viewMRNDetailsBackButton, viewMRNDetailsUpdateButton;
    TextView pageTitleViewMRNDetails;
    int counter = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mrns);
        getReferences();
        addListenerOnButtonCancel();
        addListenerOnButtonUpdate();
        addListenerOnButtonBack();

        if (findViewById(R.id.fragmentContainerViewMRNDetails) != null) {
            if (savedInstanceState != null) {
                return;
            }
            ViewMRNDetails viewMRNDetailsFragment = new ViewMRNDetails();
            viewMRNDetailsFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerViewMRNDetails, viewMRNDetailsFragment).commit();
        }
    }

    private void getReferences(){
        viewMRNDetailsCancelButton = (AppCompatButton) findViewById(R.id.viewMRNDetailsCancelButton);
        viewMRNDetailsBackButton = (AppCompatButton) findViewById(R.id.viewMRNDetailsBackButton);
        viewMRNDetailsUpdateButton = (AppCompatButton) findViewById(R.id.viewMRNDetailsUpdateButton);
        pageTitleViewMRNDetails = (TextView) findViewById(R.id.pageTitleViewMRNDetails);
    }

     private void addListenerOnButtonCancel(){
        viewMRNDetailsCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewMRNDetailsCancelButtonClick();
            }
        });
    }

    private void onViewMRNDetailsCancelButtonClick(){

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


    private void addListenerOnButtonUpdate(){
        viewMRNDetailsUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewMRNDetailsUpdateButtonClick();
            }
        });
    }


    private void onViewMRNDetailsUpdateButtonClick(){

        if(counter == 1) {
            UpdateMRNInformation updateMRNInformationFragment = new UpdateMRNInformation();
            Bundle args = new Bundle();
            updateMRNInformationFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerViewMRNDetails, updateMRNInformationFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            counter++;
            viewMRNDetailsBackButton.setVisibility(View.GONE);
            viewMRNDetailsUpdateButton.setText(R.string.next_button);
            pageTitleViewMRNDetails.setText(R.string.update_mrn);

        }

        else if(counter == 2) {
            SupplierInformation supplierInformationFragment = new SupplierInformation();
            Bundle args = new Bundle();
            supplierInformationFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerViewMRNDetails, supplierInformationFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            counter++;
        }


        else if(counter == 3) {
            MilkMeasurements milkMeasurementsFragment = new MilkMeasurements();
            Bundle args = new Bundle();
            milkMeasurementsFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerViewMRNDetails, milkMeasurementsFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            counter++;
            viewMRNDetailsBackButton.setVisibility(View.VISIBLE);
        }

        else if(counter == 4) {
            ViewMRNDetails viewMRNDetailsFragment = new ViewMRNDetails();
            Bundle args = new Bundle();
            viewMRNDetailsFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerViewMRNDetails, viewMRNDetailsFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            counter++;
            viewMRNDetailsBackButton.setVisibility(View.VISIBLE);
            viewMRNDetailsUpdateButton.setText(R.string.save_button);
        }

        else if(counter == 5){
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Confirmation");
            alertDialogBuilder.setMessage("Do you want to update Transaction?");
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

    }


    private void addListenerOnButtonBack(){
        viewMRNDetailsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewMRNDetailsBackButtonClick();
            }
        });
    }

    private void onViewMRNDetailsBackButtonClick(){


        if(counter == 5) {
            MilkMeasurements milkMeasurementsFragment = new MilkMeasurements();
            Bundle args = new Bundle();
            milkMeasurementsFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerViewMRNDetails, milkMeasurementsFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            counter--;
             viewMRNDetailsUpdateButton.setText(R.string.next_button);
        }

        else if(counter == 4) {
            SupplierInformation supplierInfoFragment = new SupplierInformation();
            Bundle args = new Bundle();
            supplierInfoFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerViewMRNDetails, supplierInfoFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            counter--;
            viewMRNDetailsBackButton.setVisibility(View.GONE);
             pageTitleViewMRNDetails.setText(R.string.update_mrn);
        }

        else if(counter == 1){
            finish();
        }

    }

    public void showAcknowledgement(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Acknowledgement");
        alertDialogBuilder.setMessage("Your Transaction has been update successfully.");
        alertDialogBuilder.setPositiveButton("Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(ViewMRNs.this, HomePage.class);
                        startActivity(intent);
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
