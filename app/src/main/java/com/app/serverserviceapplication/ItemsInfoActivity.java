package com.app.serverserviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.app.serverserviceapplication.Adapters.ItemsListAdapter;
import com.app.serverserviceapplication.Models.Domain;
import com.app.serverserviceapplication.Models.Item;

import java.io.Serializable;
import java.util.List;

public class ItemsInfoActivity extends AppCompatActivity {

    Bundle bundle;
    ListView listView;

    List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_info);

        bundle = getIntent().getBundleExtra("bundle");
        items = (List<Item>) bundle.getSerializable("items");

        listView = findViewById(R.id.listViewItems);
        ItemsListAdapter itemsListAdapter = new ItemsListAdapter(this, items);
        listView.setAdapter(itemsListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShowDomain((int) id);
                System.out.println("id:"+id);
            }
        });
    }

    public void ShowDomain(int id){
        Intent intent = new Intent(this, DomainDescriptionActivity.class);
        Bundle bundleSend= new Bundle();
        bundleSend.putSerializable("domain", items.get(id).getSite());
        intent.putExtra("bundle", bundleSend);
        //System.out.println("item id:"+items.get(id).getSite().getTitle());
        startActivity(intent);
    }

}
