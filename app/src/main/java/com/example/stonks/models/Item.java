package com.example.stonks.models;

public class Item {
    private String name;
    private float value;
    private float change;
    private String symbol;

    public Item(String name, String symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName(){
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public float getValue(){
        return this.value;
    }

    public void setValue(float value){
        this.value = value;
    }

    public float getChange(){
        return this.change;
    }

    public void setChange(float change){
        this.change = change;
    }

}
