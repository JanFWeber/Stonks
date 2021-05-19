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
        StockService.GetInstance().addItem(stock);
        searchFragment.stockAddedSuccesful();
    }

    public Stock searchStock(String symbol) throws PyException, NullPointerException {
        return StockService.GetInstance().searchStock(symbol);
    }

}
