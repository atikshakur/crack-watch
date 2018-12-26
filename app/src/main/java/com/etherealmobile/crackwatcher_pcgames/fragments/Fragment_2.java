package com.etherealmobile.crackwatcher_pcgames.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.etherealmobile.crackwatcher_pcgames.R;
import com.etherealmobile.crackwatcher_pcgames.activities.PopularDeatils;
import com.etherealmobile.crackwatcher_pcgames.model.PopularModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.w3c.dom.Text;

public class Fragment_2 extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private FirebaseRecyclerOptions<PopularModel> firebaseRecyclerOptions;
    private FirebaseRecyclerAdapter<PopularModel, ViewHolder> adapter;

    private static final String TAG = "Frag2";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;

        recyclerView = view.findViewById(R.id.popular_recyclerView);


        fetchData();
    }

    public void fetchData(){
        Query query = FirebaseDatabase.getInstance().getReference().child("popular");
        query.keepSynced(true);

        firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<PopularModel>()
                .setQuery(query, PopularModel.class).build();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);

        adapter = new FirebaseRecyclerAdapter<PopularModel, ViewHolder>(firebaseRecyclerOptions) {
            @Override
            protected void onBindViewHolder(ViewHolder holder, int position, PopularModel model) {
                final String title = model.getTitle();
                final String image = model.getImage();
                final String drm = model.getDrm();
                final String sceneGroup = model.getSceneGroup();
                final String cracked = model.getCracked();
                final String cImage = model.getcImage();

                //SETTING THOSE VIEWS
                holder.title.setText(title);
                Log.d(TAG, "onBindViewHolder: "+ title);
                holder.drm.setText(drm);
                holder.sceneGroup.setText(sceneGroup);
                holder.cracked.setText(cracked);
                Glide.with(getContext()).load(image).into(holder.gameImage);
                Glide.with(getContext()).load(cImage).into(holder.cImage);

                holder.gameImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), PopularDeatils.class);
                        intent.putExtra("title", title);
                        intent.putExtra("image", image);
                        intent.putExtra("drm", drm);
                        intent.putExtra("sceneGroup", sceneGroup);
                        intent.putExtra("cracked", cracked);
                        intent.putExtra("cImage", cImage);
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.popular_items, viewGroup, false);
                return new ViewHolder(view);
            }

        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (adapter != null)
            adapter.startListening();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null)
            adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (adapter != null)
            adapter.stopListening();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView drm;
        public TextView sceneGroup;
        public TextView cracked;
        public ImageView gameImage;
        public ImageView cImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_popular);
            drm = itemView.findViewById(R.id.drm_popular);
            sceneGroup = itemView.findViewById(R.id.cracked_by_popular);
            cracked = itemView.findViewById(R.id.cracked);
            gameImage = itemView.findViewById(R.id.game_image_popular);
            cImage = itemView.findViewById(R.id.online_popular);
        }
    }
}
