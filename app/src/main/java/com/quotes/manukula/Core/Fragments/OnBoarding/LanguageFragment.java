package com.quotes.manukula.Core.Fragments.OnBoarding;

import static com.quotes.manukula.Database.DBQueries.languageDataModelList;
import static com.quotes.manukula.Database.DBQueries.loadLangData;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quotes.manukula.Auth.SignUpActivity;
import com.quotes.manukula.Core.Adapters.OnBoardingHelper.LanguageDataAdapter;
import com.quotes.manukula.Core.Adapters.OnBoardingHelper.OnBoardingAdapter;
import com.quotes.manukula.R;

public class LanguageFragment extends Fragment {

    private RecyclerView langRecycler;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_language, container, false);

        init(view);

        mainLogic();

        return view;
    }

    private void init(@NonNull View view) {
        langRecycler = view.findViewById(R.id.lang_recycler);
    }

    private void mainLogic() {
        //grid language layout
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false);
        langRecycler.setLayoutManager(gridLayoutManager);
        langRecycler.setHasFixedSize(true);

        LanguageDataAdapter languageDataAdapter = new LanguageDataAdapter(languageDataModelList);
        loadLangData(languageDataAdapter);
        langRecycler.setAdapter(languageDataAdapter);
    }
}