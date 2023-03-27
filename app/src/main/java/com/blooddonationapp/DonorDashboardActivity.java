package com.blooddonationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DonorDashboardActivity extends AppCompatActivity {

    GridView listView;
    String strData[] = {"Personal Information"};
    int imgData[] = {R.drawable.personal};
    FloatingActionButton floatingActionButton;

    ArrayList<LangModel> langModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_dashboard);

        floatingActionButton = findViewById(R.id.btn_donor_logout);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DonorDashboardActivity.this, SplashActivity.class);
                startActivity(i);
            }
        });

        listView = findViewById(R.id.grid_view);
        langModelArrayList = new ArrayList<LangModel>();

        for (int i = 0; i < strData.length; i++) {
            LangModel langModel = new LangModel(strData[i], imgData[i]);
            langModelArrayList.add(langModel);
        }


        MyListAdapter myListAdapter = new MyListAdapter(this, langModelArrayList);
        listView.setAdapter(myListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(DonorDashboardActivity.this, PersonalInformationActivity.class);
                    startActivity(intent);
                } else if (i == 1){
                    Intent intent = new Intent(DonorDashboardActivity.this, DonorHistoryDisplayActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}