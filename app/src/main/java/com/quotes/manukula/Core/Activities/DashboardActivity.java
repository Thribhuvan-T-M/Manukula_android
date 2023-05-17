package com.quotes.manukula.Core.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.quotes.manukula.Core.Adapters.DashboardHelper.HomePageAdapter;
import com.quotes.manukula.R;

public class DashboardActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPager2 viewPager;
    private FloatingActionButton post_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        init();

        mainLogic();

    }

    private void init() {
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        post_button = findViewById(R.id.post_button);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setUserInputEnabled(false);
        viewPager.setAdapter(new HomePageAdapter(this));
    }

    @SuppressLint("NonConstantResourceId")
    private void mainLogic() {
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.echo:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.search:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.profile:
                    viewPager.setCurrentItem(4);
                    break;
            }
            return true;
        });

        //community button
        post_button.setOnClickListener(view -> {
            //post
        });
    }

}