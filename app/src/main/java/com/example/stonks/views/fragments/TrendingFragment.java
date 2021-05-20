package com.example.stonks.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stonks.R;
import com.example.stonks.presenters.TrendingFragmentPresenter;

import java.util.ArrayList;
import java.util.Arrays;

public class TrendingFragment extends Fragment {

    RecyclerView.LayoutManager rvlayoutManagerTrending;
    RecyclerView recyclerViewTrending;
    RecyclerView.Adapter rvadapterTrending;

    public static ArrayList<String> trendingKurs;
    public static ArrayList<String> trendingName;
    public static ArrayList<Integer> trendingLogo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View m = inflater.inflate(R.layout.fragment_trending, container, false);

        trendingKurs = new ArrayList<>();
        trendingName = new ArrayList<>();
        trendingLogo = new ArrayList<>();


        trendingKurs.addAll(Arrays.asList("+6,22%", "+4,01%", "+2,98%", "+2,90%", "+1,22%","+1,11%","+0,80%", "+0;00%", "-0,72%", "-2,32%", "-2,32%","-10,13%"));
        trendingName.addAll(Arrays.asList("Tesla Inc", "SAP SE", "McDonalds's Corp. Com", "Aurora Cannabis", "Alphabet Inc","Apple Inc","Nestle SA", "Uber Technologies Inc", "Netflix Inc", "Procter & Gamble", "BYD Ord Shs H","Curevac NV"));
        trendingLogo.addAll(Arrays.asList(R.drawable.ic_tesla_motors, R.drawable.ic_sap_logo, R.drawable.ic_mcdonald_s_logo, R.drawable.ic_abbvie_logo, R.drawable.ic_alphabet_inc_logo_2015, R.drawable.ic_apple_logo_black, R.drawable.ic_nestle_textlogo_blue__1_, R.drawable.ic_uber_logo_2018, R.drawable.ic_netflix_2015_logo, R.drawable.ic_p_g_logo_svg, R.drawable.ic_byd_auto_logo, R.drawable.ic_curevac_logo));

        recyclerViewTrending = (RecyclerView) m.findViewById(R.id.recyclerView3);
        rvlayoutManagerTrending = new LinearLayoutManager(getContext());
        recyclerViewTrending.setLayoutManager(rvlayoutManagerTrending);
        recyclerViewTrending.addItemDecoration(new DividerItemDecoration(recyclerViewTrending.getContext(), DividerItemDecoration.VERTICAL));

        rvadapterTrending =new TrendingFragmentPresenter();
        recyclerViewTrending.setAdapter(rvadapterTrending);





        return m;



    }

}
