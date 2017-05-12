package com.e2esp.nestlemilkmanagementsystem.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.e2esp.nestlemilkmanagementsystem.R;

public class HomePage extends AppCompatActivity {

    private AppCompatButton buttonManageMRNs;
    Button buttonCreateMRN, buttonViewMRNs, buttonPurchaseSummary, buttonTransferMilkToMT, buttonEndOfDay;
    private LinearLayout innerLayout;
    boolean checked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.msa_home_page);
        getReferences();
        onManageMRNsButtonClick();
        onCreateMRNButtonClick();
        onViewMRNsButtonClick();
        onDPSButtonClick();
        onTransferMilkToMTButtonClick();
        onEndOfDayButtonClick();
    }

    private void getReferences(){
        buttonManageMRNs = (AppCompatButton) findViewById(R.id.buttonManageMRNs);
        innerLayout = (LinearLayout) findViewById(R.id.manageMRNsInnerLayout);
        buttonCreateMRN = (Button) findViewById(R.id.buttonCreateMRN);
        buttonViewMRNs = (Button) findViewById(R.id.buttonViewMRNs);
        buttonPurchaseSummary = (Button) findViewById(R.id.buttonPurchaseSummary);
        buttonTransferMilkToMT = (Button) findViewById(R.id.buttonTransferMilkToMT);
        buttonEndOfDay = (Button) findViewById(R.id.buttonEndOfDay);
    }

    private void onManageMRNsButtonClick(){
        buttonManageMRNs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checked) {
                    innerLayout.setVisibility(View.VISIBLE);
                    checked = false;
                }
                else{
                    innerLayout.setVisibility(View.GONE);
                    checked = true;
                }
            }
        });

    }

    private void onCreateMRNButtonClick(){
        buttonCreateMRN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, CreateMRN.class);
                startActivity(intent);
            }
        });
    }

    private void onViewMRNsButtonClick(){
        buttonViewMRNs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, SubmittedMRNs.class);
                startActivity(intent);
            }
        });
    }

    private void onDPSButtonClick(){
        buttonPurchaseSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, DailyPurchaseSummary.class);
                startActivity(intent);
            }
        });
    }

    private void onTransferMilkToMTButtonClick(){
        buttonTransferMilkToMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, TransferMilkToMT.class);
                startActivity(intent);
            }
        });
    }

    private void onEndOfDayButtonClick(){
        buttonEndOfDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, EndOfDay.class);
                startActivity(intent);
            }
        });
    }


    private void updateAlertMessage(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Update Available");
        alertDialogBuilder.setMessage("Master Data is not updated. Update data before using application");
        alertDialogBuilder.setPositiveButton("Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent(HomePage.this, UpdateMasterData.class);
                        startActivity(intent);
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
