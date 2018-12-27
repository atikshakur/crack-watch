package com.etherealmobile.crackwatcher_pcgames.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.etherealmobile.crackwatcher_pcgames.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class CrackDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crack_details);

        MobileAds.initialize(this, "ca-app-pub-9779544843360458~5825365539");
        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        ImageView image = findViewById(R.id.iv_image);
        TextView title = findViewById(R.id.details_cracked_title);
        TextView date = findViewById(R.id.details_cracked_drm1);
        TextView sceneGroup = findViewById(R.id.details_cracked_sceneGroup);

        title.setText("Game : " + getIntent().getStringExtra("title"));
        date.setText("DRM : " + getIntent().getStringExtra("DRM1"));
        sceneGroup.setText("Cracked By : " + getIntent().getStringExtra("sceneGroup1"));
        Glide.with(this).load(getIntent().getStringExtra("image")).into(image);
    }
}
