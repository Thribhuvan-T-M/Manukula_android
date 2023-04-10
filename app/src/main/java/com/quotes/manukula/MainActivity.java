package com.quotes.manukula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.quotes.manukula.Common.OnBoardingActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logo = findViewById(R.id.logo);
        TextView text = findViewById(R.id.textView2);
        Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation popup = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        logo.setAnimation(fade);
        text.setAnimation(popup);


        new Handler().postDelayed(() -> {
            startActivity(new Intent(MainActivity.this, OnBoardingActivity.class));
            finish();
        },3000);
    }
}