package com.example.stonks.models;

public class Crypto extends Item{

    private float tokensAvailable;
    private int circulatingSupply;
    private int totalSupply;
    private int maxSupply;

    public Crypto(String name, String symbol, String logoURL) {
        super(name, symbol, logoURL);
    }

    private void setTokensAvailable(float x){
        this.tokensAvailable = x;
    }

    private float getTokensAvailable(){
        return this.tokensAvailable;
    }

    private void setCirculatingSupply(int x){
        this.circulatingSupply = x;
    }

    private int getCirculatingSupply(){
        return this.circulatingSupply;
    }

    private void setTotalSupply(int x){
        this.totalSupply = x;
    }

    private int getTotalSupply(){
        return this.totalSupply;
    }

    private void setMaxSupply(int x){
        this.maxSupply = x;
    }

    private int getMaxSupply(){
        return this.maxSupply;
    }
}
