package com.example.stonks.presenters;

import com.example.stonks.models.Item;
import com.example.stonks.repository.EXCloudCalls;
import com.example.stonks.views.viewInterfaces.IEinzelaktieFragment;

public class EinzelaktieFragmentPresenter {

    private IEinzelaktieFragment einzelaktieFragment;

    public EinzelaktieFragmentPresenter(IEinzelaktieFragment einzelaktieFragment) {
        this.einzelaktieFragment = einzelaktieFragment;
    }

    public void getDetailedData (){
        Item i = new Item(); //item info ziehen
        EXCloudCalls exCloudCalls = EXCloudCalls.getInstance();



    }
}
