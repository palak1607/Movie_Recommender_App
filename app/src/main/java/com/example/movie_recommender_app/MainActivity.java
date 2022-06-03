package com.example.movie_recommender_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Continue(View view){
        //handle the 'GET MOVIES' button
        //Building an intent to open another activity
        Intent intent = new Intent(this, ChooseMovie.class);
        startActivity(intent);

    }
}