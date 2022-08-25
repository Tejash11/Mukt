package com.example.mukt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class activity_applications extends AppCompatActivity {

    Fragment main;
    Fragment details;
    CardView apply;
    ImageView add;

    public void ChangeToDetailsFragment(JobClass1 job1){
        details = new Application_Fragment2(job1);
        apply = findViewById(R.id.apply);
        apply.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.Frag_container,details,null).commit();

    }
    public void ChangeToDetailsFragment(JobClass2 job2){
        details = new Application_Fragment2(job2);
        apply = findViewById(R.id.apply);
        apply.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.Frag_container,details,null).commit();

    }

    public void ChangeToMainFragment(){
        main = new Application_Fragment1();
        apply = findViewById(R.id.apply);
        apply.setVisibility(View.GONE);
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.Frag_container,main,null).commit();

    }

ImageView backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applications);

        apply = findViewById(R.id.apply);
        apply.setVisibility(View.GONE);
        main = new Application_Fragment1();

        backbutton = findViewById(R.id.backbutton_applications);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(activity_applications.this,MainActivity.class);
                startActivity(i);
            }
        });
        RecyclerView rcv1 = findViewById(R.id.application_recycler1);


        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.Frag_container,main,null).commit();


        apply = findViewById(R.id.apply);
        apply.setVisibility(View.GONE);
        main = new Application_Fragment1();

        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.Frag_container,main,null).commit();


        add = findViewById(R.id.addbutton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_applications.this,AddJobActivity.class);
                startActivity(intent);
            }
        });





    }


}