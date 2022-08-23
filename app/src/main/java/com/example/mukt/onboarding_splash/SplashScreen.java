package com.example.mukt.onboarding_splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.mukt.MainActivity;
import com.example.mukt.R;

public class SplashScreen extends AppCompatActivity {

    final private static int SPLASH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intents=new Intent(SplashScreen.this, MainActivity.class);
                //intents.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intents.putExtra("direction", "home");
                startActivity(intents);
                finish();
            }
        },SPLASH);
    }
}