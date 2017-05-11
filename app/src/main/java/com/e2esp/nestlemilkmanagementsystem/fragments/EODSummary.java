package com.e2esp.nestlemilkmanagementsystem.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.e2esp.nestlemilkmanagementsystem.R;

/**
 * Created by Asad on 5/11/2017.
 */

public class EODSummary extends Fragment {

    TextView textViewSelectedSheetNumEODSummary, textViewSelectedlocationCodeEODSummary, textViewlocationNameEODSummary, textViewSelectedRegionEODSummary,
             textViewSelectedVolumePreviousDayLOM, textViewSelectedFatPreviousDayLOM, textViewSelectedAdjustedLRPreviousDayLOM,
             textViewSelectedVolumeTMP, textViewSelectedFatTMP, textViewSelectedAdjustedLRTMP,
             textViewSelectedVolumeCurrentDayLOM, textViewSelectedFatCurrentDayLOM, textViewSelectedAdjustedLRCurrentDayLOM;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eod_summary, container, false);
        getReferences(view);
        return view;
    }

    private void getReferences(View view){
        textViewSelectedSheetNumEODSummary = (TextView) view.findViewById(R.id.textViewSelectedSheetNumEODSummary);
        textViewSelectedlocationCodeEODSummary = (TextView) view.findViewById(R.id.textViewSelectedlocationCodeEODSummary);
        textViewlocationNameEODSummary = (TextView) view.findViewById(R.id.textViewlocationNameEODSummary);
        textViewSelectedRegionEODSummary = (TextView) view.findViewById(R.id.textViewSelectedRegionEODSummary);

        //References of Previous Day Left Over Milk
        textViewSelectedVolumePreviousDayLOM = (TextView) view.findViewById(R.id.textViewSelectedVolumePreviousDayLOM);
        textViewSelectedFatPreviousDayLOM = (TextView) view.findViewById(R.id.textViewSelectedFatPreviousDayLOM);
        textViewSelectedAdjustedLRPreviousDayLOM = (TextView) view.findViewById(R.id.textViewSelectedAdjustedLRPreviousDayLOM);

        //References of Today Milk Purchased
        textViewSelectedVolumeTMP = (TextView) view.findViewById(R.id.textViewSelectedVolumeTMP);
        textViewSelectedFatTMP = (TextView) view.findViewById(R.id.textViewSelectedFatTMP);
        textViewSelectedAdjustedLRTMP = (TextView) view.findViewById(R.id.textViewSelectedAdjustedLRTMP);

        //References of Current Day Left Over Milk
        textViewSelectedVolumeCurrentDayLOM = (TextView) view.findViewById(R.id.textViewSelectedVolumeCurrentDayLOM);
        textViewSelectedFatCurrentDayLOM = (TextView) view.findViewById(R.id.textViewSelectedFatCurrentDayLOM);
        textViewSelectedAdjustedLRCurrentDayLOM = (TextView) view.findViewById(R.id.textViewSelectedAdjustedLRCurrentDayLOM);
    }
}
