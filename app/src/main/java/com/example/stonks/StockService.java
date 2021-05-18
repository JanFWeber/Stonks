package com.example.stonks;

import com.example.stonks.models.Item;
import com.example.stonks.models.Stock;
import com.example.stonks.repository.EXCloudCalls;
import com.example.stonks.repository.IRepository;
import com.example.stonks.repository.MemoryStockRepository;

import java.util.ArrayList;

public class StockService {

    private static StockService _instance;
    private EXCloudCalls exCloudCalls;

    private IRepository repository;

    private StockService(IRepository repository) {
        this.repository = repository;
        exCloudCalls = EXCloudCalls.getInstance();
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


    public ArrayList<Item> getWatchlistItems(){
        //Aktuelle Daten von API abfragen
        ArrayList<Item> items = repository.getList();
        for(Item i: items) {
            String symbol = i.getSymbol();
            i.setValue(exCloudCalls.getPrice(symbol));
            i.setChange(exCloudCalls.getChangePercent(symbol));
        }
        return items;
    }

    public ArrayList<Item> getList(){
        return repository.getList();
    }

    public Stock searchStock(String symbol) {
        //Test if Python script is working
        //System.out.println("Preis: " + exCloudCalls.getPrice(symbol));
        //System.out.println("ImageLink: " + exCloudCalls.getLogoLink(symbol));
        //System.out.println("Change Percent: " + exCloudCalls.getChangePercent(symbol));
        //System.out.println("ChartData: " + exCloudCalls.getChartData(symbol));
        //System.out.println(("CompanyName: " + exCloudCalls.getCompanyName(symbol)));
        String companyName = exCloudCalls.getCompanyName((symbol));
        String logourl = exCloudCalls.getLogoLink(symbol);

        return new Stock(companyName, symbol, logourl);
    }

    public void setList(ArrayList<Item> x){
        repository.setList(x);
    }


}

