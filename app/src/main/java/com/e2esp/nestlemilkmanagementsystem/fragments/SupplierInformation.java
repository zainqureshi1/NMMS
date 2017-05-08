package com.e2esp.nestlemilkmanagementsystem.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e2esp.nestlemilkmanagementsystem.R;
import com.e2esp.nestlemilkmanagementsystem.activities.CreateMRN;
import com.e2esp.nestlemilkmanagementsystem.activities.HomePage;

/**
 * Created by Asad on 5/3/2017.
 */

public class SupplierInformation extends Fragment{




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_supplier_information, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



}
