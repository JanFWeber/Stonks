package com.example.stonks.repository;

import com.example.stonks.models.Item;

import java.util.ArrayList;

public class MemoryStockRepository implements IRepository {

    private ArrayList<Item> stockList;


    @Override
    public void addItem(Item x) {
        // sucht ob Item x bereits Teil der Liste ist, sonst wird es hinzugefügt
        // sucht nun anhand von Symbol
        for (Item i : stockList) {
            if (i.getSymbol().equals(x.getSymbol())) {
                return;
            }
        }
        stockList.add(x);
    }

    @Override
    public void removeItem(Item x) {
        // sucht nach Item x, und löscht es wenn gefunden, sonst geschieht nichts
        // sucht nun anhand von Symbol
        for (Item i : stockList) {
            if (i.getSymbol().equals(x.getSymbol())) {
                stockList.remove(i);
                return;
            }
        }

    }

    @Override
    public void updateList() {
        // to be completed
    }


    @Override
    public ArrayList<Item> getList() {

        return stockList;
    }

    public void setList(ArrayList<Item> x) {

        this.stockList = x;
    }
}