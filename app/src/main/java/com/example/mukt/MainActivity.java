package com.example.mukt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mukt.event_section.Event;
import com.example.mukt.profile_section.Profile;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = this.getIntent();

        ImageView homebtn = (ImageView) findViewById(R.id.homebtn);
        ImageView bazaarbtn = (ImageView) findViewById(R.id.shopbtn);
        ImageView eventbtn = (ImageView) findViewById(R.id.eventbtn);
        ImageView userbtn = (ImageView) findViewById(R.id.userbtn);
        FloatingActionButton dumbbellbtn = (FloatingActionButton) findViewById(R.id.dumbbellbtn);

        if(i.getStringExtra("direction").equals("event"))
        {
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction t = m.beginTransaction();
            Fragment events = new Event("Nukkad Natak");
            t.replace(R.id.fragment, events);
            t.disallowAddToBackStack().commit();
            homebtn.setImageResource(R.drawable.homeoutline);
            bazaarbtn.setImageResource(R.drawable.homecolor);
            // communitybtn.setImageResource(R.drawable.heart_colour);
            userbtn.setImageResource(R.drawable.useroutline);
        }
        else
        {
            FragmentManager m = getSupportFragmentManager();
            FragmentTransaction t = m.beginTransaction();
            Fragment Home = new Home();
            t.replace(R.id.fragment,Home);
            t.commit();
            homebtn.setImageResource(R.drawable.homecolor);
        }


        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager m = getSupportFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                Fragment Home = new Home();
                t.replace(R.id.fragment, Home);
                t.disallowAddToBackStack().commit();
                homebtn.setImageResource(R.drawable.homecolor);
//                bazaarbtn.setImageResource(R.drawable.shopoutline);
                eventbtn.setImageResource(R.drawable.homeoutline);
                userbtn.setImageResource(R.drawable.useroutline);
            }
        });

        eventbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager m = getSupportFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                Fragment events = new Event("Nukkad Natak");
                t.replace(R.id.fragment, events);
                t.disallowAddToBackStack().commit();
                homebtn.setImageResource(R.drawable.homeoutline);
                bazaarbtn.setImageResource(R.drawable.homecolor);
               // communitybtn.setImageResource(R.drawable.heart_colour);
                userbtn.setImageResource(R.drawable.useroutline);
            }
        });
//
//        bazaarbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager m = getSupportFragmentManager();
//                FragmentTransaction t = m.beginTransaction();
//                Fragment bazaar = new Bazaar();
//                t.replace(R.id.fragment, bazaar);
//                t.commit();
//                homebtn.setImageResource(R.drawable.homeoutline);
//                bazaarbtn.setImageResource(R.drawable.shopcolor);
//                communitybtn.setImageResource(R.drawable.heart);
//                userbtn.setImageResource(R.drawable.useroutline);
//            }
//        });


        userbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager m = getSupportFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                Fragment user = new Profile();
                t.replace(R.id.fragment, user);
                t.commit();
                homebtn.setImageResource(R.drawable.homeoutline);
                //bazaarbtn.setImageResource(R.drawable.shopoutline);
                //communitybtn.setImageResource(R.drawable.heart);
                userbtn.setImageResource(R.drawable.usercolor);
            }
        });
//
//        dumbbellbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,FitnessReels.class);
//                startActivity(i);
//                homebtn.setImageResource(R.drawable.homeoutline);
//                bazaarbtn.setImageResource(R.drawable.shopoutline);
//                communitybtn.setImageResource(R.drawable.heart);
//                userbtn.setImageResource(R.drawable.useroutline);
//            }
//        });
    }
}

