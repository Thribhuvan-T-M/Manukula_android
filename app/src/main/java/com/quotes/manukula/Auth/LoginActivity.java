package com.quotes.manukula.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.quotes.manukula.R;

public class LoginActivity extends AppCompatActivity {
    private TextView registerButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        registerButton = findViewById(R.id.back_to_signup_button);

        registerButton.setOnClickListener(view ->{
            Intent signUpIntent = new Intent(this,SignUpActivity.class);
            startActivity(signUpIntent);
            finish();

        });
    }
}