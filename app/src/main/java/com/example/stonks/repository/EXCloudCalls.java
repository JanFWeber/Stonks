package com.example.stonks.repository;

import com.chaquo.python.PyException;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

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

    public double getPrice(String symbol) throws PyException, NullPointerException {
        PyObject price = pythonfile.callAttr("getPrice", symbol);
        return price.toDouble();
    }

    public String getLogoLink(String symbol) throws PyException, NullPointerException {
        PyObject logolink = pythonfile.callAttr("getLogoLink", symbol);
        return logolink.toString();
    }

    public double getChangePercent(String symbol) throws PyException, NullPointerException{
        PyObject changePercent = pythonfile.callAttr("getChangePercent", symbol);
        return changePercent.toDouble();
    }

    public String getChartData(String symbol) throws PyException, NullPointerException {
        PyObject chartData = pythonfile.callAttr("getChartData", symbol);
        return String.valueOf(chartData.asList());
    }

    public String getCompanyName(String symbol) throws PyException, NullPointerException {
        PyObject companyName = pythonfile.callAttr("getCompanyName", symbol);
        return companyName.toString();
    }
}
