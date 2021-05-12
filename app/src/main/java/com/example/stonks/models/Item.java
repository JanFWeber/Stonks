package com.example.stonks.models;

public class Item {
    private String name;
    private float value;
    private float change;

    public Item(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
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
