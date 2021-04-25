package com.example.objection;

public class Proxy {

    public  void set(String proxyHost,String proxyPort){
        System.setProperty("http.proxyHost", proxyHost);
        System.setProperty("http.proxyPort", proxyPort);

        System.setProperty("https.proxyHost", proxyHost);
        System.setProperty("https.proxyPort", proxyPort);
    }
}
