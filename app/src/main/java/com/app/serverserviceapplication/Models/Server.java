package com.app.serverserviceapplication.Models;

import java.io.Serializable;

public class Server implements Serializable {

    private String Address;
    private String SSLGrade;
    private String Country;
    private String Owner;

    public Server(){

    }

    public Server(String address, String SSLGrade, String country, String owner) {
        Address = address;
        this.SSLGrade = SSLGrade;
        Country = country;
        Owner = owner;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSSLGrade() {
        return SSLGrade;
    }

    public void setSSLGrade(String SSLGrade) {
        this.SSLGrade = SSLGrade;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }
}
