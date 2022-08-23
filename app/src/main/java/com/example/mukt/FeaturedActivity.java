package com.example.mukt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class FeaturedActivity extends AppCompatActivity {

    ImageView backbtn;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featured);

        backbtn = findViewById(R.id.backbutton);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FeaturedActivity.this,MainActivity.class);
                startActivity(i);

            }
        });

        recyclerView = findViewById(R.id.feature_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Feature_model> arrayListFeature = new ArrayList<>();
        arrayListFeature.add(new Feature_model(R.drawable.featuredpost,1));
        arrayListFeature.add(new Feature_model(R.drawable.featuredpost2,2));
        arrayListFeature.add(new Feature_model(R.drawable.featuredpost3,3));
        arrayListFeature.add(new Feature_model(R.drawable.featuredpost2,4));
        arrayListFeature.add(new Feature_model(R.drawable.featuredpost3,5));
        arrayListFeature.add(new Feature_model(R.drawable.featuredpost,6));
        arrayListFeature.add(new Feature_model(R.drawable.featuredpost3,7));
        arrayListFeature.add(new Feature_model(R.drawable.featuredpost2,8));


        FeatureAdapter adapter = new FeatureAdapter(this,arrayListFeature);

        recyclerView.setAdapter(adapter);
    }
}