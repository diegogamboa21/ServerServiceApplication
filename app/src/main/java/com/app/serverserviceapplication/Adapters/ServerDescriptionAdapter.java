package com.app.serverserviceapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.app.serverserviceapplication.Models.Server;
import com.app.serverserviceapplication.R;

import java.util.List;

public class ServerDescriptionAdapter extends ArrayAdapter<Server> {

    public ServerDescriptionAdapter(@NonNull Context c, @NonNull List<Server> o) {
        super(c, 0, o);
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Server server = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.server_info_model, parent, false);
        }

        TextView textViewAddress = view.findViewById(R.id.textViewAddressBlack);
        textViewAddress.setText(server.getAddress());

        TextView textViewGrade = view.findViewById(R.id.textViewSslGradeBlack);
        textViewGrade.setText(server.getSSLGrade());

        TextView textViewCountry = view.findViewById(R.id.textViewCountryBlack);
        textViewCountry.setText(server.getCountry());

        TextView textViewOwner = view.findViewById(R.id.textViewIOwnerBlack);
        textViewOwner.setText(server.getOwner());

        return view;
    }
}
