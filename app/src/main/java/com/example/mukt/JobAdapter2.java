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

public class JobAdapter2 extends RecyclerView.Adapter<JobAdapter2.ViewHolder> {

    ArrayList<JobClass2> jobs = new ArrayList<>();
    Context context;

    public JobAdapter2(ArrayList<JobClass2> jobs, Context context) {
        this.jobs = jobs;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.application_card_2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(jobs.get(position).getName());
        holder.org.setText(jobs.get(position).getOrgName());
        holder.logo.setImageResource(jobs.get(position).getLogo());
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView logo;
        TextView org;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.gig_name);
            org = itemView.findViewById(R.id.org_name);
            logo = itemView.findViewById(R.id.orgs_logos);
        }
    }
}
