package com.e2esp.nestlemilkmanagementsystem.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.e2esp.nestlemilkmanagementsystem.R;



/**
 * Created by Asad on 5/17/2017.
 */

public class RejectedOrAcceptedMilk extends Fragment {

    private TextView textViewVolumeRMQ, textViewFatRMQ, textViewLRReadingRMQ, textViewTemperatureRMQ;
    private EditText editTextVolumeRMQ, editTextFatRMQ, editTextLRReadingRMQ, editTextTemperatureRMQ;
    RadioGroup radioGroupRejectionQuestion, radioGroupRejectionType;
    RadioButton radioButtonYesRQ, radioButtonNoRQ, radioButtonFullRT, radioButtonPartialRT;
    LinearLayout rejectedMilkQuantityLayout, rejectionTypeLayout;
    boolean yesBtnCheck = true, partialBtnCheck = true;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rejected_or_accepted_milk, container, false);
        getReferences(view);
        onRadioButtonRQCheck();
        onRadioButtonRTCheck();
        addAfterTextChangedListener();
        return view;
    }

    public void getReferences(View view){
        /*textViewSelectedSheetNumEOD = (TextView) view.findViewById(R.id.textViewSelectedSheetNumEOD);
        textViewDisplayDateEOD = (TextView) view.findViewById(R.id.textViewDisplayDateEOD);
        textViewSelectedlocationCodeEOD = (TextView) view.findViewById(R.id.textViewSelectedlocationCodeEOD);
        textViewlocationNameEOD = (TextView) view.findViewById(R.id.textViewlocationNameEOD);
        textViewSelectedRegionEOD = (TextView) view.findViewById(R.id.textViewSelectedRegionEOD);*/

        textViewVolumeRMQ = (TextView) view.findViewById(R.id.textViewVolumeRMQ);
        textViewFatRMQ = (TextView) view.findViewById(R.id.textViewFatRMQ);
        textViewLRReadingRMQ = (TextView) view.findViewById(R.id.textViewLRReadingRMQ);
        textViewTemperatureRMQ = (TextView) view.findViewById(R.id.textViewTemperatureRMQ);

        editTextVolumeRMQ = (EditText) view.findViewById(R.id.editTextVolumeRMQ);
        editTextFatRMQ = (EditText) view.findViewById(R.id.editTextFatRMQ);
        editTextLRReadingRMQ = (EditText) view.findViewById(R.id.editTextLRReadingRMQ);
        editTextTemperatureRMQ = (EditText) view.findViewById(R.id.editTextTemperatureRMQ);


        radioGroupRejectionQuestion = (RadioGroup) view.findViewById(R.id.radioGroupRejectionQuestion);
        radioGroupRejectionType = (RadioGroup) view.findViewById(R.id.radioGroupRejectionType);
        radioButtonYesRQ = (RadioButton) view.findViewById(R.id.radioButtonYesRQ);
        radioButtonNoRQ = (RadioButton) view.findViewById(R.id.radioButtonNoRQ);
        radioButtonFullRT = (RadioButton) view.findViewById(R.id.radioButtonFullRT);
        radioButtonPartialRT = (RadioButton) view.findViewById(R.id.radioButtonPartialRT);
        rejectedMilkQuantityLayout = (LinearLayout) view.findViewById(R.id.rejectedMilkQuantityLayout);
        rejectionTypeLayout = (LinearLayout) view.findViewById(R.id.rejectionTypeLayout);
    }


    public void onRadioButtonRQCheck(){
        radioGroupRejectionQuestion.getCheckedRadioButtonId();
        radioGroupRejectionQuestion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.radioButtonYesRQ:
                        rejectionTypeLayout.setVisibility(View.VISIBLE);
                        yesBtnCheck = true;
                        break;

                    case R.id.radioButtonNoRQ:
                        rejectionTypeLayout.setVisibility(View.GONE);
                        yesBtnCheck = false;
                        break;
                }

            }
        });
    }


    public void onRadioButtonRTCheck(){
        radioGroupRejectionType.getCheckedRadioButtonId();
        radioGroupRejectionType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.radioButtonFullRT:
                        rejectedMilkQuantityLayout.setVisibility(View.GONE);
                        partialBtnCheck = false;
                        break;

                    case R.id.radioButtonPartialRT:
                        rejectedMilkQuantityLayout.setVisibility(View.VISIBLE);
                        partialBtnCheck = true;
                        break;
                }

            }
        });
    }

    private void addAfterTextChangedListener(){
        editTextVolumeRMQ.addTextChangedListener(volumeRMQWatcher);
        editTextFatRMQ.addTextChangedListener(fatRMQWatcher);
        editTextLRReadingRMQ.addTextChangedListener(lrReadingRMQWatcher);
        editTextTemperatureRMQ.addTextChangedListener(temperatureRMQWatcher);

    }


    private final TextWatcher volumeRMQWatcher = new TextWatcher() {
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

                    textViewVolumeRMQ.setText(getResources().getString(R.string.vol_alert_text));
                    textViewVolumeRMQ.setTextColor(getResources().getColor(R.color.red));
                } else {
                    textViewVolumeRMQ.setText(getResources().getString(R.string.volume));
                    textViewVolumeRMQ.setTextColor(getResources().getColor(R.color.black));
                }
            } catch (Exception e) {}
        }
    };

    private final TextWatcher fatRMQWatcher = new TextWatcher() {
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

                    textViewFatRMQ.setText(getResources().getString(R.string.fat_alert_text));
                    textViewFatRMQ.setTextColor(getResources().getColor(R.color.red));
                } else {
                    textViewFatRMQ.setText(getResources().getString(R.string.fat));
                    textViewFatRMQ.setTextColor(getResources().getColor(R.color.black));
                }
            } catch (Exception e) {}
        }
    };

    private final TextWatcher lrReadingRMQWatcher = new TextWatcher() {
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

                    textViewLRReadingRMQ.setText(getResources().getString(R.string.lr_alert_text));
                    textViewLRReadingRMQ.setTextColor(getResources().getColor(R.color.red));
                } else {
                    textViewLRReadingRMQ.setText(getResources().getString(R.string.lr_reading));
                    textViewLRReadingRMQ.setTextColor(getResources().getColor(R.color.black));
                }
            } catch (Exception e) {}
        }
    };

    private final TextWatcher temperatureRMQWatcher = new TextWatcher() {
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
                    textViewTemperatureRMQ.setText(getResources().getString(R.string.temp_alert_text));
                    textViewTemperatureRMQ.setTextColor(getResources().getColor(R.color.red));
                } else {
                    textViewTemperatureRMQ.setText(getResources().getString(R.string.temperature));
                    textViewTemperatureRMQ.setTextColor(getResources().getColor(R.color.black));
                }
            } catch (Exception e) {}
        }
    };
}
