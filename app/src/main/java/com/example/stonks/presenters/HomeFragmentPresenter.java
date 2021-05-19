package com.example.stonks.presenters;

import com.example.stonks.StockService;
import com.example.stonks.models.Item;
import com.example.stonks.repository.EXCloudCalls;
import com.example.stonks.views.viewInterfaces.IHomeFragement;

import java.util.ArrayList;

public class HomeFragmentPresenter {

    private IHomeFragement homeFragement;

    public HomeFragmentPresenter(IHomeFragement homeFragement) {
        this.homeFragement = homeFragement;
    }

    public void getCurrentItems() {
        ArrayList<Item> items = StockService.GetInstance().getWatchlistItems();
        homeFragement.updateItemList(items);
    }



    /*
    getter von Search oder Plus knopf bzw aus dem Search fragment
    setter für das Fragment

    Listener wenn einzelne Aktie berührt wird
    setter für das "HomeFragment": muss sich dann zur einzelnen Aktie ändern (ggf neue Klasse o.ä.?)

     */

}
