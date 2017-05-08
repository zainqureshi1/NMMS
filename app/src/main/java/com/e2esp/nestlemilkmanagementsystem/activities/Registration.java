package com.e2esp.nestlemilkmanagementsystem.activities;



import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

}
