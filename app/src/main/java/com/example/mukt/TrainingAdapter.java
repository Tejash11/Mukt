package com.example.mukt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.ViewHolder> {

    ArrayList<Training> trainings = new ArrayList<>();
    Context context;

    public TrainingAdapter(ArrayList<Training> trainings, Context context) {
        this.trainings = trainings;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_training1,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(trainings.get(position).getImage());
        holder.name.setText(trainings.get(position).getName());
        holder.org.setText(trainings.get(position).getOrg_name());
        holder.duration.setText(String.valueOf(trainings.get(position).getDuration()) + " hr");

    }

    @Override
    public int getItemCount() {
        return trainings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView org;
        TextView duration;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.course_back);
            name = itemView.findViewById(R.id.course_title);
            org = itemView.findViewById(R.id.org_title);
            duration = itemView.findViewById(R.id.duration);
        }
    }
}
