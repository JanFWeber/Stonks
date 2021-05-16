package com.example.stonks.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.stonks.R;
import com.example.stonks.presenters.EinzelaktieFragmentPresenter;
import com.example.stonks.repository.EXCloudCalls;
import com.example.stonks.views.viewInterfaces.IEinzelaktieFragment;


public class EinzelaktieFragment extends Fragment implements IEinzelaktieFragment {

    EXCloudCalls exCloudCalls = com.example.stonks.repository.EXCloudCalls.getInstance();

    TextView itemTextView;
    TextView itemTextViewPreis;
    TextView itemOpen;
    TextView itemLow;
    TextView itemVolume;
    TextView itemHigh;
    TextView itemPeRatio;
    TextView itemMktCap;
    TextView itemHigh52;
    TextView itemLow52;
    TextView itemAvgVol;
    TextView itemEps;



    private String symbol;

    private EinzelaktieFragmentPresenter einzelaktieFragmentPresenter;

    public EinzelaktieFragment(String symbol) {
        this.symbol = symbol;
        einzelaktieFragmentPresenter = new EinzelaktieFragmentPresenter(this);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_einzelaktie, container, false);

        EXCloudCalls.getInstance().setQuote(symbol);

        itemTextView = v.findViewById(R.id.textViewAktie);
        itemTextView.setText(einzelaktieFragmentPresenter.getName(symbol));

        itemTextViewPreis = v.findViewById(R.id.textViewPreis);
        itemTextViewPreis.setText(einzelaktieFragmentPresenter.getPrice(symbol));

        itemOpen = v.findViewById(R.id.openPrice);
        itemOpen.setText(einzelaktieFragmentPresenter.getOpen(symbol));

        itemLow = v.findViewById(R.id.lowPrice);
        itemLow.setText(einzelaktieFragmentPresenter.getLow(symbol));

        itemVolume = v.findViewById(R.id.volume);
        itemVolume.setText(einzelaktieFragmentPresenter.getVolume(symbol));

        itemHigh =  v.findViewById(R.id.highPrice);
        itemHigh.setText(einzelaktieFragmentPresenter.getHigh(symbol));

        itemPeRatio = v.findViewById(R.id.peRatio);
        itemPeRatio.setText(einzelaktieFragmentPresenter.getPeRatio(symbol));

        itemMktCap = v.findViewById(R.id.mktCap);
        itemMktCap.setText(einzelaktieFragmentPresenter.getMktCap(symbol));

        itemHigh52 = v.findViewById(R.id.high52W);
        itemHigh52.setText(einzelaktieFragmentPresenter.getHigh52(symbol));

        itemLow52 = v.findViewById(R.id.low52W);
        itemLow52.setText(einzelaktieFragmentPresenter.getLow52(symbol));

        itemAvgVol = v.findViewById(R.id.avgVol);
        itemAvgVol.setText(einzelaktieFragmentPresenter.getAvgVol(symbol));

        //itemEps = v.findViewById(R.id.eps);





        return v;
    }


    @Override
    public void fetchDataSuccessful() {

    }

    @Override
    public void fetchDataFailed() {

    }
}