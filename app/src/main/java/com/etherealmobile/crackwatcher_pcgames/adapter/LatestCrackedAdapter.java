package com.etherealmobile.crackwatcher_pcgames.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.etherealmobile.crackwatcher_pcgames.R;
import com.etherealmobile.crackwatcher_pcgames.activities.LatestCrackDetails;
import com.etherealmobile.crackwatcher_pcgames.model.CrackedModel;
import com.etherealmobile.crackwatcher_pcgames.model.LatestCrackedModel;

import java.util.ArrayList;

public class LatestCrackedAdapter extends RecyclerView.Adapter<LatestCrackedAdapter.ViewHolder> {

    private ArrayList<LatestCrackedModel> latestCrackedModels = new ArrayList<>();
    private Context context;

    public LatestCrackedAdapter(ArrayList<LatestCrackedModel> latestCrackedModels, Context context) {
        this.latestCrackedModels = latestCrackedModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.latest_items, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.title.setText(latestCrackedModels.get(position).getTitle());
        holder.sceneGroup.setText(latestCrackedModels.get(position).getSceneGroup());
        holder.date.setText(latestCrackedModels.get(position).getDate());
        Glide.with(context).load(latestCrackedModels.get(position).getImage()).into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LatestCrackDetails.class);
                intent.putExtra("title", latestCrackedModels.get(position).getTitle());
                intent.putExtra("sceneGroup", latestCrackedModels.get(position).getSceneGroup());
                intent.putExtra("date", latestCrackedModels.get(position).getDate());
                intent.putExtra("image", latestCrackedModels.get(position).getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return latestCrackedModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;
        TextView date;
        TextView sceneGroup;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_latest);
            image = itemView.findViewById(R.id.game_image_latest);
            date = itemView.findViewById(R.id.date);
            sceneGroup = itemView.findViewById(R.id.cracked_by_latest);

        }
    }
}
