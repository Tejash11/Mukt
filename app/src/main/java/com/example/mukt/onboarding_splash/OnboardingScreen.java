package com.example.mukt.onboarding_splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mukt.R;
import com.example.mukt.signup_login.SignUp;

public class OnboardingScreen extends AppCompatActivity {
    LinearLayout getstartedbtn;
    ImageView mark1, mark2, mark3 , mark4, nextbtn, backbtn;
    int count = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_screen);

        //Referencing views
        nextbtn = (ImageView) findViewById(R.id.nextbtn);
        backbtn = (ImageView) findViewById(R.id.backbtn);

        mark1 = (ImageView) findViewById(R.id.mark1);
        mark2 = (ImageView) findViewById(R.id.mark2);
        mark3 = (ImageView) findViewById(R.id.mark3);
        mark4 = (ImageView) findViewById(R.id.mark4);





        //Inflating first fragment bydefault
        FragmentManager m = getSupportFragmentManager();
        FragmentTransaction t = m.beginTransaction();
        Fragment Home = new Onboarding1();
        t.replace(R.id.onboard_frag, Home);
        t.commit();



        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), " "+count, Toast.LENGTH_SHORT).show();

                if(count == 1)
                {
                    FragmentManager m = getSupportFragmentManager();
                    FragmentTransaction t = m.beginTransaction();
                    Fragment Home = new Onboarding2();
                    t.replace(R.id.onboard_frag, Home);
                    t.commit();
                    count = 2;

                    mark2.setImageResource(R.drawable.onboarding_mark);
                    mark3.setImageResource(R.drawable.onboarding_markoutline);
                    mark4.setImageResource(R.drawable.onboarding_markoutline);



                }
//                else if(count == 2)
//                {
//                    FragmentManager m = getSupportFragmentManager();
//                    FragmentTransaction t = m.beginTransaction();
//                    Fragment Home = new Onboarding3();
//                    t.replace(R.id.onboard_frag, Home);
//                    t.commit();
//                    count = 3;
//
//                    mark2.setImageResource(R.drawable.onboarding_mark);
//                    mark3.setImageResource(R.drawable.onboarding_mark);
//                    mark4.setImageResource(R.drawable.onboarding_markoutline);
//
//                }
//                else if(count == 3)
//                {
//                    FragmentManager m = getSupportFragmentManager();
//                    FragmentTransaction t = m.beginTransaction();
//                    Fragment Home = new Onboarding4();
//                    //Home.setArguments(bundle);
//                    t.replace(R.id.onboard_frag, Home);
//                    t.commit();
//
//                    mark2.setImageResource(R.drawable.onboarding_mark);
//                    mark3.setImageResource(R.drawable.onboarding_mark);
//                    mark4.setImageResource(R.drawable.onboarding_mark);
//                    count = 4;
//
//                }
//                else if(count == 4)
//                {
//
//                    //Toast.makeText(getApplicationContext(), "Cannot move", Toast.LENGTH_SHORT).show();
//                }


            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(count == 1)
                {

                }
                else if(count == 2)
                {
                    FragmentManager m = getSupportFragmentManager();
                    FragmentTransaction t = m.beginTransaction();
                    Fragment Home = new Onboarding2();
                    t.replace(R.id.onboard_frag, Home);
                    t.commit();

                    count = 1;

                    mark2.setImageResource(R.drawable.onboarding_markoutline);
                    mark3.setImageResource(R.drawable.onboarding_markoutline);
                    mark4.setImageResource(R.drawable.onboarding_markoutline);
                }
                else if(count == 3)
                {
                    FragmentManager m = getSupportFragmentManager();
                    FragmentTransaction t = m.beginTransaction();
                    Fragment Home = new Onboarding2();
                    t.replace(R.id.onboard_frag, Home);
                    t.commit();
                    count = 2;

                    mark2.setImageResource(R.drawable.onboarding_mark);
                    mark3.setImageResource(R.drawable.onboarding_markoutline);
                    mark4.setImageResource(R.drawable.onboarding_markoutline);
                }


            }
        });


        getstartedbtn = findViewById(R.id.getstartedbutton);
        getstartedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OnboardingScreen.this, SignUp.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
            }
        });
    }
}