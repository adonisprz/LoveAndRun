package com.example.loveandrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
     TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txt=(TextView)findViewById(R.id.txt_usernameDisplay);

        Intent integer = getIntent();
        String username = getIntent().getStringExtra("username");
        txt.setText("Hola " +username + ", como estamos ?");
    }
}