package com.blooddonationapp;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonalListAdapter extends BaseAdapter {
    Context context;
    ArrayList<PersonalLangModel> personalLangModelArrayList;

    public PersonalListAdapter(Context context, ArrayList<PersonalLangModel> personalLangModelArrayList) {
        this.context = context;
        this.personalLangModelArrayList = personalLangModelArrayList;
    }

    @Override
    public int getCount() {
        return personalLangModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return personalLangModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.personalinfo_table, null);

        TextView tv_Uname, tv_cntNo, tvBtype, tvEmail, tvPassword;
        tv_Uname = view.findViewById(R.id.uname);
        tv_cntNo = view.findViewById(R.id.tv_cntNo);
        tvBtype = view.findViewById(R.id.tv_btype);
        tvEmail = view.findViewById(R.id.tv_email);
        tvPassword = view.findViewById(R.id.tv_pwd);

        tv_Uname.setText(personalLangModelArrayList.get(position).getUserName());
        tv_cntNo.setText(personalLangModelArrayList.get(position).getContactNo());
        tvBtype.setText(personalLangModelArrayList.get(position).getBloodType());
        tvEmail.setText(personalLangModelArrayList.get(position).getEmail());
        tvPassword.setText(personalLangModelArrayList.get(position).getPassword());


        return view;
    }
}