package com.quotes.manukula.Common;

import static com.quotes.manukula.Database.DBQueries.languageDataModelList;
import static com.quotes.manukula.Database.DBQueries.loadLangData;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.quotes.manukula.Auth.SignUpActivity;
import com.quotes.manukula.Core.Adapters.OnBoardingHelper.LanguageDataAdapter;
import com.quotes.manukula.Core.Adapters.OnBoardingHelper.OnBoardingAdapter;
import com.quotes.manukula.R;

public class OnBoardingActivity extends AppCompatActivity {

    private Button onBoardingButton;
    private ViewPager2 onBoardingViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        init();

        mainLogic();

    }

    private void init() {
        onBoardingButton = findViewById(R.id.onBoardingNextButton);
        onBoardingViewPager = findViewById(R.id.onBoardingViewPager);
        onBoardingViewPager.setUserInputEnabled(false);
        onBoardingViewPager.setAdapter(new OnBoardingAdapter(this));
    }

    @SuppressLint("SetTextI18n")
    private void mainLogic() {
        onBoardingButton.setOnClickListener(view -> {
            if (onBoardingViewPager.getCurrentItem() == 0) {
                onBoardingButton.setText("Next");
                onBoardingViewPager.setCurrentItem(1);
            } else if (onBoardingViewPager.getCurrentItem() == 1) {
                onBoardingButton.setText("Get started");
                onBoardingViewPager.setCurrentItem(2);
            } else if (onBoardingViewPager.getCurrentItem() == 2) {
                onBoardingButton.setText("Get started");
                startActivity(new Intent(this, SignUpActivity.class));
            }
        });
    }
}