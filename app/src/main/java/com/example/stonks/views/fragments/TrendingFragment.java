package com.example.stonks.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.stonks.R;

public class TrendingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trending, container, false);
    }

    /*
    new void LinearLayout{
        ArrayList<Item> items = StockService.GetInstance().getList();
        add.items.getchangepercent.sort();
    }


    public void sort (){
        for(int i=1; i<=items.length()-1; i++){
            items[0] = element[i];
            int j = i-1;
            while(j>=0 && items[0].compareTo(element[j]) < 0){
                element[j+1] = element[j];
                j--;
            }
            element[j+1] = items[0];
        }
    }
    */
}
