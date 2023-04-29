package com.example.tarang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class feargame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anger_game);
    }
    public void game1(View view) {
        // Define the URL you want to open
        String https;
        Uri webpage = Uri.parse("http://americanescaperooms.com/blog/post/how-can-you-overcome-your-biggest-fears-through-escape-games");

        // Create an intent to launch a web browser
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        finish();

    }
    public void game2(View view) {
        // Define the URL you want to open
        Uri webpage = Uri.parse("https://www.yogajournal.com/poses/corpse-pose/");

        // Create an intent to launch a web browser
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        finish();

    }
    public void back(View view) {
        Intent intent =new Intent(feargame.this,Fear.class);
        startActivity(intent);
        finish();

    }
}