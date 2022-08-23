package com.example.mukt.event_section.custom_adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mukt.R;
import com.example.mukt.event_section.event_view;
import com.example.mukt.event_section.model_class.event_info;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class event_showcase_info_custom_adapter extends FirebaseRecyclerAdapter<event_info,event_showcase_info_custom_adapter.myviewHolder> {


    public event_showcase_info_custom_adapter(@NonNull FirebaseRecyclerOptions<event_info> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewHolder holder, int position, @NonNull event_info model) {

            holder.event_name.setText(model.getEvent_name());
            holder.event_date.setText(model.getEvent_date());
            holder.event_type.setText(model.getEvent_type());
            holder.venue_name.setText(model.getVenue_name());

            Glide.with(holder.event_pic.getContext()).load(model.getEvent_url1()).into(holder.event_pic);

            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), event_view.class);
                    i.putExtra("event_name",holder.event_name.getText().toString());
                    v.getContext().startActivity(i);
                }
            });


    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_showcase_item_customlayout,parent,false);
            return new event_showcase_info_custom_adapter.myviewHolder(view);

    }

    static class myviewHolder extends RecyclerView.ViewHolder
    {
        TextView event_name;
        TextView event_date;
        TextView venue_name;
        ImageView event_pic;
        TextView event_type;
        CardView card;


        public myviewHolder(@NonNull View itemView) {
            super(itemView);

            card = (CardView) itemView.findViewById(R.id.parent_card);
            event_name = (TextView) itemView.findViewById(R.id.event_name);
            event_date = (TextView) itemView.findViewById(R.id.event_date);
            event_pic = (ImageView) itemView.findViewById(R.id.event_image);
            venue_name = (TextView) itemView.findViewById(R.id.event_venue);
            event_type = (TextView) itemView.findViewById(R.id.event_type);
        }
    }

}
