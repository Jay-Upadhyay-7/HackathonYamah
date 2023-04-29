package com.example.tarang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class sadgame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sadgame);
    }
    public void task1(View view) {
        // Define the URL you want to open
        Uri webpage = Uri.parse("http://activities.thetrainingworld.com/index.php?action=artikel&cat=6&id=42&artlang=en");

        // Create an intent to launch a web browser
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        finish();

    }
    public void task2(View view) {
        // Define the URL you want to open
        Uri webpage = Uri.parse("https://www.yogajournal.com/poses/corpse-pose/");

        // Create an intent to launch a web browser
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        finish();

    }
    public void back(View view) {
        Intent intent =new Intent(sadgame.this,sad.class);
        startActivity(intent);
        finish();

    }
}