package com.example.mukt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class AddJobActivity extends AppCompatActivity {

    AutoCompleteTextView orgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);

        orgs = findViewById(R.id.edittext_orgs);
        ArrayList<String> list = new ArrayList<>();
        list.add("NMBA");
        list.add("NCB");
        list.add("PMO");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.layout_dropdown,list);
        orgs.setAdapter(arrayAdapter);
    }
}