package com.example.stonks.presenters;

import android.widget.Toast;

import com.chaquo.python.PyException;
import com.example.stonks.StockService;
import com.example.stonks.models.Stock;
import com.example.stonks.repository.EXCloudCalls;
import com.example.stonks.views.viewInterfaces.ISearchFragment;

public class SearchFragmentPresenter{
    private ISearchFragment searchFragment;

    public SearchFragmentPresenter(ISearchFragment searchFragment) {
        this.searchFragment = searchFragment;
    }

    public void addStock(Stock stock) {
        /*if(stock == null) {
            searchFragment.stockAddedFailed("No stock");
            return;;
        }

        if(stock.getName() == null || stock.getName().isEmpty()) {

        } */
        StockService.GetInstance().addItem(stock);
        searchFragment.stockAddedSuccesful();
    }

    public Stock searchStock(String symbol) throws PyException, NullPointerException {
        //Test if Python script is working
        EXCloudCalls exCloudCalls = EXCloudCalls.getInstance();
        System.out.println("Preis: " + exCloudCalls.getPrice(symbol));
        System.out.println("ImageLink: " + exCloudCalls.getLogoLink(symbol));
        System.out.println("Change Percent: " + exCloudCalls.getChangePercent(symbol));
        System.out.println("ChartData: " + exCloudCalls.getChartData(symbol));
        System.out.println(("CompanyName: " + exCloudCalls.getCompanyName(symbol)));
        String companyName = exCloudCalls.getCompanyName((symbol));

        return new Stock(companyName, symbol);
    }

    /*
    Verbindung zur api muss noch hergestellt werden.
    Kann eine Suchleiste erscheinen oder wie kann man die Suche mit Hilfe der api umsetzen?
     */
}
