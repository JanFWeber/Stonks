package com.example.stonks.models;

public class Stock extends Item {

    private int id_isin;

    public Stock(String name, String symbol, int id_isin) {
        super(name, symbol);
        this.id_isin = id_isin;
    }
}
