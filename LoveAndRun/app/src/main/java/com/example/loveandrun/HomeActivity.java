package com.example.loveandrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

public class HomeActivity extends AppCompatActivity {
     TextView txt;
     Button btnMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txt=(TextView)findViewById(R.id.txt_usernameDisplay);
        btnMap = findViewById(R.id.mapsbutton);

        Intent integer = getIntent();
        String username = getIntent().getStringExtra("username");
        txt.setText("Hola " +username + ", como estamos ?");

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
    }


}