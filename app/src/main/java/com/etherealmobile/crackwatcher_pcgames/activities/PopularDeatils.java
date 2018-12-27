package com.etherealmobile.crackwatcher_pcgames.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.etherealmobile.crackwatcher_pcgames.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class PopularDeatils extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_deatils);

        MobileAds.initialize(this, "ca-app-pub-9779544843360458~5825365539");
        AdView adView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        ImageView image = findViewById(R.id.image);
        TextView title = findViewById(R.id.details_popular_title);
        TextView drm = findViewById(R.id.details_popular_drm);
        TextView sceneGroup = findViewById(R.id.details_popular_sceneGroup);

        title.setText("Game : " + getIntent().getStringExtra("title"));
        drm.setText("Protection : " + getIntent().getStringExtra("drm"));
        sceneGroup.setText("Cracked By : " + getIntent().getStringExtra("sceneGroup"));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("image")).into(image);
    }
}
