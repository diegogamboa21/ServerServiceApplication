package com.app.serverserviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.utils.Utils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.serverserviceapplication.Models.Domain;
import com.app.serverserviceapplication.Utils.JsonManagement;

import org.json.JSONObject;

public class HomepageActivity extends AppCompatActivity implements
        DomainDescriptionFragment.OnFragmentInteractionListener,
        DomainHistoryFragment.OnFragmentInteractionListener {

    DomainDescriptionFragment domainDescriptionFragment;
    DomainHistoryFragment domainHistoryFragment;

    Button buttonFindDomain;
    Button buttonShowHistory;
    EditText editTextFindDomain;

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        domainDescriptionFragment = new DomainDescriptionFragment();
        domainHistoryFragment = new DomainHistoryFragment();

        editTextFindDomain = (EditText) findViewById(R.id.editTextFindDomain);
        buttonFindDomain = (Button) findViewById(R.id.buttonFindDomain);
        buttonShowHistory = (Button) findViewById(R.id.buttonShowHistory);

        requestQueue = Volley.newRequestQueue(this);

        //Clic on show domain
        buttonFindDomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Evaluate edit text
                String domain = editTextFindDomain.getText().toString();
                if (domain.isEmpty()) {
                    Toast.makeText(HomepageActivity.this, "Debe ingresar un dominio", Toast.LENGTH_SHORT).show();
                } else {
                    GetDomainInfo(domain);

                    //Show the fragment domain description
                    getSupportFragmentManager().beginTransaction().add(R.id.domainDescriptionFragment, domainDescriptionFragment).commit();
                }
            }
        });

    }

    private void GetDomainInfo(String domain) {

        String url = "http://54.67.44.78:9000/"+ domain;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Domain domain = JsonManagement.parseDomainJson(response);
                //Call the fragment

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }

        );

        requestQueue.add(jsonObjectRequest);

    }

        @Override
        public void onFragmentInteraction(Uri uri) {

        }
    }
