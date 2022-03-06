package com.example.loveandrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin, btnNeedAccount;

    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernameLogin);
        password = findViewById(R.id.passwordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        btnNeedAccount = findViewById(R.id.btnNeedAccount);

        myDB = new DBHelper(this);

        btnNeedAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Please enter the Credentials.", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean result = myDB.checkUsernamePassword(user, pass);
                    if (result==true){
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        intent.putExtra("username",username.getText().toString());
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginActivity.this, "Invalid Credentials.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


}