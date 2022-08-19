package com.example.mukt.signup_onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mukt.R;

public class SelectInterest extends AppCompatActivity {

    LinearLayout music, food, sports, tech, art, fitness;
    boolean[] selection = new boolean[6];
    TextView nextbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_interest);

        music = (LinearLayout) findViewById(R.id.music_select);
        food = (LinearLayout) findViewById(R.id.food_select);
        sports = (LinearLayout) findViewById(R.id.sports_select);
        tech = (LinearLayout) findViewById(R.id.tech_select);
        art = (LinearLayout) findViewById(R.id.art_select);
        fitness = (LinearLayout) findViewById(R.id.fitness_select);

        nextbtn = (TextView) findViewById(R.id.next_btn);

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selection[0] == false)
                {
                    music.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.circular_blue_border));
                    selection[0] = true;
                }
                else
                {
                    music.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.circular_background_blackline));
                    selection[0] = false;
                }
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selection[1] == false)
                {
                    food.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.circular_blue_border));
                    selection[1] = true;
                }
                else
                {
                    food.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.circular_background_blackline));
                    selection[1] = false;
                }
            }
        });

        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selection[2] == false)
                {
                    sports.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.circular_blue_border));
                    selection[2] = true;
                }
                else
                {
                    sports.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.circular_background_blackline));
                    selection[2] = false;
                }
            }
        });

        tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selection[3] == false)
                {
                    tech.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.circular_blue_border));
                    selection[3] = true;
                }
                else
                {
                    tech.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.circular_background_blackline));
                    selection[3] = false;
                }
            }
        });

        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selection[4] == false)
                {
                    art.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.circular_blue_border));
                    selection[4] = true;
                }
                else
                {
                    art.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.circular_background_blackline));
                    selection[4] = false;
                }
            }
        });

        fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selection[5] == false)
                {
                    fitness.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.circular_blue_border));
                    selection[5] = true;
                }
                else
                {
                    fitness.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.circular_background_blackline));
                    selection[5] = false;
                }
            }
        });


        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectInterest.this, MapsActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
            }
        });





    }
}