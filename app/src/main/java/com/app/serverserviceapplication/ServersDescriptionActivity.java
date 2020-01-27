package com.app.serverserviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.app.serverserviceapplication.Adapters.ServerDescriptionAdapter;
import com.app.serverserviceapplication.Models.Server;

import java.util.List;

public class ServersDescriptionActivity extends AppCompatActivity {

    Bundle bundle;
    ListView listView;
    List<Server> servers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servers_description);

        bundle = getIntent().getBundleExtra("bundle");
        servers = (List<Server>) bundle.getSerializable("servers");

        ShowServers();

    }

    public void ShowServers(){
        listView = findViewById(R.id.listViewItems);
        ServerDescriptionAdapter serverDescriptionAdapter = new ServerDescriptionAdapter(this, servers);
        listView.setAdapter(serverDescriptionAdapter);
    }
}
