package com.e2esp.nestlemilkmanagementsystem.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e2esp.nestlemilkmanagementsystem.R;

/**
 * Created by Asad on 5/4/2017.
 */

public class ViewMRNDetails extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_mrn_details, container, false);
    }
}
