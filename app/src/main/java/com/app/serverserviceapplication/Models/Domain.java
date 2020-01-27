package com.app.serverserviceapplication.Models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Domain {

    List<Server> Servers;
    private boolean ServersChanged;
    private String  SSLGrade;
    private String  PreviusSSLGrade;
    private String  Logo;
    private String  Title;
    private boolean IsDown;

    public Domain(){

    }

    public Domain(ArrayList<Server> servers, boolean serversChanged, String SSLGrade, String previusSSLGrade, String logo, String title, boolean isDown) {
        Servers = servers;
        ServersChanged = serversChanged;
        this.SSLGrade = SSLGrade;
        PreviusSSLGrade = previusSSLGrade;
        Logo = logo;
        Title = title;
        IsDown = isDown;
    }

    public List<Server> getServers() {
        return Servers;
    }

    public void setServers(List<Server> servers) {
        Servers = servers;
    }

    public boolean isServersChanged() {
        return ServersChanged;
    }

    public void setServersChanged(boolean serversChanged) {
        ServersChanged = serversChanged;
    }

    public String getSSLGrade() {
        return SSLGrade;
    }

    public void setSSLGrade(String SSLGrade) {
        this.SSLGrade = SSLGrade;
    }

    public String getPreviusSSLGrade() {
        return PreviusSSLGrade;
    }

    public void setPreviusSSLGrade(String previusSSLGrade) {
        PreviusSSLGrade = previusSSLGrade;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public boolean isDown() {
        return IsDown;
    }

    public void setDown(boolean down) {
        IsDown = down;
    }

}
