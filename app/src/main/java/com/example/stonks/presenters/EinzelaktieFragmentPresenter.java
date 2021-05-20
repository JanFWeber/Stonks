package com.example.stonks.presenters;

import com.example.stonks.repository.EXCloudCalls;
import com.example.stonks.views.viewInterfaces.IEinzelaktieFragment;

import java.text.DecimalFormat;

public class EinzelaktieFragmentPresenter {

    private IEinzelaktieFragment einzelaktieFragment;
    DecimalFormat decimalFormat = new DecimalFormat("#.00");
    private String symbol;


    public EinzelaktieFragmentPresenter(IEinzelaktieFragment einizelaktieFragment, String symbol) {
        this.symbol = symbol;
        this.einzelaktieFragment = einzelaktieFragment;
        EXCloudCalls.getInstance().setQuote(this.symbol);
    }

    public String getName(String symbol){
        return EXCloudCalls.getInstance().getCompanyName(symbol);
    }

    public String getPrice(String symbol){
        return decimalFormat.format(EXCloudCalls.getInstance().getPrice(symbol));
    }

    public String getOpen(String symbol){
        return decimalFormat.format("Open: " + EXCloudCalls.getInstance().getOpen(symbol));
    }

    public String getLow(String symbol){
        return decimalFormat.format("Low: " + EXCloudCalls.getInstance().getLow(symbol));
    }

    public String getVolume(String symbol){
        return decimalFormat.format("Volume: " + EXCloudCalls.getInstance().getVolume(symbol));
    }

    public String getHigh(String symbol){
        return decimalFormat.format("High: " + EXCloudCalls.getInstance().getHigh(symbol));
    }

    public String getPeRatio(String symbol){
        return decimalFormat.format("P/E: " + EXCloudCalls.getInstance().getPeRatio(symbol));
    }

    public String getMktCap(String symbol){
        return decimalFormat.format("Mkt Cap: " + EXCloudCalls.getInstance().getMktCap(symbol));
    }

    public String getHigh52(String symbol){
        return decimalFormat.format("52W High: " + EXCloudCalls.getInstance().getHigh52(symbol));
    }

    public String getLow52(String symbol){
        return decimalFormat.format("52W Low: " + EXCloudCalls.getInstance().getLow52(symbol));
    }

    public String getAvgVol(String symbol){
        return decimalFormat.format("Avg Vol: " + EXCloudCalls.getInstance().getAvgVol(symbol));
    }

}
