package com.app.serverserviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.app.serverserviceapplication.Models.Domain;
import com.app.serverserviceapplication.Utils.JsonManagement;

import org.json.JSONObject;

public class HomepageActivity extends AppCompatActivity {

    Button buttonFindDomain;
    Button buttonShowHistory;
    EditText editTextFindDomain;

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        editTextFindDomain = (EditText) findViewById(R.id.editTextFindDomain);
        buttonFindDomain = (Button) findViewById(R.id.buttonFindDomain);
        buttonShowHistory = (Button) findViewById(R.id.buttonShowServers);

        requestQueue = Volley.newRequestQueue(this);

        //Clic on show domain
        buttonFindDomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Evaluate edit text
                String page = editTextFindDomain.getText().toString();
                if (page.isEmpty()) {
                    Toast.makeText(HomepageActivity.this, "Debe ingresar un dominio", Toast.LENGTH_SHORT).show();
                } else {
                    GetDomainInfo(page.toLowerCase());
                }
            }
        });

        editTextFindDomain.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    String page = editTextFindDomain.getText().toString();
                    if (page.isEmpty()) {
                        Toast.makeText(HomepageActivity.this, "Debe ingresar un dominio", Toast.LENGTH_SHORT).show();
                    } else {
                        GetDomainInfo(page.toLowerCase());
                    }
                    return true;
                }
                return false;
            }
        });

    }

    private void GetDomainInfo(String page) {

        String url = "http://54.67.44.78:9000/" + page;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Domain domain = JsonManagement.parseDomainJson(response);

                Intent intent = new Intent(getApplicationContext(), DomainDescriptionActivity.class);
                Bundle bundle= new Bundle();
                bundle.putSerializable("domain",domain);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HomepageActivity.this, "Error al consultar la página", Toast.LENGTH_SHORT).show();
            }
        }

        );

        requestQueue.add(jsonObjectRequest);

    }

}
