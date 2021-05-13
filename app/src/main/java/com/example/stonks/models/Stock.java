package com.example.stonks.models;

public class Stock extends Item {

    private int id_isin;
    private String symbol;

    public Stock(String name, int id_isin, String symbol) {
        super(name);
        this.id_isin = id_isin;
        this.symbol = symbol;
    }
}
