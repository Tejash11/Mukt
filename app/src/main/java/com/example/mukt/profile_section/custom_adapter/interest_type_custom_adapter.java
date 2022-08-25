package com.example.mukt.profile_section.custom_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mukt.R;
import com.example.mukt.profile_section.model_class.interest_type;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class interest_type_custom_adapter extends FirebaseRecyclerAdapter<interest_type, interest_type_custom_adapter.myviewHolder> {

    public interest_type_custom_adapter(@NonNull FirebaseRecyclerOptions<interest_type> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewHolder holder, int position, @NonNull interest_type model) {
        holder.event_name.setText(model.getInterest_name());
    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_types_customlayout,parent,false);
        return new interest_type_custom_adapter.myviewHolder(view);
    }

    static class myviewHolder extends RecyclerView.ViewHolder
    {
        TextView event_name;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            event_name = (TextView) itemView.findViewById(R.id.event_name_type);
        }
    }



}
