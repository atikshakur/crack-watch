package com.etherealmobile.crackwatcher_pcgames.fragments;

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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.etherealmobile.crackwatcher_pcgames.R;
import com.etherealmobile.crackwatcher_pcgames.activities.MainActivity;
import com.etherealmobile.crackwatcher_pcgames.adapter.CrackedAdapter;
import com.etherealmobile.crackwatcher_pcgames.model.CrackedModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Fragment_1 extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private String API_URL_CRACKED = "http://api.crackwatch.com/api/games";
    private CrackedAdapter crackedAdapter;
    private static final String TAG = "Fragment_1";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;

        final ArrayList<CrackedModel> cracked = new ArrayList<>();
        recyclerView = view.findViewById(R.id.cracked_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.swipe1);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchData(cracked);
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        fetchData(cracked);
    }

    public void fetchData(final ArrayList<CrackedModel> cracked){
        final StringRequest stringRequest = new StringRequest(Request.Method.GET,
                API_URL_CRACKED, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
//                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = new JSONArray(response);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        CrackedModel crackedModel = new CrackedModel(
                                jsonObject1.getString("title"),
                                jsonObject1.getString("pubDate"),
                                jsonObject1.getString("image"),
                                jsonObject1.getString("imagePoster"),
                                jsonObject1.getString("releaseDate"),
                                jsonObject1.getString("crackDate"),
                                jsonObject1.getString("OriginalPrice"),
                                jsonObject1.getString("OriginalPlatform"),
                                jsonObject1.getString("DRM1"),
                                jsonObject1.getString("SceneGroup1"));
                        cracked.add(crackedModel);
                    }
                    crackedAdapter = new CrackedAdapter(cracked, getContext());
                    recyclerView.setAdapter(crackedAdapter);
                    crackedAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onErrorResponse: "+error);
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }
}
