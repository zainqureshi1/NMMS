package com.e2esp.nestlemilkmanagementsystem.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.e2esp.nestlemilkmanagementsystem.R;

import java.util.PriorityQueue;

public class MTDashBoard extends Activity {

    private AppCompatButton buttonMTManageCollections;
    private AppCompatButton buttonMTManageMRNs;
    private TextView textViewUserType;
    private LinearLayout manageCollectionsMTInnerLayout, manageMRNsMTInnerLayout;
    boolean checked = true;
    private Button buttonMTCreateMRN, buttonMTViewMRNs,buttonMTPurchaseSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mt_dash_board);
        getReferences();
        textViewUserType.setText(getResources().getString(R.string.user_mt));
        onManageCollectionsMTButtonClick();
        onManageMRNsMTButtonClick();
        onMTCreateMRNButtonClick();
        onMTViewMRNsButtonClick();
        onMTPurchaseSummaryButtonClick();
    }

    private void getReferences(){
        buttonMTManageCollections = (AppCompatButton) findViewById(R.id.buttonMTManageCollections);
        buttonMTManageMRNs = (AppCompatButton) findViewById(R.id.buttonMTManageMRNs);
        buttonMTCreateMRN = (Button) findViewById(R.id.buttonMTCreateMRN);
        buttonMTViewMRNs = (Button) findViewById(R.id.buttonMTViewMRNs);
        buttonMTPurchaseSummary = (Button) findViewById(R.id.buttonMTPurchaseSummary);

        manageCollectionsMTInnerLayout = (LinearLayout) findViewById(R.id.manageCollectionsMTInnerLayout);
        manageMRNsMTInnerLayout = (LinearLayout) findViewById(R.id.manageMRNsMTInnerLayout);
        textViewUserType = (TextView) findViewById(R.id.textViewUserType);
    }

    private void onManageCollectionsMTButtonClick(){
        buttonMTManageCollections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checked) {
                    manageCollectionsMTInnerLayout.setVisibility(View.VISIBLE);
                    checked = false;
                }
                else{
                    manageCollectionsMTInnerLayout.setVisibility(View.GONE);
                    checked = true;
                }
            }
        });

    }

    private void onManageMRNsMTButtonClick(){
        buttonMTManageMRNs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checked) {
                    manageMRNsMTInnerLayout.setVisibility(View.VISIBLE);
                    checked = false;
                }
                else{
                    manageMRNsMTInnerLayout.setVisibility(View.GONE);
                    checked = true;
                }
            }
        });

    }

    private void onMTCreateMRNButtonClick(){
        buttonMTCreateMRN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MTDashBoard.this, CreateMRN.class);
                intent.putExtra( CreateMRN.userType ,"MT");
                startActivity(intent);
            }
        });
    }

    private void onMTViewMRNsButtonClick(){
        buttonMTViewMRNs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MTDashBoard.this, SubmittedMRNs.class);
                intent.putExtra( SubmittedMRNs.userType ,"MT");
                startActivity(intent);
            }
        });
    }

    private void onMTPurchaseSummaryButtonClick(){
        buttonMTPurchaseSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MTDashBoard.this, DailyPurchaseSummary.class);
                intent.putExtra( DailyPurchaseSummary.userType ,"MT");
                startActivity(intent);
            }
        });
    }
}
