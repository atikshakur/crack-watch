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

public class LatestCrackDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest_crack_details);

        MobileAds.initialize(this, "ca-app-pub-9779544843360458~5825365539");
        AdView adView = findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);

        ImageView ivReleaseNotes = findViewById(R.id.iv_release_notes);
        TextView title = findViewById(R.id.details_title);
        TextView date = findViewById(R.id.details_date);
        TextView sceneGroup = findViewById(R.id.details_sceneGroup);

        title.setText("Game : " + getIntent().getStringExtra("title"));
        date.setText("Date : " + getIntent().getStringExtra("date"));
        sceneGroup.setText("Cracked By : " + getIntent().getStringExtra("sceneGroup"));
        Glide.with(this).load(getIntent().getStringExtra("image")).into(ivReleaseNotes);
    }
}
