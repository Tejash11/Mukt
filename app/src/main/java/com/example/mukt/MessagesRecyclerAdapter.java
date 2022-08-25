package com.example.mukt;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class MessagesRecyclerAdapter extends RecyclerView.Adapter<MessagesRecyclerAdapter.ViewHolder> {

    ArrayList<Message> messages = new ArrayList<>();
    Context context;

    public MessagesRecyclerAdapter(Context context, ArrayList<Message> msgs){
        this.context = context;
        this.messages = msgs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_message_chatbot,parent,false);
        return new ViewHolder(view);
    }
    TextToSpeech t;

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(messages.get(position).sentByUser){
            holder.msgBot.setVisibility(View.GONE);
            holder.textUser.setText(messages.get(position).getContent());
            holder.playuser.setVisibility(View.VISIBLE);
            holder.playbot.setVisibility(View.GONE);


           t = new TextToSpeech(context.getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if(i != TextToSpeech.ERROR)
                    {
                        t.setLanguage(new Locale ("hi","IN", "variant"));
                    }
                }
            });

           holder.playuser.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   String text = holder.textUser.getText().toString();
                   t.speak(text, TextToSpeech.QUEUE_FLUSH, null);

               }
           });



        }
        else{
            holder.msgUser.setVisibility(View.GONE);
            holder.textBot.setText(messages.get(position).getContent());
            holder.playuser.setVisibility(View.GONE);
            holder.playbot.setVisibility(View.VISIBLE);

            t = new TextToSpeech(context.getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if(i != TextToSpeech.ERROR)
                    {
                        t.setLanguage(new Locale ("hi","IN", "variant"));
                    }
                }
            });

            holder.playbot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text = holder.textBot.getText().toString();
                    t.speak(text, TextToSpeech.QUEUE_FLUSH, null);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View msgBot;
        View msgUser;
        TextView textBot;
        TextView textUser;
        ImageView playbot;
        ImageView playuser;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            msgBot = itemView.findViewById(R.id.msg_bot);
            msgUser = itemView.findViewById(R.id.msg_user);
            textBot = itemView.findViewById(R.id.text_box1);
            textUser = itemView.findViewById(R.id.text_box2);
            playbot = itemView.findViewById(R.id.play_btn_bot);
            playuser = itemView.findViewById(R.id.play_btn_user);
        }
    }
}
