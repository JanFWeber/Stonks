package com.example.stonks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    StockService stockshelter;

    RecyclerView.LayoutManager rvlayoutManager1;
    RecyclerView recyclerView1;
    RecyclerView.Adapter rvadapter1;

    static ArrayList<String> itemName;
    static ArrayList<Integer> itemLogo;
    static ArrayList<String> itemPreis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemName = new ArrayList<>();
        itemLogo = new ArrayList<>();
        itemPreis = new ArrayList<>();


        itemName.addAll(Arrays.asList("Adidas", "Apple", "BioNTech", "Coca Cola", "Coinbase","Johnson & Johnson", "Aktie 7", "Aktie 8", "Aktie 9", "Aktie 10", "Aktie 11","Aktie 12"));
        itemLogo.addAll(Arrays.asList(R.drawable.ic_adidas_logo, R.drawable.ic_apple_computer_logo_rainbow, R.drawable.ic_biontech_logo, R.drawable.ic_coca_cola_logo, R.drawable.ic_coinbase, R.drawable.ic_johnson_and_johnson_logo, R.drawable.ic_mastercard_2019_logo, R.drawable.ic_mcdonald_s_logo, R.drawable.ic_microsoft_logo, R.drawable.ic_sap_logo, R.drawable.ic_square__inc__logo, R.drawable.ic_tesla_motors));
        itemPreis.addAll(Arrays.asList("100.00", "200.00", "50.00", "40.00", "30.00","20.00", "10.00", "13.31", "120.10", "1.33", "2442.29","233.29"));

        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        rvlayoutManager1 = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(rvlayoutManager1);

        rvadapter1 =new RvAdapterKlasse();
        recyclerView1.setAdapter(rvadapter1);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        MemoryStockRepository repo = new MemoryStockRepository();
        stockshelter = new StockService(repo);
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

    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(stockshelter.getList());
        editor.putString("stocks", json);
        editor.apply();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("stocks", null);
        Type type = new TypeToken<ArrayList<Item>>() {}.getType();
        stockshelter.setList(gson.fromJson(json, type));
        if(stockshelter.getList() == null){
            stockshelter.setList(new ArrayList<Item>());
        }
    }

}