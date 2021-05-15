package com.example.stonks.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.chaquo.python.PyException;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.example.stonks.R;
import com.example.stonks.models.Stock;
import com.example.stonks.presenters.SearchFragmentPresenter;
import com.example.stonks.repository.EXCloudCalls;
import com.example.stonks.views.viewInterfaces.ISearchFragment;

public class SearchFragment extends Fragment implements ISearchFragment {

    private Button searchButton;
    private EditText searchStockText;
    private SearchFragmentPresenter searchFragmentPresenter;

    public SearchFragment() {
        searchFragmentPresenter = new SearchFragmentPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        searchStockText = rootView.findViewById(R.id.searchStockText);

        searchButton = rootView.findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String symbol = searchStockText.getText().toString();
                System.out.println(symbol);
                try {
                    Stock stock = searchFragmentPresenter.searchStock(symbol);
                    searchFragmentPresenter.addStock(stock);
                } catch (PyException pyException) {
                    Toast.makeText(getActivity(), "Enter a valid symbol.", Toast.LENGTH_LONG).show();
                } catch (NullPointerException nullPointerException) {
                    Toast.makeText(getActivity(), "Something went wrong.", Toast.LENGTH_LONG).show();
                }

            }
        });

        return rootView;
    }

    @Override
    public void stockAddedSuccesful() {

    }

    @Override
    public void stockAddedFailed(String msg) {

    }
}
