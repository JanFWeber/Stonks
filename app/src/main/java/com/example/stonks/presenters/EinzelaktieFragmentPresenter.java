package com.example.stonks.presenters;

import android.widget.TextView;

import com.example.stonks.R;
import com.example.stonks.repository.EXCloudCalls;
import com.example.stonks.views.fragments.EinzelaktieFragment;
import com.example.stonks.views.viewInterfaces.IEinzelaktieFragment;

import java.text.DecimalFormat;

public class EinzelaktieFragmentPresenter {

    private IEinzelaktieFragment einzelaktieFragment;

    public EinzelaktieFragmentPresenter(IEinzelaktieFragment einzelaktieFragment) {
        this.einzelaktieFragment = einzelaktieFragment;
    }

    public void getDetailedData (String symbol){
        EXCloudCalls exCloudCalls = EXCloudCalls.getInstance();

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


        itemTextView = (TextView) findViewById(R.id.textViewAktie);
        itemTextViewPreis = (TextView) findViewById(R.id.textViewPreis);
        itemOpen = (TextView) findViewById(R.id.openPrice);
        itemLow = (TextView) findViewById(R.id.lowPrice);
        itemVolume = (TextView) findViewById(R.id.volume);
        itemHigh = (TextView) findViewById(R.id.highPrice);
        itemPeRatio = (TextView) findViewById(R.id.peRatio);
        itemMktCap = (TextView) findViewById(R.id.mktCap);
        itemHigh52 = (TextView) findViewById(R.id.high52W);
        itemLow52W = (TextView) findViewById(R.id.low52W);
        itemAvgVol = (TextView) findViewById(R.id.avgVol);
        itemEps = (TextView) findViewById(R.id.eps);


        String symbol = item.getSymbol();
        itemTextView.setText(item.getName());
        //Formatierung von float zu String mit 2 Nachkommastellen
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        //String value = decimalFormat.format(item.getValue());
        String value = decimalFormat.format(item.getValue());
        itemTextViewPreis.setText(value);
        String open = decimalFormat.format("Open: " + exCloudCalls.getOpen(symbol));
        itemOpen.setText(open);
        String low = decimalFormat.format("Low: " + exCloudCalls.getLow(symbol));
        itemLow.setText(low);
        String volume = decimalFormat.format("Volume: " + exCloudCalls.getVolume(symbol));
        itemVolume.setText(volume);
        String high = decimalFormat.format("High: " + exCloudCalls.getHigh(symbol));
        itemHigh.setText(high);
        String peratio = decimalFormat.format("P/E: " + exCloudCalls.getPeRatio(symbol));
        itemPeRatio.setText(peratio);
        String mktcap = decimalFormat.format("Mkt Cap: " + exCloudCalls.getMktCap(symbol));
        itemMktCap.setText(mktcap);
        String high52 = decimalFormat.format("52W High: " + exCloudCalls.getHigh52(symbol));
        itemHigh52.setText(high52);
        String low52 = decimalFormat.format("52W Low: " + exCloudCalls.getLow52(symbol));
        itemLow52W.setText(low52);
        String avgvol = decimalFormat.format("Avg Vol: " + exCloudCalls.getAvgVol(symbol));
        itemAvgVol.setText(avgvol);
        String eps = decimalFormat.format("EPS: " + exCloudCalls.getEps(symbol));
        itemEps.setText(eps);


        einzelaktieFragment.fetchData(symbol);
    }
}
