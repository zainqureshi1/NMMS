package com.e2esp.nestlemilkmanagementsystem.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.e2esp.nestlemilkmanagementsystem.R;
import com.e2esp.nestlemilkmanagementsystem.adapters.SubmittedMRNsAdapter;
import com.e2esp.nestlemilkmanagementsystem.models.MRNsList;

import java.util.ArrayList;


public class SubmittedMRNs extends AppCompatActivity {

    private ListView submittedMRNsListView;
    private AppCompatButton submittedMRNsBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submitted_mrns);

        getReferences();
        onButtonSubmittedMRNsBackClick();

        // Construct the data source
        ArrayList<MRNsList> arrayOfMRNs = new ArrayList<MRNsList>();
        // Create the adapter to convert the array to views
        SubmittedMRNsAdapter adapter = new SubmittedMRNsAdapter(this, arrayOfMRNs);
        // Attach the adapter to a ListView
        submittedMRNsListView = (ListView) findViewById(R.id.submittedMRNsListView);
        submittedMRNsListView.setAdapter(adapter);

        // Add item to adapter
        MRNsList newMRN = new MRNsList("PB02-006C-000001","00L636", 25, 2, 10.5, "A");
        adapter.add(newMRN);
        MRNsList newMRN2 = new MRNsList("PB02-006C-000002","00L637", 20, 5, 10.5, "A");
        adapter.add(newMRN2);

        submittedMRNsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(SubmittedMRNs.this,ViewMRNs.class);
                //based on item add info to intent
                startActivity(intent);
            }
        });

    }

    private void getReferences(){
        submittedMRNsListView = (ListView) findViewById(R.id.submittedMRNsListView);
        submittedMRNsBackButton = (AppCompatButton) findViewById(R.id.submittedMRNsBackButton);
    }

    private void onButtonSubmittedMRNsBackClick(){
        submittedMRNsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
