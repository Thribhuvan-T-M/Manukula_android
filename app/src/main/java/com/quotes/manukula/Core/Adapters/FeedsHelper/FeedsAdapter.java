package com.quotes.manukula.Core.Adapters.FeedsHelper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.quotes.manukula.R;

import java.util.List;

public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.ViewHolder> {

    private final List<FeedsModel> feedsModelList;

    public FeedsAdapter(List<FeedsModel> feedsModelList) {
        this.feedsModelList = feedsModelList;
    }

    @NonNull
    @Override
    public FeedsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedsAdapter.ViewHolder holder, int position) {
        FeedsModel feedsModel = feedsModelList.get(position);
        String image = feedsModel.getFeedUserImage();
        String name = feedsModel.getFeedUserName();
        String feed = feedsModel.getFeedUserFeed();
        String likes = String.valueOf(feedsModel.getFeedLikes());

        holder.setFeedData(image, name, feed, likes);

        String shareContent = holder.itemView.getResources().getString(R.string.app_name)
                + "\n\n" + feed + "\n\n" + "-" + name;

        shareButton(holder, shareContent);
    }

    private void shareButton(@NonNull FeedsAdapter.ViewHolder holder, String quotes) {
        holder.userShareButton.setOnClickListener(view -> shareApp(holder.itemView.getContext(), quotes));
    }

    public static void shareApp(@NonNull Context context, String quotes) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, quotes);
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }

    @Override
    public int getItemCount() {
        return feedsModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView userImage;
        private final TextView userName;
        private final TextView userFeed;
        private final TextView userLikes;
        private final ImageView userShareButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.feed_user_image);
            userName = itemView.findViewById(R.id.feed_user_name_tv);
            userFeed = itemView.findViewById(R.id.feed_user_entered_feed_tv);
            userLikes = itemView.findViewById(R.id.feed_users_likes);
            userShareButton = itemView.findViewById(R.id.feed_users_share);
        }

        private void setFeedData(String image, String name, String feed, String likes) {
            Glide.with(itemView.getContext()).load(image)
                    .apply(new RequestOptions().placeholder(R.drawable.logo_2)).into(userImage);

            userName.setText(name);
            userFeed.setText(feed);
            userLikes.setText(likes);
        }
    }
}
