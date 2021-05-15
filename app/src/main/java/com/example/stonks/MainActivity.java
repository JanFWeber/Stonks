package com.example.stonks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.stonks.models.Item;
import com.example.stonks.repository.MemoryStockRepository;
import com.example.stonks.views.fragments.HomeFragment;
import com.example.stonks.views.fragments.NewsFragment;
import com.example.stonks.views.fragments.SearchFragment;
import com.example.stonks.views.fragments.TrendingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    StockService stockService;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        MemoryStockRepository repo = new MemoryStockRepository();
        stockService = StockService.GetInstance();
        loadData();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        public boolean onNavigationItemSelected(@NonNull MenuItem item){
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_trending:
                    selectedFragment = new TrendingFragment();
                    break;
                case R.id.nav_news:
                    selectedFragment = new NewsFragment();
                    break;
                case R.id.nav_search:
                    selectedFragment = new SearchFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(stockService.getList());
        editor.putString("stocks", json);
        editor.apply();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("stocks", null);
        Type type = new TypeToken<ArrayList<Item>>() {}.getType();
        stockService.setList(gson.fromJson(json, type));
        if(stockService.getList() == null){
            stockService.setList(new ArrayList<Item>());
        }
    }

}