package com.app.serverserviceapplication.Models;

import java.io.Serializable;

public class Item implements Serializable {

    private String webURL;
    private Domain site;

    public Item(){

    }

    public Item(String webURL, Domain site) {
        this.webURL = webURL;
        this.site = site;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public Domain getSite() {
        return site;
    }

    public void setSite(Domain site) {
        this.site = site;
    }
}
