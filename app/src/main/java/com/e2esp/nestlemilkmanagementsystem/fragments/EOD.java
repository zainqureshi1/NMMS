package com.e2esp.nestlemilkmanagementsystem.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.e2esp.nestlemilkmanagementsystem.R;

/**
 * Created by Asad on 5/11/2017.
 */

public class EOD extends Fragment {

    RadioButton radioButtonYes, radioButtonNo;
    LinearLayout endOfDayYesButtonLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_end_of_day, container, false);
        getReferences(view);
        addListenerOnRadioButtonYes();
        addListenerOnRadioButtonNo();
        return view;
    }

    private void getReferences(View view){

        endOfDayYesButtonLayout = (LinearLayout) view.findViewById(R.id.endOfDayYesButtonLayout);
        radioButtonYes = (RadioButton) view.findViewById(R.id.radioButtonYes);
        radioButtonNo = (RadioButton) view.findViewById(R.id.radioButtonNo);
    }

    private void addListenerOnRadioButtonYes(){
        radioButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButtonYes.isChecked()) {
                    endOfDayYesButtonLayout.setVisibility(View.VISIBLE);
                }
                else {
                    endOfDayYesButtonLayout.setVisibility(View.GONE);
                }
            }
        });
    }

    private void addListenerOnRadioButtonNo(){
        radioButtonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButtonNo.isChecked()) {
                    endOfDayYesButtonLayout.setVisibility(View.GONE);
                }
                else {
                    endOfDayYesButtonLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}
