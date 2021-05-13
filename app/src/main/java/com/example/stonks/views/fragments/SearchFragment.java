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
import com.example.stonks.repository.EXCloudCalls;

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
                EXCloudCalls exCloudCalls = EXCloudCalls.getInstance();
                try {
                    System.out.println("Preis: " + exCloudCalls.getPrice(symbol));
                    System.out.println("ImageLink: " + exCloudCalls.getLogoLink(symbol));
                    System.out.println("Change Percent: " + exCloudCalls.getChangePercent(symbol));
                } catch (PyException pyException) {
                    Toast.makeText(getActivity(), "Enter a valid symbol.", Toast.LENGTH_LONG).show();
                } catch (NullPointerException exception) {
                    Toast.makeText(getActivity(), "Something went wrong.", Toast.LENGTH_LONG).show();
                }

            }
        });

        return rootView;
    }
}
