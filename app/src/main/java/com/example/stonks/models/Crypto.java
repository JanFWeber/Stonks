package com.example.stonks.models;

public class Crypto extends Item{

    private float tokensAvailable;
    private int circulatingSupply;
    private int totalSupply;
    private int maxSupply;

    public Crypto(String name, String symbol, String logoURL) {
        super(name, symbol, logoURL);
    }

    public void setTokensAvailable(float x){
        this.tokensAvailable = x;
    }

    public float getTokensAvailable(){
        return this.tokensAvailable;
    }

    public void setCirculatingSupply(int x){
        this.circulatingSupply = x;
    }

    public int getCirculatingSupply(){
        return this.circulatingSupply;
    }

    public void setTotalSupply(int x){
        this.totalSupply = x;
    }

    public int getTotalSupply(){
        return this.totalSupply;
    }

    public void setMaxSupply(int x){
        this.maxSupply = x;
    }

    public int getMaxSupply(){
        return this.maxSupply;
    }
}
