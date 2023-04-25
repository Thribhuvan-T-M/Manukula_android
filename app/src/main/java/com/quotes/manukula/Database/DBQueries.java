package com.quotes.manukula.Database;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.quotes.manukula.Core.Adapters.OnBoardingHelper.LanguageDataAdapter;
import com.quotes.manukula.Core.Models.OnBoardingModels.LanguageDataModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBQueries {

    public static List<LanguageDataModel> languageDataModelList = new ArrayList<>();


    @SuppressLint("NotifyDataSetChanged")
    public static void loadLangData(LanguageDataAdapter adapter) {
        languageDataModelList.clear();
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();

        firestore.collection("Languages").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (DocumentSnapshot snapshot : task.getResult()) {
                    languageDataModelList.add(new LanguageDataModel(
                            snapshot.getString("image"),
                            snapshot.getString("title")
                    ));
                }
                adapter.notifyDataSetChanged();
            } else {
                Log.e("error",
                        "" + Objects.requireNonNull(task.getException()).getMessage());
            }
        });
    }

}
