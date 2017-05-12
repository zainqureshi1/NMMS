package com.e2esp.nestlemilkmanagementsystem.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

import com.e2esp.nestlemilkmanagementsystem.R;
import com.e2esp.nestlemilkmanagementsystem.activities.Registration;

public class LogIn extends Activity {

    private ImageButton imageButtonSignUp;
    private AppCompatButton buttonSignIn;
    private EditText editTextLogInUsername, editTextLogInPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        getReferences();
        addListenerOnImgBtnSignUp();
        addListenerOnButtonSignIn();
        addAfterTextChangedListener();
    }

    private void getReferences(){
        editTextLogInUsername = (EditText) findViewById(R.id.editTextLogInUsername);
        editTextLogInPassword = (EditText) findViewById(R.id.editTextLogInPassword);
        buttonSignIn = (AppCompatButton) findViewById(R.id.buttonSignIn);
        imageButtonSignUp = (ImageButton) findViewById(R.id.imageButtonSignUp);

    }

    public void addListenerOnButtonSignIn() {
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignInButtonClick();
            }
        });
    }

    public void addListenerOnImgBtnSignUp() {
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


    private void addAfterTextChangedListener(){
        editTextLogInUsername.addTextChangedListener(userNameWatcher);
        editTextLogInPassword.addTextChangedListener(passwordWatcher);
    }

    final String regexUsername = "^[a-zA-Z][a-zA-Z0-9\\-._\\s]{3,}$";
    final String regexPassword = "^[?=.*\\w\\d][a-zA-Z0-9\\-._]{8,20}";

    private final TextWatcher userNameWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {

            String value  = s.toString();
            if(value.matches(regexUsername))
                editTextLogInUsername.setBackgroundResource(R.drawable.solid_borders);
            else
                editTextLogInUsername.setBackgroundResource(R.drawable.red_borders);
        }
    };

    private final TextWatcher passwordWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {

            String value  = s.toString();
            if(value.matches(regexPassword))
                editTextLogInPassword.setBackgroundResource(R.drawable.solid_borders);
            else
                editTextLogInPassword.setBackgroundResource(R.drawable.red_borders);
        }
    };

}