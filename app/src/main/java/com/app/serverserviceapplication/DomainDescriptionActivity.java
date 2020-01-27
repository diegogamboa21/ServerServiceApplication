package com.app.serverserviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.serverserviceapplication.Models.Domain;
import com.squareup.picasso.Picasso;

public class DomainDescriptionActivity extends AppCompatActivity {

    Bundle bundle;

    ImageView imageViewLogo;
    TextView textViewTitle;
    TextView textViewServersChanged;
    TextView textViewSslGrade;
    TextView textViewPrevius;
    TextView textViewIsDown;

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

        bundle = getIntent().getBundleExtra("bundle");
        Domain domain = (Domain) bundle.getSerializable("domain");

        if (domain.isServersChanged()){
            textViewServersChanged.setText("True");
        }else {
            textViewServersChanged.setText("False");
        }

        if (!domain.getLogo().isEmpty()) {
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

    }
}
