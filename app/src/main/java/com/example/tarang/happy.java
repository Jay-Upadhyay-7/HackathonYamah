package com.example.tarang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class happy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy2);
    }
    public void back(View view) {
        Intent intent =new Intent(happy.this, com.example.tarang.MainActivity2.class);
        startActivity(intent);
        finish();

    }
}