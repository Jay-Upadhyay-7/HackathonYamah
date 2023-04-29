package com.example.tarang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anger);

    }
    public void game(View view){
        Intent intent =new Intent(sad.this,sadgame.class);
        startActivity(intent);
        finish();
    }

    public void back(View view) {
        Intent intent =new Intent(sad.this,MainActivity2.class);
        startActivity(intent);
        finish();

    }
}