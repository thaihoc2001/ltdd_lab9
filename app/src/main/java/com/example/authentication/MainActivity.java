package com.example.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    Button btnLogin, btnRegister;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLoginHome);
        btnRegister = findViewById(R.id.btnRegisterHome);
        final Intent intentLogin = new Intent(this, ActivityLogin.class);
        final Intent intentRegister = new Intent(this, RegisterActivity.class);

        btnLogin.setOnClickListener((v) -> {
            startActivity(intentLogin);
        });
        btnRegister.setOnClickListener((v) -> {
            startActivity(intentRegister);
        });
    }
}
