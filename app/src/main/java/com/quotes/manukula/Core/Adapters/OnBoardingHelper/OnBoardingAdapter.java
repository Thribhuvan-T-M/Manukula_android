package com.quotes.manukula.Core.Adapters.OnBoardingHelper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.quotes.manukula.Core.Fragments.OnBoarding.CategoryFragment;
import com.quotes.manukula.Core.Fragments.OnBoarding.LanguageFragment;
import com.quotes.manukula.Core.Fragments.OnBoarding.UserDataFragment;

public class OnBoardingAdapter extends FragmentStateAdapter {

    public OnBoardingAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new LanguageFragment();
            case 1:
                return new CategoryFragment();
            case 2:
                return new UserDataFragment();
        }
        return new LanguageFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
