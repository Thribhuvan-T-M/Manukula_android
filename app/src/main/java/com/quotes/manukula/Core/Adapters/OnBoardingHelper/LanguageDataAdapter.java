package com.quotes.manukula.Core.Adapters.OnBoardingHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.quotes.manukula.Core.Models.OnBoardingModels.LanguageDataModel;
import com.quotes.manukula.R;

import java.util.List;

public class LanguageDataAdapter extends RecyclerView.Adapter<LanguageDataAdapter.ViewHolder> {

    private final List<LanguageDataModel> languageDataModelList;

    public LanguageDataAdapter(List<LanguageDataModel> languageDataModelList) {
        this.languageDataModelList = languageDataModelList;
    }

    @NonNull
    @Override
    public LanguageDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.on_boarding_lang_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageDataAdapter.ViewHolder holder, int position) {
        LanguageDataModel languageDataModel = languageDataModelList.get(position);
        String title = languageDataModel.getTitle();
        String image = languageDataModel.getImage();

        holder.setLangData(image, title);
    }

    @Override
    public int getItemCount() {
        return languageDataModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView langImage;
        private final TextView langTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            langImage = itemView.findViewById(R.id.on_lang_image);
            langTitle = itemView.findViewById(R.id.on_lang_title);
        }

        private void setLangData(String image, String title) {
            langTitle.setText(title);
            Glide.with(itemView.getContext())
                    .load(image).apply(new RequestOptions().placeholder(R.drawable.button_bg))
                    .into(langImage);
        }
    }
}
