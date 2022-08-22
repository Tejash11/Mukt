package com.example.mukt.event_section.custom_adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mukt.R;
import com.example.mukt.event_section.Event;
import com.example.mukt.event_section.event_showcase_list;
import com.example.mukt.event_section.model_class.event_type;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class event_types_fliter_custom_adapter extends FirebaseRecyclerAdapter<event_type,event_types_fliter_custom_adapter.myviewHolder> {

    String previous;
    Context context;
    int index= -1;

    public event_types_fliter_custom_adapter(@NonNull FirebaseRecyclerOptions<event_type> options, String previous, Context context) {
        super(options);
        this.previous = previous;
        this.context = context;

    }

    @Override
    protected void onBindViewHolder(@NonNull myviewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull event_type model) {


        if(index == position)
        {
            holder.event_name.setBackground(ContextCompat.getDrawable(context, R.drawable.blue_circular_solid));
            holder.event_name.setTextColor(Color.parseColor("#FFFFFF"));
        }
        else
        {
            holder.event_name.setBackground(ContextCompat.getDrawable(context, R.drawable.circular_blue_border));
            holder.event_name.setTextColor(Color.parseColor("#2196F3"));
        }

        holder.event_name.setText(model.getType_name());
        holder.event_name.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {

                index = position;
                notifyDataSetChanged();
//                AppCompatActivity activitys = (AppCompatActivity) v.getContext();
//                Fragment myFragments = new Event(holder.event_name.getText().toString());
//                //myFragment.setArguments(bundle);
//                //myFragment.setArguments(bundles);
//                activitys.getSupportFragmentManager().beginTransaction().replace(R.id.fragment, myFragments).addToBackStack(null).commit();


                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment myFragment = new event_showcase_list(holder.event_name.getText().toString());
                //myFragment.setArguments(bundle);
                //myFragment.setArguments(bundles);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.event_frag, myFragment).addToBackStack(null).commit();

                previous = holder.event_name.getText().toString();


            }
        });
    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_types_customlayout,parent,false);
        return new myviewHolder(view);
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
