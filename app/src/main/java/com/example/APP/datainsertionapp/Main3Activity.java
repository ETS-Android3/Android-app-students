package com.example.rahul.datainsertionapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Main3Activity extends AppCompatActivity {
    String super_ip;
    TextView t1,t2,t3,t4;
    ImageView im1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t1=findViewById(R.id.textView4);
        t2=findViewById(R.id.textView5);
        t3=findViewById(R.id.textView6);
       t4=findViewById(R.id.textView8);
        im1=findViewById(R.id.imageView4);

        final String super_id=getIntent().getStringExtra("Super");
        final String user_id=getIntent().getStringExtra("user");
        String server_url="http://192.168.43.223/getsuper.php";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, server_url,(String) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    t1.setText(response.getString("Name"));
                    t2.setText(response.getString("Reg"));
                    t3.setText(response.getString("Inst"));
                    t4.setText(response.getString("Mob"));
                    super_ip=response.getString("Img_IP");

                }
                catch ( JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Main3Activity.this,"Error",Toast.LENGTH_SHORT).show();
            }
        }) {

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("super_id", super_id);
                return params;
            }
        };
        MySingleton.getInstance(Main3Activity.this).addToRequestQue(jsonObjectRequest);
        ImageRequest imageRequest = new ImageRequest(super_ip, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                im1.setImageBitmap(response);
            }

        }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Main3Activity.this, "Soomething went wrong", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });

        MySingleton.getInstance(Main3Activity.this).addToRequestQue(imageRequest);
    }
}
