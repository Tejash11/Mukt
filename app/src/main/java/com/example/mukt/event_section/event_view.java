package com.example.mukt.event_section;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.example.mukt.MainActivity;
import com.example.mukt.R;

public class event_view extends AppCompatActivity {

    String event_name;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            onBackPressed();
            return true;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        //this is only needed if you have specific things
        //that you want to do when the user presses the back button.

        /* your specific things...*/

        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        i.putExtra("direction", "event");
        startActivity(i);

        super.onBackPressed();
    }

    public event_view()
    {
        //this.event_name = event_name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);

        Intent i = this.getIntent();
        event_name = i.getStringExtra("event_name");
        FragmentManager m = getSupportFragmentManager();
        FragmentTransaction t = m.beginTransaction();
        Fragment events = new event_view_details();
        Bundle b = new Bundle();
        b.putString("event_name",event_name);
        events.setArguments(b);
        t.replace(R.id.event_view_frag, events);
        t.disallowAddToBackStack().commit();


    }
}