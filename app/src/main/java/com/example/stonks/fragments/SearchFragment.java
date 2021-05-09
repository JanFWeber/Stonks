package com.example.stonks.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.example.stonks.R;

public class SearchFragment extends Fragment {

    private Button searchButton;
    private EditText searchStockText;

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
                //Test if Python script is working
                Python python = Python.getInstance();
                PyObject pythonfile = python.getModule("script");
                String answer = pythonfile.callAttr("helloworld", symbol).toString();
            }
        });

        return rootView;
    }
}
