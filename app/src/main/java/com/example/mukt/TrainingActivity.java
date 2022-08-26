package com.example.mukt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class TrainingActivity extends AppCompatActivity {
    Fragment training1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        training1 = new TrainingExploreFragment();
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.Frag_container2,training1,null).commit();


    }
}