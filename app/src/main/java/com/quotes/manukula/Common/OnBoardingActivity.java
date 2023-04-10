package com.quotes.manukula.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.quotes.manukula.R;

public class OnBoardingActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("on resume","on resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("on destroy","on destroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        Log.e("on create","on create");
    }
}