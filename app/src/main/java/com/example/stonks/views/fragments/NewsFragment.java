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

import java.util.ArrayList;
import java.util.Arrays;

public class NewsFragment extends Fragment {

    RecyclerView.LayoutManager rvlayoutManagerNews;
    RecyclerView recyclerViewNews;
    RecyclerView.Adapter rvadapterNews;

    public static ArrayList<String> newsNachricht;
    public static ArrayList<Integer> newsLogo;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View n = inflater.inflate(R.layout.fragment_news, container, false);


        newsNachricht = new ArrayList<>();
        newsLogo = new ArrayList<>();



        newsNachricht.addAll(Arrays.asList(" Adidas plant Wiederaufnahme von Dividendenzahlung", " Sicherheitslücke bei neuen Apple AirTags entdeckt", " Biontech und Moderna wirken wohl auch gegen indische Virus-Variante", " Negativzinsen: Ist die Dividendenaktie Coca-Cola das richtige Heilmittel?", "Nachricht 5","Nachricht 6", "Nachricht 7", "Nachricht 8", "Nachricht 9", "Nachricht 10", "Nachricht 11","Nachricht 12"));
        newsLogo.addAll(Arrays.asList(R.drawable.ic_adidas_logo, R.drawable.ic_apple_logo_black, R.drawable.ic_biontech_logo, R.drawable.ic_coca_cola_logo, R.drawable.ic_coinbase, R.drawable.ic_johnson_and_johnson_logo, R.drawable.ic_mastercard_2019_logo, R.drawable.ic_mcdonald_s_logo, R.drawable.ic_microsoft_logo, R.drawable.ic_sap_logo, R.drawable.ic_square__inc__logo, R.drawable.ic_tesla_motors));


        recyclerViewNews = (RecyclerView) n.findViewById(R.id.recyclerView2);
        rvlayoutManagerNews = new LinearLayoutManager(getContext());
        recyclerViewNews.setLayoutManager(rvlayoutManagerNews);

        rvadapterNews =new NewsFragmentPresenter();
        recyclerViewNews.setAdapter(rvadapterNews);





        return n;
    }
}
