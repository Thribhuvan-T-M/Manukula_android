package com.quotes.manukula.Core.Adapters.DashboardHelper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.quotes.manukula.Core.Fragments.Dashboard.EchoFragment;
import com.quotes.manukula.Core.Fragments.Dashboard.HomeFragment;
import com.quotes.manukula.Core.Fragments.Dashboard.ProfileFragment;
import com.quotes.manukula.Core.Fragments.Dashboard.SearchFragment;

public class HomePageAdapter extends FragmentStateAdapter {

    public HomePageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new EchoFragment();
            case 2:
                return new SearchFragment();
            case 3:
                return new ProfileFragment();
        }
        return new HomeFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
