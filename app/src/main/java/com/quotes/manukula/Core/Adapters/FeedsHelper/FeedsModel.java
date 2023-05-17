package com.quotes.manukula.Core.Adapters.FeedsHelper;

public class FeedsModel {

    private String feedUserImage;
    private String feedUserName;
    private String feedUserFeed;
    private int feedLikes;

    public FeedsModel(String feedUserImage, String feedUserName, String feedUserFeed, int feedLikes) {
        this.feedUserImage = feedUserImage;
        this.feedUserName = feedUserName;
        this.feedUserFeed = feedUserFeed;
        this.feedLikes = feedLikes;
    }

    public String getFeedUserImage() {
        return feedUserImage;
    }

    public void setFeedUserImage(String feedUserImage) {
        this.feedUserImage = feedUserImage;
    }

    public String getFeedUserName() {
        return feedUserName;
    }

    public void setFeedUserName(String feedUserName) {
        this.feedUserName = feedUserName;
    }

    public String getFeedUserFeed() {
        return feedUserFeed;
    }

    public void setFeedUserFeed(String feedUserFeed) {
        this.feedUserFeed = feedUserFeed;
    }

    public int getFeedLikes() {
        return feedLikes;
    }

    public void setFeedLikes(int feedLikes) {
        this.feedLikes = feedLikes;
    }
}
