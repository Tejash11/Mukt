package com.example.mukt;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    ArrayList<Task> tasks = new ArrayList<>();
    Context context;

    public TaskAdapter(ArrayList<Task> tasks, Context context) {
        this.tasks = tasks;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.application_card_3,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int completed= tasks.get(position).getCompleted();
        int total = tasks.get(position).getTotal();
        holder.name.setText(tasks.get(position).getName());
        holder.details.setText(String.valueOf(completed) + "/" + String.valueOf(total));

        holder.task_prog.setDrawHoleEnabled(true);
        holder.task_prog.setUsePercentValues(true);
        holder.task_prog.setDrawEntryLabels(false);
        holder.task_prog.setDrawSlicesUnderHole(false);
        holder.task_prog.setDrawCenterText(false);
        holder.task_prog.setRotationEnabled(false);
        holder.task_prog.setTouchEnabled(false);
        holder.task_prog.setHoleRadius(70);
//        holder.task_prog.setCenterText(String.valueOf(((float)completed / total)*100));
//        holder.task_prog.setCenterTextSize(5);
        holder.task_prog.getDescription().setEnabled(false);
        holder.task_prog.getLegend().setEnabled(false);

        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(total-completed, ""));
        entries.add(new PieEntry(completed, ""));

        float state = (float)completed/total;
        ArrayList<Integer> colors = new ArrayList<>();
        if(state>= 0.75f){
            holder.status_ico.setImageResource(R.drawable.vec_bot_status);
            colors.add(Color.parseColor("#E7E7E7"));
            colors.add(Color.parseColor("#37B874"));
        }
        else if(state>=0.5f){
            holder.status_ico.setImageResource(R.drawable.vec_bot_status_intermediate);
            colors.add(Color.parseColor("#E7E7E7"));
            colors.add(Color.parseColor("#FF9800"));
        }
        else{
            holder.status_ico.setImageResource(R.drawable.vec_bot_status_off);
            colors.add(Color.parseColor("#E7E7E7"));
            colors.add(Color.parseColor("#F44336"));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Tasks Category");
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(holder.task_prog));
        data.setValueTextSize(0);

        holder.task_prog.setData(data);
        holder.task_prog.invalidate();

        //holder.task_prog.animateY(1400, Easing.EaseInOutQuad);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView details;
        ImageView status_ico;
        PieChart task_prog;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.task_name);
            details = itemView.findViewById(R.id.taskdetails);
            status_ico = itemView.findViewById(R.id.task_status);
            task_prog = itemView.findViewById(R.id.task_piechart);
        }
    }
}
