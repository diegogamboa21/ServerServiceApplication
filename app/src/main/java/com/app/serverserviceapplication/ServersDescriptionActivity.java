package com.app.serverserviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.app.serverserviceapplication.Adapters.ServerDescriptionAdapter;
import com.app.serverserviceapplication.Models.Server;

import java.util.ArrayList;
import java.util.List;

import static com.app.serverserviceapplication.R.id.layoutServerInfoBlack;

public class ServersDescriptionActivity extends AppCompatActivity {

    Bundle bundle;

    TableLayout layoutServerInfoBlack;
    TableLayout layoutServerInfoWhite;
    LinearLayout linearLayoutServers;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servers_description);

        bundle = getIntent().getBundleExtra("bundle");
        List<Server> servers = (List<Server>) bundle.getSerializable("servers");

        servers.add(servers.get(0));
        servers.add(servers.get(0));
        servers.add(servers.get(0));
        servers.add(servers.get(0));
        servers.add(servers.get(0));

        listView = (ListView) findViewById(R.id.listViewServers);
        ServerDescriptionAdapter serverDescriptionAdapter = new ServerDescriptionAdapter(this, servers);
        listView.setAdapter(serverDescriptionAdapter);
    }
}
