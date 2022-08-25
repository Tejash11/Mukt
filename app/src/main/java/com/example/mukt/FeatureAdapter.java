package com.example.mukt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.ViewHolder> {

    ArrayList<Feature_model> feature_models = new ArrayList<>();

    Context context;
    public FeatureAdapter(Context context, ArrayList<Feature_model> feature_models){

        this.feature_models = feature_models;
        this.context = context;
    }
    @NonNull
    @Override
    public FeatureAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_feature,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeatureAdapter.ViewHolder holder, int position) {
        holder.imageview.setImageResource(feature_models.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return feature_models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageview = itemView.findViewById(R.id.each_feature);
        }
    }
}
