package com.quotes.manukula.Core.Fragments.OnBoarding;

import static com.quotes.manukula.Database.DBQueries.languageDataModelList;
import static com.quotes.manukula.Database.DBQueries.loadLangData;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.quotes.manukula.Core.Adapters.OnBoardingHelper.LanguageDataAdapter;
import com.quotes.manukula.R;

public class UserDataFragment extends Fragment {

    private RecyclerView userDataRecycler;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_data, container, false);

        init(view);

        mainLogic();

        return view;
    }

    private void init(@NonNull View view) {
    }

    private void mainLogic() {

    }
}