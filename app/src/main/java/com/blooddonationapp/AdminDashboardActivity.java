package com.blooddonationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AdminDashboardActivity extends AppCompatActivity {

    GridView listView;
    String strData[] = {"Donors List", "Search Donors", "Donor History"};
    int imgData[] = {R.drawable.personal, R.drawable.search, R.drawable.history};
    FloatingActionButton floatingActionButton;


    ArrayList<LangModel> langModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        floatingActionButton = findViewById(R.id.btn_admin_logout);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminDashboardActivity.this, SplashActivity.class);
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
                    Intent intent = new Intent(AdminDashboardActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (i == 1) {
                    Intent intent = new Intent(AdminDashboardActivity.this, SearchActivity.class);
                    startActivity(intent);
                } else if (i == 2) {
                    Intent intent = new Intent(AdminDashboardActivity.this, DonorHistoryActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}