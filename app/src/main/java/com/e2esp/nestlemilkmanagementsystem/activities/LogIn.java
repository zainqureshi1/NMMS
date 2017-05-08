package com.e2esp.nestlemilkmanagementsystem.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

import com.e2esp.nestlemilkmanagementsystem.R;
import com.e2esp.nestlemilkmanagementsystem.activities.Registration;

public class LogIn extends Activity {

    private ImageButton imageButtonSignUp;
    private AppCompatButton buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        addListenerOnImgBtnSignUp();
        addListenerOnButtonSignIn();
    }

    public void addListenerOnButtonSignIn() {
        buttonSignIn = (AppCompatButton) findViewById(R.id.buttonSignIn);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignInButtonClick();
            }
        });
    }

    public void addListenerOnImgBtnSignUp() {
        imageButtonSignUp = (ImageButton) findViewById(R.id.imageButtonSignUp);
        imageButtonSignUp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSignUp();
            }
        });
    }

    public void onSignInButtonClick(){
        Intent intent = new Intent(LogIn.this, HomePage.class);
        startActivity(intent);
        finish();
    }


    public void goToSignUp() {
        Intent intent = new Intent(LogIn.this, Registration.class);
        startActivity(intent);
        finish();
    }

}