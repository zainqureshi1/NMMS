package com.e2esp.nestlemilkmanagementsystem.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.EditText;

import com.e2esp.nestlemilkmanagementsystem.R;

/**
 * Created by Asad on 5/3/2017.
 */


public class MilkMeasurements extends Fragment {


    private TextView textViewSelectedMRN, textViewSelectedRegion, textViewVolume, textViewFat, textViewLRReading, textViewTemperature;
    private EditText editTextVolume, editTextFat, editTextLRReading, editTextTemperature;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_milk_measurements, container, false);
        getReferences(view);
        addAfterTextChangedListener();
        return view;
    }

    private void getReferences(View view){

        textViewSelectedMRN = (TextView) view.findViewById(R.id.textViewSelectedMRN);
        textViewSelectedRegion = (TextView) view.findViewById(R.id.textViewSelectedRegion);
        textViewVolume = (TextView) view.findViewById(R.id.textViewVolume);
        textViewFat = (TextView) view.findViewById(R.id.textViewFat);
        textViewLRReading = (TextView) view.findViewById(R.id.textViewLRReading);
        textViewTemperature = (TextView) view.findViewById(R.id.textViewTemperature);

        editTextVolume = (EditText) view.findViewById(R.id.editTextVolume);
        editTextFat = (EditText) view.findViewById(R.id.editTextFat);
        editTextLRReading = (EditText) view.findViewById(R.id.editTextLRReading);
        editTextTemperature = (EditText) view.findViewById(R.id.editTextTemperature);
    }

    private void addAfterTextChangedListener(){
        editTextVolume.addTextChangedListener(volumeWatcher);
        editTextFat.addTextChangedListener(fatWatcher);
        editTextLRReading.addTextChangedListener(lrReadingWatcher);
        editTextTemperature.addTextChangedListener(temperatureWatcher);

    }


    private final TextWatcher volumeWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {

            if (s.toString().isEmpty()){
                return;
            }

            try {
                double dblValue = Double.parseDouble(s.toString());
                if (dblValue < 0.5) {

                    dblValue = .5;
                    String strValue = String.valueOf(dblValue);
                    editTextVolume.setText(strValue);

                } else if (dblValue > 99999999.50) {

                    dblValue = 99999999.50;
                    String strValue = String.valueOf(dblValue);
                    editTextVolume.setText(strValue);
                }
            } catch (Exception e) {}
        }
    };
    private final TextWatcher fatWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {

            if (s.toString().isEmpty()){
                return;
            }

            try {
                double dblValue = Double.parseDouble(s.toString());
                if (dblValue < 2.00) {

                    dblValue = 2.00;
                    String strValue = String.valueOf(dblValue);
                    editTextFat.setText(strValue);

                } else if (dblValue > 9.99) {

                    dblValue = 9.99;
                    String strValue = String.valueOf(dblValue);
                    editTextFat.setText(strValue);
                }
            } catch (Exception e) {}
        }
    };
    private final TextWatcher lrReadingWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            if (s.toString().isEmpty()){
                return;
            }

            try {
                double dblValue = Double.parseDouble(s.toString());
                if (dblValue < 14.00 || dblValue > 35.50) {

                   textViewLRReading.setText(getResources().getString(R.string.lr_alert_text));
                    textViewLRReading.setTextColor(getResources().getColor(R.color.red));
                } else {
                    textViewLRReading.setText(getResources().getString(R.string.lr_reading));
                    textViewLRReading.setTextColor(getResources().getColor(R.color.black));
                }
            } catch (Exception e) {}
        }
    };
    private final TextWatcher temperatureWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {

            if (s.toString().isEmpty()){
                return;
            }

            try {
                int intValue = Integer.parseInt(s.toString());
                if (intValue < 4) {

                    intValue = 4;
                    String strValue = String.valueOf(intValue);
                    editTextTemperature.setText(strValue);

                } else if (intValue > 40) {

                    intValue = 40;
                    String strValue = String.valueOf(intValue);
                    editTextTemperature.setText(strValue);
                }
            } catch (Exception e) {}
        }
    };

}

