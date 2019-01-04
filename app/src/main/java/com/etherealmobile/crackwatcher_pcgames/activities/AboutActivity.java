package com.etherealmobile.crackwatcher_pcgames.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.etherealmobile.crackwatcher_pcgames.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ListView listView = findViewById(R.id.listview);
        String[] about = {"Version 1.6", "Credit"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, about);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:

                        AlertDialog.Builder builder = new AlertDialog.Builder(AboutActivity.this);
                        builder.setMessage(R.string.huge_thanks_to_crackwatch_for_providing_the_api)
                                .setPositiveButton("DISMISS", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        break;
                }
            }
        });

    }
}
