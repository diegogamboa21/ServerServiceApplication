package com.app.serverserviceapplication.Utils;

import android.content.ClipData;

import com.app.serverserviceapplication.Models.Domain;
import com.app.serverserviceapplication.Models.Item;
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

                server.setAddress(jsonObject.getString("address"));
                server.setSSLGrade(jsonObject.getString("ssl_grade"));
                server.setCountry(jsonObject.getString("country"));
                server.setOwner(jsonObject.getString("owner"));

                servers.add(server);
            }


            domain.setServersChanged(response.getBoolean("servers_changed"));
            domain.setSSLGrade(response.getString("ssl_grade"));
            domain.setPreviusSSLGrade(response.getString("previous_ssl_grade"));
            domain.setLogo(response.getString("logo"));
            domain.setTitle(response.getString("title"));
            domain.setDown(response.getBoolean("is_down"));

            domain.setServers(servers);

        }
        catch (JSONException e){
            e.printStackTrace();
        }


        return domain;
    }

    public static List<Item> ParseItemsJson(JSONObject response){
        List<Item> items = new ArrayList<>();

        try{
            JSONArray jsonArray = response.getJSONArray("items");
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Item item = new Item();
                item.setWebURL(jsonObject.getString("WebURL"));
                Domain domain = parseDomainJson(jsonObject.getJSONObject("info"));
                item.setSite(domain);
                items.add(item);
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        return items;
    }

}
