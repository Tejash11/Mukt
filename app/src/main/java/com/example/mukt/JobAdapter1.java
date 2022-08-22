package com.example.mukt;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JobAdapter1 extends RecyclerView.Adapter<JobAdapter1.ViewHolder> {

    ArrayList<JobClass1> jobs = new ArrayList<>();

    Context context;

    public JobAdapter1(Context context,ArrayList<JobClass1> jobs){
        this.context = context;
        this.jobs = jobs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.application_card_1,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(jobs.get(position).getName());
        holder.name.setTextColor(context.getResources().getColor(jobs.get(position).getBackColor()));
        holder.logo.setImageResource(jobs.get(position).getImage());
        holder.back.setBackgroundResource(jobs.get(position).getBack());
        holder.arrow.setImageResource(jobs.get(position).getArrow());
        holder.org.setCardBackgroundColor(context.getResources().getColor(jobs.get(position).getColorTrans()));
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        RelativeLayout back;
        ImageView arrow;
        ImageView logo;
        CardView org;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.job_name);
            back = itemView.findViewById(R.id.application_card1_back);
            arrow = itemView.findViewById(R.id.forward_btn_application);
            logo = itemView.findViewById(R.id.org_logo);
            org = itemView.findViewById(R.id.org_card);
        }
    }
}
