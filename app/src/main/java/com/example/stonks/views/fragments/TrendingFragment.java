package com.example.stonks.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stonks.R;
import com.example.stonks.presenters.NewsFragmentPresenter;
import com.example.stonks.presenters.TrendingFragmentPresenter;

import java.util.ArrayList;
import java.util.Arrays;

public class TrendingFragment extends Fragment {

    RecyclerView.LayoutManager rvlayoutManagerTrending;
    RecyclerView recyclerViewTrending;
    RecyclerView.Adapter rvadapterTrending;

    public static ArrayList<String> trendingKurs;
    public static ArrayList<String> trendingName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View m = inflater.inflate(R.layout.fragment_trending, container, false);

        trendingKurs = new ArrayList<>();
        trendingName = new ArrayList<>();



        trendingKurs.addAll(Arrays.asList("Kurs 1", "Kurs 2", "Kurs 3", "Kurs 4", "Kurs 5","Kurs 6","Kurs 7", "Kurs 8", "Kurs 9", "Kurs 10", "Kurs 11","Kurs 12"));
        trendingName.addAll(Arrays.asList("Name 1", "Name 2", "Name 3", "Name 4", "Name 5","Name 6","Name 7", "Name 8", "Name 9", "Name 10", "Name 11","Name 12"));


        recyclerViewTrending = (RecyclerView) m.findViewById(R.id.recyclerView3);
        rvlayoutManagerTrending = new LinearLayoutManager(getContext());
        recyclerViewTrending.setLayoutManager(rvlayoutManagerTrending);

        rvadapterTrending =new TrendingFragmentPresenter();
        recyclerViewTrending.setAdapter(rvadapterTrending);





        return m;



    }

}
