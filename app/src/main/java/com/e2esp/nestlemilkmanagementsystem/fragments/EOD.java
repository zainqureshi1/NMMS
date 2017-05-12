package com.e2esp.nestlemilkmanagementsystem.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
 * Created by Asad on 5/11/2017.
 */

public class EOD extends Fragment {

    TextView textViewSelectedSheetNumEOD, textViewDisplayDateEOD, textViewSelectedlocationCodeEOD, textViewlocationNameEOD, textViewSelectedRegionEOD,
             textViewVolumeEOD, textViewFatEOD, textViewLRReadingEOD, textViewTemperatureEOD;
    EditText editTextVolumeEOD, editTextFatEOD, editTextLRReadingEOD, editTextTemperatureEOD;
    RadioGroup radioGroupLOMQuestion;
    RadioButton radioButtonYes, radioButtonNo;
    LinearLayout endOfDayYesButtonLayout;
    boolean yesBtnCheck = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_end_of_day, container, false);
        getReferences(view);
        addAfterTextChangedListener();
        onRadioButtonCheck();

        return view;
    }

    public void getReferences(View view){
        textViewSelectedSheetNumEOD = (TextView) view.findViewById(R.id.textViewSelectedSheetNumEOD);
        textViewDisplayDateEOD = (TextView) view.findViewById(R.id.textViewDisplayDateEOD);
        textViewSelectedlocationCodeEOD = (TextView) view.findViewById(R.id.textViewSelectedlocationCodeEOD);
        textViewlocationNameEOD = (TextView) view.findViewById(R.id.textViewlocationNameEOD);
        textViewSelectedRegionEOD = (TextView) view.findViewById(R.id.textViewSelectedRegionEOD);

        textViewVolumeEOD = (TextView) view.findViewById(R.id.textViewVolumeEOD);
        textViewFatEOD = (TextView) view.findViewById(R.id.textViewFatEOD);
        textViewLRReadingEOD = (TextView) view.findViewById(R.id.textViewLRReadingEOD);
        textViewTemperatureEOD = (TextView) view.findViewById(R.id.textViewTemperatureEOD);

        editTextVolumeEOD = (EditText) view.findViewById(R.id.editTextVolumeEOD);
        editTextFatEOD = (EditText) view.findViewById(R.id.editTextFatEOD);
        editTextLRReadingEOD = (EditText) view.findViewById(R.id.editTextLRReadingEOD);
        editTextTemperatureEOD = (EditText) view.findViewById(R.id.editTextTemperatureEOD);

        endOfDayYesButtonLayout = (LinearLayout) view.findViewById(R.id.endOfDayYesButtonLayout);
        radioGroupLOMQuestion = (RadioGroup) view.findViewById(R.id.radioGroupLOMQuestion);
        radioButtonYes = (RadioButton) view.findViewById(R.id.radioButtonYes);
        radioButtonNo = (RadioButton) view.findViewById(R.id.radioButtonNo);
    }


    public void onRadioButtonCheck(){
        radioGroupLOMQuestion.getCheckedRadioButtonId();
        radioGroupLOMQuestion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.radioButtonYes:
                            endOfDayYesButtonLayout.setVisibility(View.VISIBLE);
                            yesBtnCheck = true;
                        break;

                    case R.id.radioButtonNo:
                            endOfDayYesButtonLayout.setVisibility(View.GONE);
                            yesBtnCheck = false;
                        break;
                }

            }
        });
    }

    private void addAfterTextChangedListener(){
        editTextVolumeEOD.addTextChangedListener(volumeEODWatcher);
        editTextFatEOD.addTextChangedListener(fatEODWatcher);
        editTextLRReadingEOD.addTextChangedListener(lrReadingEODWatcher);
        editTextTemperatureEOD.addTextChangedListener(temperatureEODWatcher);

    }


    private final TextWatcher volumeEODWatcher = new TextWatcher() {
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

                    textViewVolumeEOD.setText(getResources().getString(R.string.vol_alert_text));
                    textViewVolumeEOD.setTextColor(getResources().getColor(R.color.red));
                } else {
                    textViewVolumeEOD.setText(getResources().getString(R.string.volume));
                    textViewVolumeEOD.setTextColor(getResources().getColor(R.color.black));
                }
            } catch (Exception e) {}
        }
    };

    private final TextWatcher fatEODWatcher = new TextWatcher() {
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

                    textViewFatEOD.setText(getResources().getString(R.string.fat_alert_text));
                    textViewFatEOD.setTextColor(getResources().getColor(R.color.red));
                } else {
                    textViewFatEOD.setText(getResources().getString(R.string.fat));
                    textViewFatEOD.setTextColor(getResources().getColor(R.color.black));
                }
            } catch (Exception e) {}
        }
    };

    private final TextWatcher lrReadingEODWatcher = new TextWatcher() {
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

                    textViewLRReadingEOD.setText(getResources().getString(R.string.lr_alert_text));
                    textViewLRReadingEOD.setTextColor(getResources().getColor(R.color.red));
                } else {
                    textViewLRReadingEOD.setText(getResources().getString(R.string.lr_reading));
                    textViewLRReadingEOD.setTextColor(getResources().getColor(R.color.black));
                }
            } catch (Exception e) {}
        }
    };

    private final TextWatcher temperatureEODWatcher = new TextWatcher() {
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
                    textViewTemperatureEOD.setText(getResources().getString(R.string.temp_alert_text));
                    textViewTemperatureEOD.setTextColor(getResources().getColor(R.color.red));
                    } else {
                    textViewTemperatureEOD.setText(getResources().getString(R.string.temperature));
                    textViewTemperatureEOD.setTextColor(getResources().getColor(R.color.black));
                }
            } catch (Exception e) {}
        }
    };


}
