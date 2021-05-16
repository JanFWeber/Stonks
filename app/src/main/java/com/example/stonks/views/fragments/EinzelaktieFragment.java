package com.example.stonks.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.stonks.R;
import com.example.stonks.presenters.EinzelaktieFragmentPresenter;
import com.example.stonks.repository.EXCloudCalls;
import com.example.stonks.views.viewInterfaces.IEinzelaktieFragment;


public class EinzelaktieFragment extends Fragment implements IEinzelaktieFragment {

    EXCloudCalls exCloudCalls = com.example.stonks.repository.EXCloudCalls.getInstance();


    private String symbol;

    private EinzelaktieFragmentPresenter einzelaktieFragmentPresenter;

    public EinzelaktieFragment() {
        einzelaktieFragmentPresenter = new EinzelaktieFragmentPresenter(this);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_einzelaktie, container, false);






        return v;
    }

    @Override
    public void fetchData(String symbol) {

    }


}