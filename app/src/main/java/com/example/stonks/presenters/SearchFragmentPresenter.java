package com.example.stonks.presenters;

import com.example.stonks.views.viewInterfaces.ISearchFragment;

public class SearchFragmentPresenter {
    private ISearchFragment searchFragment;

    public SearchFragmentPresenter(ISearchFragment searchFragment) {
        this.searchFragment = searchFragment;
    }
}
