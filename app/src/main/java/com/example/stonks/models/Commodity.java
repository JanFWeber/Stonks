package com.example.stonks.models;

public class Commodity extends Item{

    private String unit;

    public Commodity(String name, String symbol, String logoURL, String unit) {
        super(name, symbol, logoURL);
        this.unit = unit;
    }
}
