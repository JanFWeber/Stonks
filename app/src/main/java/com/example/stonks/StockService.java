package com.example.stonks;

import com.example.stonks.models.Item;
import com.example.stonks.repository.IRepository;
import com.example.stonks.repository.MemoryStockRepository;

import java.util.ArrayList;

public class StockService {

    private static StockService _instance;

    private IRepository repository;

    private StockService(IRepository repository) {
        this.repository = repository;
    }


    public static StockService GetInstance() {
        if (_instance == null) {
            _instance = new StockService(new MemoryStockRepository());
        }

        return _instance;
    }

    public void addItem(Item x) {
        repository.addItem(x);
    }


    public void removeItem(Item x) {
        repository.removeItem(x);
    }


    public void updateList(){

    }

    public ArrayList<Item> getList(){
        return repository.getList();

    }

    public void setList(ArrayList<Item> x){
        repository.setList(x);
    }


}

