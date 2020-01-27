package com.app.serverserviceapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.app.serverserviceapplication.Models.Item;
import com.app.serverserviceapplication.Models.Server;
import com.app.serverserviceapplication.R;

import java.util.List;

public class ItemsListAdapter extends ArrayAdapter<Item> {

    public ItemsListAdapter(@NonNull Context c, @NonNull List<Item> o) {
        super(c, 0, o);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Item item = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_items_model, parent, false);
        }

        TextView textViewWebURL = view.findViewById(R.id.textViewWebURL);
        textViewWebURL.setText(item.getWebURL());

        return view;
    }

}
