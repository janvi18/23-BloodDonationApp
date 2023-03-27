package com.blooddonationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.blooddonationapp.utils.Utils;
import com.blooddonationapp.utils.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.ls_User_listview);

        GetDonorsApi();
    }

    private void GetDonorsApi() {
        ArrayList<DonorLangModel> arrayList = new ArrayList<DonorLangModel>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utils.DONOR_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    //bubble sort
                    for (int i = 0; i < jsonArray.length(); i++) {
                        for (int j = 0; j < jsonArray.length() - 1; j++) {
                            if (jsonArray.getJSONObject(j).getString("userName").compareTo(jsonArray.getJSONObject(j + 1).getString("userName")) > 0) {
                                JSONObject tmp = jsonArray.getJSONObject(j);
                                jsonArray.put(j, jsonArray.getJSONObject(j + 1));
                                jsonArray.put(j + 1, tmp);

                            }
                        }
                    }

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        String strDonorId = jsonObject1.getString("_id");
                        String strUserName = jsonObject1.getString("userName");
                        String strContactNo = jsonObject1.getString("contactNo");
                        String strEmail = jsonObject1.getString("email");
                        String strPassword = jsonObject1.getString("password");
                        String strBtype = jsonObject1.getString("bloodType");


                        DonorLangModel donorLangModel = new DonorLangModel();
                        donorLangModel.set_id(strDonorId);
                        donorLangModel.setUserName(strUserName);
                        donorLangModel.setContactNo(strContactNo);
                        donorLangModel.setBloodType(strBtype);
                        donorLangModel.setEmail(strEmail);
                        donorLangModel.setPassword(strPassword);
                        arrayList.add(donorLangModel);

                    }
                    DonorListAdapter donorListAdapter = new DonorListAdapter(MainActivity.this, arrayList);
                    listview.setAdapter(donorListAdapter);
                    donorListAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);

    }
}