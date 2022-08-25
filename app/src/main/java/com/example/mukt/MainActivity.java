package com.example.mukt;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.mukt.event_section.Event;
import com.example.mukt.event_section.event_create;
import com.example.mukt.profile_section.Profile;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Dialog dlg;
    FloatingActionButton dialog_button;
    FloatingActionButton cancel_button;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_main);

        ImageView homebtn = (ImageView) findViewById(R.id.homebtn);
        ImageView eventbtn = (ImageView) findViewById(R.id.eventbtn);
        ImageView notificationbtn = (ImageView) findViewById(R.id.notificationbtn);
        ImageView userbtn = (ImageView) findViewById(R.id.userbtn);
//       ImageView muktreelsbtn = (ImageView) findViewById(R.id.muktbtn);
        ImageView createpostbtn = (ImageView) findViewById(R.id.createpostbtn);

        FragmentManager m = getSupportFragmentManager();
        FragmentTransaction t = m.beginTransaction();
        Fragment Home = new Home();
        t.replace(R.id.fragment,Home);
        t.commit();
        homebtn.setImageResource(R.drawable.homecolor);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager m = getSupportFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                Fragment Home = new Home();
                t.replace(R.id.fragment, Home);
                t.commit();
                homebtn.setImageResource(R.drawable.homecolor);
//                eventbtn.setImageResource(R.drawable.event);
                notificationbtn.setImageResource(R.drawable.notification);
                userbtn.setImageResource(R.drawable.user);
            }
        });

        eventbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager m = getSupportFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                Fragment community = new Event();
                t.replace(R.id.fragment, community);
                t.commit();
                homebtn.setImageResource(R.drawable.explore);
                eventbtn.setImageResource(R.drawable.eventcolor);
                notificationbtn.setImageResource(R.drawable.notification);
                userbtn.setImageResource(R.drawable.user);
            }
        });

        notificationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentManager m = getSupportFragmentManager();
//                FragmentTransaction t = m.beginTransaction();
//                Fragment notification = new Notification();
//                t.replace(R.id.fragment, notification);
//                t.commit();
//                homebtn.setImageResource(R.drawable.explore);
////                eventbtn.setImageResource(R.drawable.event);
//                notificationbtn.setImageResource(R.drawable.notificationcolor);
//                userbtn.setImageResource(R.drawable.user);
            }
        });

        userbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,activity_applications.class);
                startActivity(intent);

                homebtn.setImageResource(R.drawable.explore);
//                eventbtn.setImageResource(R.drawable.event);
                notificationbtn.setImageResource(R.drawable.notification);
                userbtn.setImageResource(R.drawable.usercolor);
            }
        });


        createpostbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,CreatePost.class);
                startActivity(i);
                homebtn.setImageResource(R.drawable.explore);
//                eventbtn.setImageResource(R.drawable.event);
                notificationbtn.setImageResource(R.drawable.notification);
                userbtn.setImageResource(R.drawable.user);
            }
        });

//        muktreelsbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,Mukt_reels.class);
//                startActivity(i);
//                homebtn.setImageResource(R.drawable.explore);
////                eventbtn.setImageResource(R.drawable.event);
//                notificationbtn.setImageResource(R.drawable.notification);
//                userbtn.setImageResource(R.drawable.user);
//            }
//        });
        dlg = new Dialog(MainActivity.this);
        dlg.setContentView(R.layout.dialog_chatbot);
        dlg.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background_dialog));
        dlg.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        cancel_button = (FloatingActionButton) dlg.findViewById(R.id.cancel_button);
        dialog_button = findViewById(R.id.floatingActionButton);

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();
                dialog_button.setVisibility(View.VISIBLE);
            }
        });

        dialog_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.show();
                dialog_button.setVisibility(View.GONE);
            }
        });

        ArrayList<Message> messages =  new ArrayList<>();

        messages.add(new Message(1,"Hello my name is Mukti, how may I help you?",false));
        messages.add(new Message(1,"Can you help me find nasha mukti events near me?",true));
        messages.add(new Message(1,"Sure!",false));
        messages.add(new Message(1,"Here is a list of all Nasha Mukti events happening near Ghaziabad",false));
        messages.add(new Message(1,"Sutte se Chhutta @ KIET Group of Institutions",false));
        messages.add(new Message(1,"Chhutte ka Sutta @ IIT Delhi",false));
        messages.add(new Message(1,"Thank You",true));

        MessagesRecyclerAdapter messagesRecyclerAdapter = new MessagesRecyclerAdapter(this,messages);

        RecyclerView recyclerView = dlg.findViewById(R.id.msgs_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(messagesRecyclerAdapter);


        NavigationView nv = findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //Applications
                if(menuItem.getItemId() == R.id.nav_home)
                {
                    Intent intent = new Intent(MainActivity.this,activity_applications.class);
                    startActivity(intent);
                    //Toast.makeText(getApplicationContext(),"First",Toast.LENGTH_SHORT).show();
                    //Toast.makeText(this,"First",Toast.LENGTH_SHORT).show();

                }
                else if(menuItem.getItemId() == R.id.nav_gallery)
                {
                    Toast.makeText(getApplicationContext(),"Training and Management",Toast.LENGTH_SHORT).show();
                }
                else if(menuItem.getItemId() == R.id.nav_emergency)
                {
                    Intent intent = new Intent(MainActivity.this, event_create.class);
                    startActivity(intent);
                   // Toast.makeText(getApplicationContext(),"Third",Toast.LENGTH_SHORT).show();
                }
                else if(menuItem.getItemId() == R.id.nav_book)
                {
                    Toast.makeText(getApplicationContext(),"About Mukt",Toast.LENGTH_SHORT).show();
                }



                DrawerLayout dr = findViewById(R.id.drawer_layout);
                dr.closeDrawer(GravityCompat.START);

                return true;
            }
        });










    }
}
