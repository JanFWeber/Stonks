package com.example.stonks.models;

import java.net.URL;

public class Item {
    private String name;
    private double value;
    private double change;
    private String symbol;
    private String logoURL;

    public Item(String name, String symbol, String logoURL){
        this.name = name;
        this.symbol = symbol;
        this.logoURL = logoURL;
    }

    public String getName(){
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public double getValue(){
        return this.value;
    }

    public void setValue(double value){
        this.value = value;
    }

    public double getChange(){
        return this.change;
    }

    public void setChange(double change){
        this.change = change;
    }

    public String getLogoURL() {
        return logoURL;
    }

}
