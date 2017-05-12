package com.e2esp.nestlemilkmanagementsystem.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.e2esp.nestlemilkmanagementsystem.R;
import com.e2esp.nestlemilkmanagementsystem.models.MRNsList;

import java.util.ArrayList;

/**
 * Created by Asad on 5/12/2017.
 */

public class SubmittedMRNsAdapter extends ArrayAdapter<MRNsList> {

    public SubmittedMRNsAdapter(Context context, ArrayList<MRNsList> mrnList) {
        super(context, 0, mrnList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MRNsList mrnsList = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_items_submitted_mrns, parent, false);
        }
        // Lookup view for data population
        TextView textViewItemMRNNumber = (TextView) convertView.findViewById(R.id.textViewItemMRNNumber);
        TextView textViewItemSupplier = (TextView) convertView.findViewById(R.id.textViewItemSupplier);
        TextView textViewItemVol = (TextView) convertView.findViewById(R.id.textViewItemVol);
        TextView textViewItemFat = (TextView) convertView.findViewById(R.id.textViewItemFat);
        TextView textViewItemLR = (TextView) convertView.findViewById(R.id.textViewItemLR);
        TextView textViewItemStatus = (TextView) convertView.findViewById(R.id.textViewItemStatus);

        // Populate the data into the template view using the data object

        textViewItemMRNNumber.setText(mrnsList.getMrnNum());
        textViewItemSupplier.setText(mrnsList.getSupplier());
        textViewItemVol.setText(mrnsList.getVol()+"");
        textViewItemFat.setText(mrnsList.getFat()+"");
        textViewItemLR.setText(mrnsList.getLr()+"");
        textViewItemStatus.setText(mrnsList.getStatus());
        // Return the completed view to render on screen
        return convertView;
    }
}
