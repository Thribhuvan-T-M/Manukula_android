package com.quotes.manukula.Core.Models.OnBoardingModels;

public class LanguageDataModel {

    private String image;
    private String title;
    private String index;

    public LanguageDataModel(String index, String image, String title) {
        this.image = image;
        this.title = title;
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
