package com.example.mukt.event_section;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mukt.MainActivity;
import com.example.mukt.R;
import com.example.mukt.Ticket_generator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class event_view extends AppCompatActivity {

    String event_name;
    TextView book_btn;

    String name, date,time,venue, address, doc;

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

        book_btn = (TextView) findViewById(R.id.view_meta);


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



        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Main").child("Events").child("Ghaziabad");



        ref.child(event_name).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if(task.isSuccessful())
                {
                    DataSnapshot snapshot = task.getResult();
                    name = String.valueOf(snapshot.child("event_name").getValue());
                    date = String.valueOf(snapshot.child("event_date").getValue());
                    time = String.valueOf(snapshot.child("event_time").getValue());
                    venue = String.valueOf(snapshot.child("venue_name").getValue());
                    address = String.valueOf(snapshot.child("venue_address").getValue());
                    doc = String.valueOf(snapshot.child("event_documentation").getValue());

                    //Toast.makeText(getContext(),String.valueOf(snapshot.child("event_name")),Toast.LENGTH_LONG).show();

                    //Glide.with(getActivity().getApplicationContext()).load(String.valueOf(snapshot.child("event_url1").getValue())).centerCrop().into(img);


                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });



        book_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(event_view.this, Ticket_generator.class);
                i.putExtra("name", event_name);
                i.putExtra("date", date);
                i.putExtra("time", time);
                i.putExtra("venue", venue);
                i.putExtra("address", address);
                i.putExtra("doc", doc);
               // i.putExtra("date", date.getText().toString());
                startActivity(i);




            }
        });


    }
}