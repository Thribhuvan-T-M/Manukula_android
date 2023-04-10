package com.quotes.manukula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.quotes.manukula.Common.OnBoardingActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView text;
    private Animation fade,popup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.logo);
        text = findViewById(R.id.textView2);
        fade = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        popup = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        logo.setAnimation(fade);
        text.setAnimation(popup);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, OnBoardingActivity.class));
                finish();
            }
        },3000);




    }
}