package com.example.mukt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Dialog dlg;
    FloatingActionButton dialog_button;
    FloatingActionButton cancel_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView homebtn = (ImageView) findViewById(R.id.homebtn);
        ImageView bazaarbtn = (ImageView) findViewById(R.id.shopbtn);
        ImageView communitybtn = (ImageView) findViewById(R.id.commbtn);
        ImageView userbtn = (ImageView) findViewById(R.id.userbtn);
        FloatingActionButton muktbtn = (FloatingActionButton) findViewById(R.id.muktbtn);

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
//                bazaarbtn.setImageResource(R.drawable.shopoutline);
//                communitybtn.setImageResource(R.drawable.heart);
                userbtn.setImageResource(R.drawable.useroutline);
            }
        });

//        communitybtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager m = getSupportFragmentManager();
//                FragmentTransaction t = m.beginTransaction();
//                Fragment community = new Community();
//                t.replace(R.id.fragment, community);
//                t.commit();
//                homebtn.setImageResource(R.drawable.homeoutline);
//                bazaarbtn.setImageResource(R.drawable.shopoutline);
//                communitybtn.setImageResource(R.drawable.heart_colour);
//                userbtn.setImageResource(R.drawable.useroutline);
//            }
//        });
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
//
//        userbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager m = getSupportFragmentManager();
//                FragmentTransaction t = m.beginTransaction();
//                Fragment user = new Profile();
//                t.replace(R.id.fragment, user);
//                t.commit();
//                homebtn.setImageResource(R.drawable.homeoutline);
//                bazaarbtn.setImageResource(R.drawable.shopoutline);
//                communitybtn.setImageResource(R.drawable.heart);
//                userbtn.setImageResource(R.drawable.usercolor);
//            }
//        });
//
        muktbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Mukt_reels.class);
                startActivity(i);
                homebtn.setImageResource(R.drawable.homeoutline);
//                bazaarbtn.setImageResource(R.drawable.shopoutline);
//                communitybtn.setImageResource(R.drawable.heart);
                userbtn.setImageResource(R.drawable.useroutline);
            }
        });
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
        
    }
}