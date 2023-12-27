package com.example.scienceproject2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class StartPage extends AppCompatActivity {

    public void LaunchHomeScreen() {
        Intent homeScreen = new Intent(this, MainActivity.class);
        startActivity(homeScreen);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
    }
}