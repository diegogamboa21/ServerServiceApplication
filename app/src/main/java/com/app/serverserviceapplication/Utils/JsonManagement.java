package com.app.serverserviceapplication.Utils;

import com.app.serverserviceapplication.Models.Domain;
import com.app.serverserviceapplication.Models.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonManagement {

    public static Domain parseDomainJson (JSONObject response){
        Domain domain = new Domain();

        try{
            List<Server> servers = new ArrayList<>();
            JSONArray jsonArray = response.getJSONArray("endpoints");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Server server = new Server();

                server.setAddress(jsonObject.getString("ipAddress"));
                server.setSSLGrade(jsonObject.getString("grade"));
                server.setCountry(jsonObject.getString("countryCode"));
                server.setOwner(jsonObject.getString("isp"));

                servers.add(server);
            }


            domain.setServersChanged(response.getBoolean("ServersChanged"));
            domain.setSSLGrade(response.getString("SSLGrade"));
            domain.setPreviusSSLGrade(response.getString("PreviusSSLGrade"));
            domain.setLogo(response.getString("Logo"));
            domain.setTitle(response.getString("Title"));
            domain.setDown(response.getBoolean("IsDown"));

            domain.setServers(servers);

        }
        catch (JSONException e){
            e.printStackTrace();
        }


        return domain;
    }

}
