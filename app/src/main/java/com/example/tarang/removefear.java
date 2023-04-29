package com.example.tarang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class removefear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angerboostup);
    }
    public void act1(View view) {
        // Define the URL you want to open
        Uri webpage = Uri.parse("https://www.yogajournal.com/poses/easy-pose-3/");

        // Create an intent to launch a web browser
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        finish();

    }
    public void act2(View view) {
        // Define the URL you want to open
        Uri webpage = Uri.parse("https://www.yogajournal.com/poses/corpse-pose/");

        // Create an intent to launch a web browser
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        finish();

    }
    public void back(View view) {
        Intent intent =new Intent(removefear.this,Fear.class);
        startActivity(intent);
        finish();

    }
}