package com.example.movie_recommender_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.movie_recommender_app.Adapter.RecyclerViewAdapter2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DisplayRecommend extends AppCompatActivity {

    RecyclerView recView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recommend);
        Intent intent = getIntent();
        String titleMSG = intent.getStringExtra("TITLE");
        String descMSG = intent.getStringExtra("DESC");
        // Capture the layout's TextView and set the string as its text
        TextView TitleTextView = findViewById(R.id.textView3);
        TitleTextView.setText(titleMSG);
        TextView DescTextView = findViewById(R.id.textView4);
        DescTextView.setText(descMSG);
        // API url
        String url = "http://127.0.0.1:5000/get_recommendations/"+ titleMSG;

        recView = (RecyclerView)findViewById(R.id.recview);
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setHasFixedSize(true);
        StringRequest request  = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(DisplayRecommend.this, "Successful!",Toast.LENGTH_SHORT).show();
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Datum[] data = gson.fromJson(response, Datum[].class);
                recView.setAdapter(new RecyclerViewAdapter2(data, getApplicationContext() ) );
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myApp","something went wrong");
                Toast.makeText(DisplayRecommend.this, "Something Went Wrong!",Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    }
