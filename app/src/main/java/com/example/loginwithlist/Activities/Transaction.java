package com.example.loginwithlist.Activities;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import android.widget.Switch;


import com.example.loginwithlist.Fragments.LogIn;
import com.example.loginwithlist.Fragments.Trans;
import com.example.loginwithlist.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Transaction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        String frag = getIntent().getExtras().getString("FRAG");

        if(frag.contains("trans")){
        replacefragment(new Trans(), getIntent().getExtras());
        }
    }

    public  void replacefragment(Fragment fragment , Bundle bundle){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        fragment.setArguments(bundle);
        ft.add(R.id.your_placeholder, fragment);
        ft.commit();
    }
}
