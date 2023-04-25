package com.quotes.manukula.Core.Fragments.OnBoarding;

import static com.quotes.manukula.Database.DBQueries.categoryDataModelList;
import static com.quotes.manukula.Database.DBQueries.languageDataModelList;
import static com.quotes.manukula.Database.DBQueries.loadCatData;
import static com.quotes.manukula.Database.DBQueries.loadLangData;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quotes.manukula.Core.Adapters.OnBoardingHelper.LanguageDataAdapter;
import com.quotes.manukula.R;
public class CategoryFragment extends Fragment {

    private RecyclerView catRecycler;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        init(view);

        mainLogic();

        return view;
    }

    private void init(@NonNull View view) {
        catRecycler = view.findViewById(R.id.category_recycler);
    }

    private void mainLogic() {
        //grid language layout
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false);
        catRecycler.setLayoutManager(gridLayoutManager);
        catRecycler.setHasFixedSize(true);

        LanguageDataAdapter languageDataAdapter = new LanguageDataAdapter(categoryDataModelList);
        loadCatData(languageDataAdapter);
        catRecycler.setAdapter(languageDataAdapter);
    }

}