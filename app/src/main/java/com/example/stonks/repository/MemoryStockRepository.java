package com.example.stonks.repository;

import com.example.stonks.models.Item;

import java.util.ArrayList;

public class MemoryStockRepository implements IRepository {

    private ArrayList<Item> stockList;

    private static MemoryStockRepository _instance;

    public static MemoryStockRepository GetInstance() {
        if (_instance == null) {
            _instance = new MemoryStockRepository();
        }

        return _instance;
    }

    @Override
    public void addItem(Item x) {
        // sucht ob Item x bereits Teil der Liste ist, sonst wird es hinzugefügt
        // muss höchstwrs. abgeändert werden, dass anhand einer ID abgeglichen wird!
        for (Item i : stockList) {
            if (i.equals(x)) {
                break;
            }
        }
        stockList.add(x);
    }

    @Override
    public void removeItem(Item x) {
        // sucht nach Item x, und löscht es wenn gefunden, sonst geschieht nichts
        // muss höchstwrs. abgeändert werden, dass anhand einer ID abgeglichen wird!
        for (Item i : stockList) {
            if (i.equals(x)) {
                stockList.remove(i);
                break;
            }
        }

    }

    @Override
    public void updateList() {
        // to be completed
    }

    @Override
    public void saveList() {
        // to be completed

    }

    public void loadList() {

    }

    @Override
    public ArrayList<Item> getList() {
        return stockList;
    }

    public void setList(ArrayList<Item> x) {
        this.stockList = x;
    }
}