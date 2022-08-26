package com.example.mukt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Mukt_reels extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private List<Video> videoList;
    private VideoAdapter videoAdapter;
    ImageView backbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mukt_reels);

        backbutton = findViewById(R.id.backbtn);

        videoList = new ArrayList<>();
        viewPager2 = findViewById(R.id.viewpager2);

        // 3 4 7 9 10
        videoList.add(new Video("android.resource://" + getPackageName() + "/" + R.raw.video3, "", ""));
        videoList.add(new Video("android.resource://" + getPackageName() + "/" + R.raw.video4, "", ""));
        videoList.add(new Video("android.resource://" + getPackageName() + "/" + R.raw.video7, "", ""));
        videoList.add(new Video("android.resource://" + getPackageName() + "/" + R.raw.video9, "", ""));
        videoList.add(new Video("android.resource://" + getPackageName() + "/" + R.raw.video10, "", ""));
//        videoList.add(new Video("android.resource://" + getPackageName() + "/" + R.raw.video8, "", ""));
//        videoList.add(new Video("android.resource://" + getPackageName() + "/" + R.raw.video4, "", ""));
//        videoList.add(new Video("android.resource://" + getPackageName() + "/" + R.raw.video6, "", ""));
//        videoList.add(new Video("android.resource://" + getPackageName() + "/" + R.raw.video7, "", ""));
//        videoList.add(new Video("android.resource://" + getPackageName() + "/" + R.raw.video9, "", ""));

        videoAdapter = new VideoAdapter(videoList);
        viewPager2.setAdapter(videoAdapter);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mukt_reels.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}