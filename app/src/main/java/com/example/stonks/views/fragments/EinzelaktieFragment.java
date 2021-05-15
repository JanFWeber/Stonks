package com.example.stonks.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stonks.R;
import com.example.stonks.StockService;
import com.example.stonks.models.Item;
import com.example.stonks.presenters.EinzelaktieFragmentPresenter;
import com.example.stonks.views.viewInterfaces.IEinzelaktieFragment;

import java.text.DecimalFormat;


public class EinzelaktieFragment extends Fragment implements IEinzelaktieFragment {


    StockService stockService;

    private EinzelaktieFragmentPresenter einzelaktieFragmentPresenter;

    public EinzelaktieFragment() {
        einzelaktieFragmentPresenter = new EinzelaktieFragmentPresenter(this);
    }

    public class ViewHolderKlasse extends RecyclerView.ViewHolder {
        TextView itemTextView;
        TextView itemTextViewPreis;
        TextView itemOpen;
        TextView itemLow;
        TextView itemVolume;
        TextView itemHigh;
        TextView itemPeRatio;
        TextView itemMktCap;
        TextView itemHigh52;
        TextView itemLow52W;
        TextView itemAvgVol;
        TextView itemEps;



        public ViewHolderKlasse(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            itemTextView = (TextView) itemView.findViewById(R.id.textViewAktie);
            itemTextViewPreis = (TextView) itemView.findViewById(R.id.textViewPreis);
            itemOpen = (TextView) itemView.findViewById(R.id.openPrice);
            itemLow = (TextView) itemView.findViewById(R.id.lowPrice);
            itemVolume = (TextView) itemView.findViewById(R.id.volume);
            itemHigh = (TextView) itemView.findViewById(R.id.highPrice);
            itemPeRatio = (TextView) itemView.findViewById(R.id.peRatio);
            itemMktCap = (TextView) itemView.findViewById(R.id.mktCap);
            itemHigh52 = (TextView) itemView.findViewById(R.id.high52W);
            itemLow52W = (TextView) itemView.findViewById(R.id.low52W);
            itemAvgVol = (TextView) itemView.findViewById(R.id.avgVol);
            itemEps = (TextView) itemView.findViewById(R.id.eps);
        }

        public void setStock(Item item) {
            itemTextView.setText(item.getName());
            //Formatierung von float zu String mit 2 Nachkommastellen
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            //String value = decimalFormat.format(item.getValue());
            String value = decimalFormat.format(item.getValue());
            itemTextViewPreis.setText(value);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_einzelaktie, container, false);

        stockService = StockService.GetInstance();
        // Inflate the layout for this fragment
        return v;
    }


}