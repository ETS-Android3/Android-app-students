package com.example.rahul.datainsertionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Main4Activity extends AppCompatActivity {


    MyCanvas myCanvas;
    String server_url = "http://192.168.43.223/update.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myCanvas = new MyCanvas(this, null);

        setContentView(myCanvas);

        super.onCreate(savedInstanceState);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clear:
                myCanvas.clearCanvas();
                return true;
            case R.id.save:
                upload();
                myCanvas.clearCanvas();
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    public void upload() {
        StringRequest request = new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "IMG_1");
                params.put("image", myCanvas.save());
                return params;
            }
        };
        MySingleton.getInstance(Main4Activity.this).addToRequestQue(request);
    }
}
