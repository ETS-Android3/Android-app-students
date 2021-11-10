package com.example.rahul.datainsertionapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    private ImageView imageView;
    String user;
    String server_url = "http://192.168.43.223/getdata.php";
    TextView t1,t2,t3;
    String image_ip,super_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        imageView = findViewById(R.id.imageView2);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);


        final String username = getIntent().getStringExtra("Login");
        user=username;

       /* StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                final String image_url=res
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                return params;
            }
        };
        MySingleton.getInstance(Login.this).addToRequestQue(stringRequest);*/
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, server_url,(String) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    t1.setText(response.getString("Name"));
                    t2.setText(response.getString("Class"));
                    t3.setText(response.getString("Supervisor"));
                    image_ip=response.getString("Image");
                    super_id=response.getString("SuperID");
                }
                catch ( JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this,"Error",Toast.LENGTH_SHORT).show();
            }
        }) {

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                return params;
            }
        };
        MySingleton.getInstance(Login.this).addToRequestQue(jsonObjectRequest);
        ImageRequest imageRequest = new ImageRequest(image_ip, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }

        }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, "Soomething went wrong", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });

        MySingleton.getInstance(Login.this).addToRequestQue(imageRequest);
    }

    public void Super(View view) {

        Intent intent=new Intent(Login.this,Main3Activity.class);
        intent.putExtra("Super",super_id);
        intent.putExtra("User",user);
        startActivity(intent);
    }

    public void alphabet(View view) {
        Intent intent=new Intent(Login.this,Main2Activity.class);
        startActivity(intent);
    }

    public void letter(View view) {
        Intent intent=new Intent(Login.this,Training2.class);
        startActivity(intent);
    }

    public void canvas(View view) {
        Intent intent=new Intent(Login.this,Main4Activity.class);
        startActivity(intent);
    }
}
