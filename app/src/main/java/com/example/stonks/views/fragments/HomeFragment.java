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
import com.example.stonks.RvAdapterKlasse;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeFragment extends Fragment {

    RecyclerView.LayoutManager rvlayoutManager1;
    RecyclerView recyclerView1;
    RecyclerView.Adapter rvadapter1;

    public static ArrayList<String> itemName;
    public static ArrayList<Integer> itemLogo;
    public static ArrayList<String> itemPreis;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        itemName = new ArrayList<>();
        itemLogo = new ArrayList<>();
        itemPreis = new ArrayList<>();


        itemName.addAll(Arrays.asList("Adidas", "Apple", "BioNTech", "Coca Cola", "Coinbase","Johnson & Johnson", "Aktie 7", "Aktie 8", "Aktie 9", "Aktie 10", "Aktie 11","Aktie 12"));
        itemLogo.addAll(Arrays.asList(R.drawable.ic_adidas_logo, R.drawable.ic_apple_computer_logo_rainbow, R.drawable.ic_biontech_logo, R.drawable.ic_coca_cola_logo, R.drawable.ic_coinbase, R.drawable.ic_johnson_and_johnson_logo, R.drawable.ic_mastercard_2019_logo, R.drawable.ic_mcdonald_s_logo, R.drawable.ic_microsoft_logo, R.drawable.ic_sap_logo, R.drawable.ic_square__inc__logo, R.drawable.ic_tesla_motors));
        itemPreis.addAll(Arrays.asList("100.00", "200.00", "50.00", "40.00", "30.00","20.00", "10.00", "13.31", "120.10", "1.33", "2442.29","233.29"));

        recyclerView1 = (RecyclerView) v.findViewById(R.id.recyclerView1);
        rvlayoutManager1 = new LinearLayoutManager(getContext());
        recyclerView1.setLayoutManager(rvlayoutManager1);

        rvadapter1 =new RvAdapterKlasse();
        recyclerView1.setAdapter(rvadapter1);
        return v;
    }
}
