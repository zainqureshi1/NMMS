package com.e2esp.nestlemilkmanagementsystem.activities;



import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.support.v7.widget.AppCompatButton;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.e2esp.nestlemilkmanagementsystem.R;

public class Registration extends Activity {

    private EditText editTextUsername, editTextPassword, editTextMobileNumber, editTextInventoryNumber, editTextDeviceName;
    private AppCompatButton buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getReferences();
        addListenerOnButtonRegister();
        addAfterTextChangedListener();
    }

    private void getReferences(){
        buttonRegister = (AppCompatButton) findViewById(R.id.buttonRegister);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextMobileNumber = (EditText) findViewById(R.id.editTextMobileNumber);
        editTextInventoryNumber = (EditText) findViewById(R.id.editTextInventoryNumber);
        editTextDeviceName = (EditText) findViewById(R.id.editTextDeviceName);
    }

    private void addListenerOnButtonRegister(){
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegistrationButtonClick();
            }
        });
    }

    private void onRegistrationButtonClick(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Acknowledgement");
        alertDialogBuilder.setMessage("Yor registration request has been successfully submitted.");
                alertDialogBuilder.setPositiveButton("Close",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent intent = new Intent(Registration.this, LogIn.class);
                                startActivity(intent);
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void addAfterTextChangedListener(){
        editTextUsername.addTextChangedListener(userNameWatcher);
        editTextPassword.addTextChangedListener(passwordWatcher);
        editTextMobileNumber.addTextChangedListener(mobileNumberWatcher);
        editTextInventoryNumber.addTextChangedListener(inventoryNumberWatcher);
        editTextDeviceName.addTextChangedListener(deviceNameWatcher);

    }

    final String regexUsername = "^[a-zA-Z][a-zA-Z0-9\\-._\\s]{3,}$";
    final String regexPassword = "^[?=.*\\w\\d][a-zA-Z0-9\\-._]{8,20}";
    final String regexMobile = "^[0][3]\\d{9}$";
    final String regexInventory = "^\\d{8}$";
    final String regexDeviceName = "^[A-Za-z\\s]{3,}$";

    private final TextWatcher userNameWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {

            String value  = s.toString();
            if(value.matches(regexUsername))
                editTextUsername.setBackgroundResource(R.drawable.solid_borders);
            else
                editTextUsername.setBackgroundResource(R.drawable.red_borders);
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
                editTextPassword.setBackgroundResource(R.drawable.solid_borders);
            else
                editTextPassword.setBackgroundResource(R.drawable.red_borders);
        }
    };

    private final TextWatcher mobileNumberWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {

                String value  = s.toString();
                if(value.matches(regexMobile))
                    editTextMobileNumber.setBackgroundResource(R.drawable.solid_borders);
                else
                    editTextMobileNumber.setBackgroundResource(R.drawable.red_borders);
            }
    };

    private final TextWatcher inventoryNumberWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {

            String value  = s.toString();
            if(value.matches(regexInventory))
                editTextInventoryNumber.setBackgroundResource(R.drawable.solid_borders);
            else
                editTextInventoryNumber.setBackgroundResource(R.drawable.red_borders);
        }
    };

    private final TextWatcher deviceNameWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {

            String value  = s.toString();
            if(value.matches(regexDeviceName))
                editTextDeviceName.setBackgroundResource(R.drawable.solid_borders);
            else
                editTextDeviceName.setBackgroundResource(R.drawable.red_borders);
        }
    };


}
