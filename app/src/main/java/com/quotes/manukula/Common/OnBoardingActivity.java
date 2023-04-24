package com.quotes.manukula.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.quotes.manukula.Auth.LoginActivity;
import com.quotes.manukula.Auth.SignUpActivity;
import com.quotes.manukula.R;

public class OnBoardingActivity extends AppCompatActivity {

    private Button onBoardingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        onBoardingButton = findViewById(R.id.onBoarding_Button);

        onBoardingButton.setOnClickListener(view -> {
            Intent onBoardingIntent = new Intent(OnBoardingActivity.this, LoginActivity.class);
            startActivity(onBoardingIntent);
            finish();
        });


    }
}