package com.example.stonks.repository;

import com.example.stonks.models.Item;
import java.util.ArrayList;

public interface IRepository {

    void addItem(Item x);

    void removeItem(Item x);

    void updateList();

    void saveList();

    ArrayList<Item> getList();

    void setList(ArrayList<Item> x);

}
