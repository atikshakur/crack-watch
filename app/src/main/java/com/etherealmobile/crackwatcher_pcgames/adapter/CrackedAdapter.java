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
import com.etherealmobile.crackwatcher_pcgames.activities.CrackDetails;
import com.etherealmobile.crackwatcher_pcgames.model.CrackedModel;

import java.util.ArrayList;

public class CrackedAdapter extends RecyclerView.Adapter<CrackedAdapter.ViewHolder> {

    private ArrayList<CrackedModel> crackedModels = new ArrayList<>();
    private Context context;

    public CrackedAdapter(ArrayList<CrackedModel> crackedModels, Context context){
        this.crackedModels = crackedModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from( context ).inflate( R.layout.items, parent, false );

        return new ViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.title.setText(crackedModels.get(position).getTitle());
        Glide.with(context).load(crackedModels.get(position).getImage()).into(holder.image);
        holder.SceneGroup1.setText(crackedModels.get(position).getSceneGroup1());
        holder.DRM1.setText(crackedModels.get(position).getDRM1());

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CrackDetails.class);
                intent.putExtra("title", crackedModels.get(position).getTitle());
                intent.putExtra("image", crackedModels.get(position).getImage());
                intent.putExtra("sceneGroup1", crackedModels.get(position).getSceneGroup1());
                intent.putExtra("DRM1", crackedModels.get(position).getDRM1());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return crackedModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private String pubDate;
        private ImageView image;
        private String imagePoster;
        private String releaseDate;
        private String crackDate;
        private String OriginalPrice;
        private String OriginalPlatform;
        private TextView DRM1;
        private TextView SceneGroup1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.game_image);
            DRM1 = itemView.findViewById(R.id.drm);
            SceneGroup1 = itemView.findViewById(R.id.cracked_by);
        }
    }
}
