package com.quotes.manukula.Core.Fragments.Dashboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.quotes.manukula.Core.Adapters.FeedsHelper.FeedsAdapter;
import com.quotes.manukula.Core.Adapters.FeedsHelper.FeedsModel;
import com.quotes.manukula.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView feedsRecycler;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        init(view);

        mainLogic();

        return view;
    }

    private void init(View view) {
        feedsRecycler = view.findViewById(R.id.feedsRecycler);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void mainLogic() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        feedsRecycler.setLayoutManager(layoutManager);

        List<FeedsModel> feedsModelList = new ArrayList<>();
        feedsModelList.add(new FeedsModel("", "Mukunds", "“You can get everything in life you want if you will just help enough other people get what they want.”", 2));
        feedsModelList.add(new FeedsModel("", "Kushal", "“Inspiration does exist, but it must find you working.”", 6));
        feedsModelList.add(new FeedsModel("", "Thribhuvan", "“Don't settle for average. Bring your best to the moment. Then, whether it fails or succeeds, at least you know you gave all you had.”", 1));
        feedsModelList.add(new FeedsModel("", "Madhu sudhan", "“Show up, show up, show up, and after a while the muse shows up, too.”", 100));
        feedsModelList.add(new FeedsModel("", "Eshwar V", "“Don't bunt. Aim out of the ballpark. Aim for the company of immortals.”", 5));
        feedsModelList.add(new FeedsModel("", "Koushik M", "“I have stood on a mountain of no’s for one yes.”", 10));
        feedsModelList.add(new FeedsModel("", "Seena bro", "Nothing in the world can take the place of Persistence. Talent will not; nothing is more common than unsuccessful men with talent. Genius will not; unrewarded genius is almost a proverb. Education will not; the world is full of educated derelicts. The slogan 'Press On' has solved and always will solve the problems of the human race.", 2000));

        FeedsAdapter feedsAdapter = new FeedsAdapter(feedsModelList);
        feedsRecycler.setAdapter(feedsAdapter);
        feedsAdapter.notifyDataSetChanged();
    }
}