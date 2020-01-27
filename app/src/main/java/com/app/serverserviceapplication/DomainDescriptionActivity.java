package com.app.serverserviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.serverserviceapplication.Models.Domain;
import com.app.serverserviceapplication.Models.Server;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class DomainDescriptionActivity extends AppCompatActivity {

    Bundle bundle;

    ImageView imageViewLogo;
    TextView textViewTitle;
    TextView textViewServersChanged;
    TextView textViewSslGrade;
    TextView textViewPrevius;
    TextView textViewIsDown;
    Button buttonShowServers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domain_description);

        imageViewLogo = findViewById(R.id.imageViewLogo);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewServersChanged = findViewById(R.id.textViewServersChanged);
        textViewSslGrade = findViewById(R.id.textViewSslGrade);
        textViewPrevius = findViewById(R.id.textViewPrevius);
        textViewIsDown = findViewById(R.id.textViewIsDown);
        buttonShowServers = findViewById(R.id.buttonShowServers);

        bundle = getIntent().getBundleExtra("bundle");
        Domain domain = (Domain) bundle.getSerializable("domain");

        if (domain.isServersChanged() && domain.isServersChanged()){
            textViewServersChanged.setText("True");
        }else {
            textViewServersChanged.setText("False");
        }

        if (!domain.getLogo().isEmpty() && domain.getLogo() != null) {
            Picasso.with(this).load(domain.getLogo()).into(imageViewLogo);
        }
        textViewTitle.setText(domain.getTitle());
        textViewSslGrade.setText(domain.getSSLGrade());
        textViewPrevius.setText(domain.getPreviusSSLGrade());

        if (domain.isDown()){
            textViewIsDown.setText("True");
        }else {
            textViewIsDown.setText("False");
        }

        if(domain.getServers().size() == 0){
            buttonShowServers.setEnabled(false);
        }
        else {

            Intent intent = new Intent(getApplicationContext(), ServersDescriptionActivity.class);
            Bundle bundle= new Bundle();
            bundle.putSerializable("servers", (Serializable) domain.getServers());
            intent.putExtra("bundle", bundle);
            startActivity(intent);
        }

    }
}
