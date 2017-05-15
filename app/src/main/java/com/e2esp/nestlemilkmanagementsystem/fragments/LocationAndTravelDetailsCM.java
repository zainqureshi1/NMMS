package com.e2esp.nestlemilkmanagementsystem.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.e2esp.nestlemilkmanagementsystem.R;

/**
 * Created by Asad on 5/15/2017.
 */

public class LocationAndTravelDetailsCM extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location_and_travel_details_cm, container, false);
        getReferences(view);
        return view;
    }

    private void getReferences(View view){

    }
}
