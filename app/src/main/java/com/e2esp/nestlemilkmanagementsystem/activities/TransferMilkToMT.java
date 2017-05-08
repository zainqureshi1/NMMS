package com.e2esp.nestlemilkmanagementsystem.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.e2esp.nestlemilkmanagementsystem.R;

public class TransferMilkToMT extends AppCompatActivity {

    AppCompatButton transferMilkCancelButton, transferMilkBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_milk_to_mt);

        getReferences();
        addListenerOnButtonCancel();
        addListenerOnButtonTransfer();
    }

    private void getReferences(){
        transferMilkCancelButton = (AppCompatButton) findViewById(R.id.transferMilkCancelButton);
        transferMilkBackButton = (AppCompatButton) findViewById(R.id.transferMilkBackButton);
    }

    private void addListenerOnButtonCancel(){
        transferMilkCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTransferMilkCancelButtonClick();
            }
        });
    }

    private void addListenerOnButtonTransfer(){
        transferMilkBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTransferMilkTransferButtonClick();
            }
        });
    }

    private void onTransferMilkCancelButtonClick(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Alert");
        alertDialogBuilder.setMessage("Are you sure to cancel?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(TransferMilkToMT.this, HomePage.class);
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


    private void onTransferMilkTransferButtonClick(){
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Confirmation Transfer Milk");
        alertDialogBuilder.setMessage("Do you want to transfer milk to MT?");
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
        alertDialogBuilder.setTitle("Transfer Milk");
        alertDialogBuilder.setMessage("Your passcode is 8492. Please provide this passcode to MT.");
        alertDialogBuilder.setPositiveButton("Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(TransferMilkToMT.this, HomePage.class);
                        startActivity(intent);
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
