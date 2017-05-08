package com.e2esp.nestlemilkmanagementsystem.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.e2esp.nestlemilkmanagementsystem.R;

public class DailyPurchaseSummary extends AppCompatActivity {

    AppCompatButton dpsBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_purchase_summary);

        getReferences();
        addListenerOnButtonBack();
    }

    private void getReferences(){
        dpsBackButton = (AppCompatButton) findViewById(R.id.dpsBackButton);
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
        Intent intent = new Intent(DailyPurchaseSummary.this, HomePage.class);
        startActivity(intent);
        finish();
    }
}
