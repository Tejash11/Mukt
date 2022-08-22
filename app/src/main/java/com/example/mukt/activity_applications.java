package com.example.mukt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class activity_applications extends AppCompatActivity {
ImageView backbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applications);

        backbutton = findViewById(R.id.backbutton_applications);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(activity_applications.this,MainActivity.class);
                startActivity(i);
            }
        });
        RecyclerView rcv1 = findViewById(R.id.application_recycler1);

        ArrayList<JobClass1> jobs1 = new ArrayList<>();

        jobs1.add(new JobClass1(R.drawable.nmba_logo,"Content Writer",
                R.drawable.background_outlined_green,R.drawable.arrow_forward_green,
                R.color.green,R.color.green_trans));
        jobs1.add(new JobClass1(R.drawable.org_logo,"Event Manager",
                R.drawable.background_outlined_blue,R.drawable.arrow_forward_blue,
                R.color.blue,R.color.blue_trans));
        jobs1.add(new JobClass1(R.drawable.org_logo2,"Video Editor",
                R.drawable.background_outlined_red,R.drawable.arrow_forward_red,
                R.color.red,R.color.red_trans));
        jobs1.add(new JobClass1(R.drawable.org_logo3,"Volunteer",
                R.drawable.background_outlined_yellow,R.drawable.arrow_forward_yellow,
                R.color.yellow,R.color.yellow_trans));

        JobAdapter1 jobAdapter1 = new JobAdapter1(this,jobs1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        rcv1.setLayoutManager(linearLayoutManager);
        rcv1.setAdapter(jobAdapter1);

        rcv1.setNestedScrollingEnabled(false);
        rcv1.hasFixedSize();


        ArrayList<JobClass2> jobs2 = new ArrayList<>();

        jobs2.add(new JobClass2("Media Marketing",R.drawable.nmba_logo,"NMBA",1));
        jobs2.add(new JobClass2("Social Media Intern",R.drawable.org_logo3,"Navjeevan Rehab",2));
        jobs2.add(new JobClass2("Content Creator",R.drawable.nmba_logo,"NMBA",3));
        jobs2.add(new JobClass2("Backend Developer",R.drawable.org_logo2,"NCB",4));
        jobs2.add(new JobClass2("Accounts Intern",R.drawable.org_logo,"Jagruti Rehab",5));


        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        JobAdapter2 jobAdapter2 = new JobAdapter2(jobs2,this);

        RecyclerView rcv2 = findViewById(R.id.application_recycler2);
        rcv2.setNestedScrollingEnabled(false);
        rcv2.hasFixedSize();

        rcv2.setLayoutManager(linearLayoutManager1);
        rcv2.setAdapter(jobAdapter2);




        RecyclerView rcv3 = findViewById(R.id.application_recycler3);

        ArrayList<Task> tasks= new ArrayList<>();

        tasks.add(new Task("Share 500 posts",1,500,430));
        tasks.add(new Task("Invite 10 friends",2,10,8));
        tasks.add(new Task("Attend 3 events",3,3,2));
        tasks.add(new Task("Organize an event",4,1,0));

        TaskAdapter taskAdapter = new TaskAdapter(tasks,this);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        rcv3.setLayoutManager(linearLayoutManager2);
        rcv3.setAdapter(taskAdapter);

        rcv3.setNestedScrollingEnabled(false);
        rcv3.hasFixedSize();

    }
}