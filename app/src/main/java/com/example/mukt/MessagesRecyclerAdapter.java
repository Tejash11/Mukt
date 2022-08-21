package com.example.mukt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(messages.get(position).sentByUser){
            holder.msgBot.setVisibility(View.GONE);
            holder.textUser.setText(messages.get(position).getContent());
        }
        else{
            holder.msgUser.setVisibility(View.GONE);
            holder.textBot.setText(messages.get(position).getContent());
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
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            msgBot = itemView.findViewById(R.id.msg_bot);
            msgUser = itemView.findViewById(R.id.msg_user);
            textBot = itemView.findViewById(R.id.text_box1);
            textUser = itemView.findViewById(R.id.text_box2);
        }
    }
}
