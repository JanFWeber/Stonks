package com.example.stonks.repository;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EXCloudCalls {

    //Singleton Pattern, dass Python nur einmal ausgeführt wird
    private static EXCloudCalls instance;
    private PyObject pythonfile;

    public static EXCloudCalls getInstance() {
        if(instance == null) {
            instance = new EXCloudCalls();
        }
        return instance;
    }

    private EXCloudCalls() {
        Python python = Python.getInstance();
        pythonfile = python.getModule("script");
        /*String stockName = pythonfile.callAttr("getSymbol", symbol).toString();
        int price = pythonfile.callAttr("getPrice", symbol).toInt();
        String advancedStats = pythonfile.callAttr("getAdvancedStats", symbol).toString();
        String quote = pythonfile.callAttr("getQuote", symbol).toString(); */
    }

    public double getPrice(String symbol) {
        return pythonfile.callAttr("getPrice", symbol).toDouble();
    }

    //public String getImageLink(String symbol) {

    //}



}
