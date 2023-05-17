package com.quotes.manukula;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.quotes.manukula.Core.Activities.DashboardActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ImageView logo = findViewById(R.id.logo);
        TextView text = findViewById(R.id.textView2);
        Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation popup = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        logo.setAnimation(fade);
        text.setAnimation(popup);


        new Handler().postDelayed(() -> {
            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
            finish();
        }, 3000);
    }
}