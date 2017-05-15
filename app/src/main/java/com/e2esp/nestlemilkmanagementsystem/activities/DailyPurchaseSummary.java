package com.e2esp.nestlemilkmanagementsystem.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.e2esp.nestlemilkmanagementsystem.R;

public class DailyPurchaseSummary extends Activity {

    final static String userType = "USER_TYPE";
    private String value;
    private TextView textViewUserType;
    AppCompatButton dpsBackButton;
    private Button buttonPurchaseSummary, buttonMTPurchaseSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_purchase_summary);
        getReferences();
        setUserType();
        addListenerOnButtonBack();
    }

    private void getReferences(){
        dpsBackButton = (AppCompatButton) findViewById(R.id.dpsBackButton);
        textViewUserType = (TextView) findViewById(R.id.textViewUserType);

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


    private void addListenerOnButtonBack(){
        dpsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackButtonClick();
            }
        });
    }

    private void onBackButtonClick(){
        finish();
    }
}
