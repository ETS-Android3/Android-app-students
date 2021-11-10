package com.example.rahul.datainsertionapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText t1,t2;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button2);
        t1=findViewById(R.id.editText);
        t2=findViewById(R.id.editText2);



    }

    public void login(View view) {

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String username, password,ip;
                username = t1.getText().toString();
                password = t2.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://192.168.43.223/update_info.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        builder.setTitle("Server Response");
                        builder.setMessage(response);
                        if(response.equals("Success"))
                        {
                            Intent intent=new Intent(MainActivity.this,Login.class);
                            intent.putExtra("Login",username);

                            startActivity(intent);
                        }
                        else
                        {
                            builder.setTitle("Error");
                            builder.setMessage("Incorrect credentials");

                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                       /* builder.setTitle("Failure");
                        builder.setMessage("Could not connect to server");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                t1.setText("");
                                t2.setText("");
                            }
                        });*/
                        builder.setTitle("No Response");
                        builder.setMessage("Incorrect credentials");
                        Toast.makeText(getApplicationContext(),"Could not Connect ",Toast.LENGTH_LONG).show();

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("username", username);
                        params.put("password", password);
                        return params;
                    }
                };
                MySingleton.getInstance(MainActivity.this).addToRequestQue(stringRequest);
            }

        });
    }
}
