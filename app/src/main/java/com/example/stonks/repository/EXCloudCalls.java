package com.example.stonks.repository;

import com.chaquo.python.PyException;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

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


    public double getOpen(String symbol) throws PyException, NullPointerException{
        PyObject open = pythonfile.callAttr("getOpen", symbol);
        return open.toDouble();
    }

    public double getLow(String symbol) throws PyException, NullPointerException{
        PyObject low = pythonfile.callAttr("getLow", symbol);
        return low.toDouble();
    }

    public double getVolume(String symbol) throws PyException, NullPointerException{
        PyObject volume = pythonfile.callAttr("getVolume", symbol);
        return volume.toDouble();
    }

    public double getHigh(String symbol) throws PyException, NullPointerException{
        PyObject high = pythonfile.callAttr("getHigh", symbol);
        return high.toDouble();
    }

    public double getPeRatio(String symbol) throws PyException, NullPointerException{
        PyObject peRatio = pythonfile.callAttr("getPeRatio", symbol);
        return peRatio.toDouble();
    }

    public double getMktCap(String symbol) throws PyException, NullPointerException{
        PyObject mktCap = pythonfile.callAttr("getMktCap", symbol);
        return mktCap.toDouble();
    }

    public double getHigh52(String symbol) throws PyException, NullPointerException{
        PyObject high52 = pythonfile.callAttr("getHigh52", symbol);
        return high52.toDouble();
    }

    public double getLow52(String symbol) throws PyException, NullPointerException{
        PyObject low52 = pythonfile.callAttr("getLow52", symbol);
        return low52.toDouble();
    }

    public double getAvgVol(String symbol) throws PyException, NullPointerException{
        PyObject avgVol = pythonfile.callAttr("getAvgVol", symbol);
        return avgVol.toDouble();
    }

    /*public double getEps(String symbol) throws PyException, NullPointerException{
        PyObject eps = //pythonfile.callAttr("getCompanyName", symbol);
        return eps.toDouble();
    } */



}
