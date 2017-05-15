package com.e2esp.nestlemilkmanagementsystem.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.e2esp.nestlemilkmanagementsystem.R;

/**
 * Created by Asad on 5/15/2017.
 */

public class MilkAndQuality extends Fragment {

    TextView textViewVolumeMAQ, textViewFatMAQ, textViewLRReadingMAQ, textViewTemperatureMAQ;
    EditText editTextVolumeMAQ, editTextFatMAQ, editTextLRReadingMAQ, editTextTemperatureMAQ;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_milk_and_quality, container, false);
        getReferences(view);
        addAfterTextChangedListener();
        return view;
    }

    private void getReferences(View view){
        textViewVolumeMAQ = (TextView) view.findViewById(R.id.textViewVolumeMAQ);
        textViewFatMAQ = (TextView) view.findViewById(R.id.textViewFatMAQ);
        textViewLRReadingMAQ = (TextView) view.findViewById(R.id.textViewLRReadingMAQ);
        textViewTemperatureMAQ = (TextView) view.findViewById(R.id.textViewTemperatureMAQ);

        editTextVolumeMAQ = (EditText) view.findViewById(R.id.editTextVolumeMAQ);
        editTextFatMAQ = (EditText) view.findViewById(R.id.editTextFatMAQ);
        editTextLRReadingMAQ = (EditText) view.findViewById(R.id.editTextLRReadingMAQ);
        editTextTemperatureMAQ = (EditText) view.findViewById(R.id.editTextTemperatureMAQ);
    }

    private void addAfterTextChangedListener(){
        editTextVolumeMAQ.addTextChangedListener(volumeMAQWatcher);
        editTextFatMAQ.addTextChangedListener(fatMAQWatcher);
        editTextLRReadingMAQ.addTextChangedListener(lrReadingMAQWatcher);
        editTextTemperatureMAQ.addTextChangedListener(temperatureMAQWatcher);

    }

    private final TextWatcher volumeMAQWatcher = new TextWatcher() {
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
                if (dblValue < .5 || dblValue > 99999999.50) {

                    textViewVolumeMAQ.setText(getResources().getString(R.string.vol_alert_text));
                    textViewVolumeMAQ.setTextColor(getResources().getColor(R.color.red));
                } else {
                    textViewVolumeMAQ.setText(getResources().getString(R.string.volume));
                    textViewVolumeMAQ.setTextColor(getResources().getColor(R.color.black));
                }
            } catch (Exception e) {}
        }
    };

    private final TextWatcher fatMAQWatcher = new TextWatcher() {
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
                if (dblValue < 2 || dblValue > 9.99) {

                    textViewFatMAQ.setText(getResources().getString(R.string.fat_alert_text));
                    textViewFatMAQ.setTextColor(getResources().getColor(R.color.red));
                } else {
                    textViewFatMAQ.setText(getResources().getString(R.string.fat));
                    textViewFatMAQ.setTextColor(getResources().getColor(R.color.black));
                }
            } catch (Exception e) {}
        }
    };

    private final TextWatcher lrReadingMAQWatcher = new TextWatcher() {
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

                    textViewLRReadingMAQ.setText(getResources().getString(R.string.lr_alert_text));
                    textViewLRReadingMAQ.setTextColor(getResources().getColor(R.color.red));
                } else {
                    textViewLRReadingMAQ.setText(getResources().getString(R.string.lr_reading));
                    textViewLRReadingMAQ.setTextColor(getResources().getColor(R.color.black));
                }
            } catch (Exception e) {}
        }
    };

    private final TextWatcher temperatureMAQWatcher = new TextWatcher() {
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
                if (intValue < 4 || intValue > 40) {
                    textViewTemperatureMAQ.setText(getResources().getString(R.string.temp_alert_text));
                    textViewTemperatureMAQ.setTextColor(getResources().getColor(R.color.red));
                } else {
                    textViewTemperatureMAQ.setText(getResources().getString(R.string.temperature));
                    textViewTemperatureMAQ.setTextColor(getResources().getColor(R.color.black));
                }
            } catch (Exception e) {}
        }
    };
}
