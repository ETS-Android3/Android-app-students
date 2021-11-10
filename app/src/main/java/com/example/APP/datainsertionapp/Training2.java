package com.example.rahul.datainsertionapp;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Training2 extends AppCompatActivity {

    GridLayout mainGrid;
    private ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,iv10,iv11,iv12,iv13,iv14,iv15,iv16,iv17,iv18,iv19,iv20,iv21,iv22,iv23,iv24,iv25,iv26;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training2);

        mainGrid = findViewById(R.id.MainGrid);
        iv1=findViewById(R.id.iv1);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/a.png");
        iv1.setImageBitmap(bitmap);
        iv2=findViewById(R.id.iv2);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/b.png");
        iv2.setImageBitmap(bitmap);
        iv3=findViewById(R.id.iv3);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/c.png");
        iv3.setImageBitmap(bitmap);
        iv4=findViewById(R.id.iv4);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/d.png");
        iv4.setImageBitmap(bitmap);
        iv5=findViewById(R.id.iv5);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/e.png");
        iv5.setImageBitmap(bitmap);
        iv6=findViewById(R.id.iv6);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/f.png");
        iv6.setImageBitmap(bitmap);
        iv7=findViewById(R.id.iv7);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/g.png");
        iv7.setImageBitmap(bitmap);
        iv8=findViewById(R.id.iv8);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/h.png");
        iv8.setImageBitmap(bitmap);
        iv9=findViewById(R.id.iv9);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/i.png");
        iv9.setImageBitmap(bitmap);
        iv10=findViewById(R.id.iv10);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/j.png");
        iv10.setImageBitmap(bitmap);
        iv11=findViewById(R.id.iv11);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/k.png");
        iv11.setImageBitmap(bitmap);
        iv12=findViewById(R.id.iv12);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/l.png");
        iv12.setImageBitmap(bitmap);
        iv13=findViewById(R.id.iv13);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/m.png");
        iv13.setImageBitmap(bitmap);
        iv14=findViewById(R.id.iv14);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/n.png");
        iv14.setImageBitmap(bitmap);
        iv15=findViewById(R.id.iv15);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/o.png");
        iv15.setImageBitmap(bitmap);
        iv16=findViewById(R.id.iv16);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/p.png");
        iv16.setImageBitmap(bitmap);
        iv17=findViewById(R.id.iv17);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/q.png");
        iv17.setImageBitmap(bitmap);
        iv18=findViewById(R.id.iv18);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/r.png");
        iv18.setImageBitmap(bitmap);
        iv19=findViewById(R.id.iv19);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/s.png");
        iv19.setImageBitmap(bitmap);
        iv20=findViewById(R.id.iv20);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/t.png");
        iv20.setImageBitmap(bitmap);
        iv21=findViewById(R.id.iv21);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/u.png");
        iv21.setImageBitmap(bitmap);
        iv22=findViewById(R.id.iv22);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/v.png");
        iv22.setImageBitmap(bitmap);
        iv23=findViewById(R.id.iv23);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/w.png");
        iv23.setImageBitmap(bitmap);
        iv24=findViewById(R.id.iv24);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/x.png");
        iv24.setImageBitmap(bitmap);
        iv25=findViewById(R.id.iv25);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/y.png");
        iv25.setImageBitmap(bitmap);
        iv26=findViewById(R.id.iv26);
        bitmap=getBitmapFromURL("http://192.168.43.223/big/z.png");
        iv26.setImageBitmap(bitmap);
        setSingleEvent(mainGrid);
    }
    public Bitmap getBitmapFromURL(String src)
    {
        try
        {
            URL url=new URL(src);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input =connection.getInputStream();
            Bitmap myBitmap= BitmapFactory.decodeStream(input);
            return myBitmap;

        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
    }

   private void setSingleEvent(GridLayout MainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);

            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finalI == 0) {
                        Intent intent = new Intent(Training2.this, Alphaa.class);
                        startActivity(intent);
                    }
                    if (finalI == 1) {
                        Intent intent = new Intent(Training2.this, Alphab.class);
                        startActivity(intent);
                    }
                    if (finalI == 2) {
                        Intent intent = new Intent(Training2.this, Alphac.class);
                        startActivity(intent);
                    }
                    if (finalI == 3) {
                        Intent intent = new Intent(Training2.this, Alphad.class);
                        startActivity(intent);
                    }
                    if (finalI == 4) {
                        Intent intent = new Intent(Training2.this, Alphae.class);
                        startActivity(intent);
                    }
                    if (finalI == 5) {
                        Intent intent = new Intent(Training2.this, Alphaf.class);
                        startActivity(intent);
                    }
                    if (finalI == 6) {
                        Intent intent = new Intent(Training2.this, Alphag.class);
                        startActivity(intent);
                    }
                    if (finalI == 7) {
                        Intent intent = new Intent(Training2.this, Alphah.class);
                        startActivity(intent);
                    }
                    if (finalI == 8) {
                        Intent intent = new Intent(Training2.this, Alphai.class);
                        startActivity(intent);
                    }
                    if (finalI == 9) {
                        Intent intent = new Intent(Training2.this, Alphaj.class);
                        startActivity(intent);
                    }
                    if (finalI == 10) {
                        Intent intent = new Intent(Training2.this, Alphak.class);
                        startActivity(intent);
                    }
                    if (finalI == 11) {
                        Intent intent = new Intent(Training2.this, Alphal.class);
                        startActivity(intent);
                    }
                    if (finalI == 12) {
                        Intent intent = new Intent(Training2.this, Alpham.class);
                        startActivity(intent);
                    }
                    if (finalI == 13) {
                        Intent intent = new Intent(Training2.this, Alphan.class);
                        startActivity(intent);
                    }
                    if (finalI == 14) {
                        Intent intent = new Intent(Training2.this, Alphao.class);
                        startActivity(intent);
                    }
                    if (finalI == 15) {
                        Intent intent = new Intent(Training2.this, Alphap.class);
                        startActivity(intent);
                    }
                    if (finalI == 16) {
                        Intent intent = new Intent(Training2.this, Alphaq.class);
                        startActivity(intent);
                    }
                    if (finalI == 17) {
                        Intent intent = new Intent(Training2.this, Alphar.class);
                        startActivity(intent);
                    }
                    if (finalI == 18) {
                        Intent intent = new Intent(Training2.this, Alphas.class);
                        startActivity(intent);
                    }
                    if (finalI == 19) {
                        Intent intent = new Intent(Training2.this, Alphat.class);
                        startActivity(intent);
                    }
                    if (finalI == 20) {
                        Intent intent = new Intent(Training2.this, Alphau.class);
                        startActivity(intent);
                    }
                    if (finalI == 21) {
                        Intent intent = new Intent(Training2.this, Alphav.class);
                        startActivity(intent);
                    }
                    if (finalI == 22) {
                        Intent intent = new Intent(Training2.this, Alphaw.class);
                        startActivity(intent);
                    }
                    if (finalI == 23) {
                        Intent intent = new Intent(Training2.this, Alphax.class);
                        startActivity(intent);
                    }
                    if (finalI == 24) {
                        Intent intent = new Intent(Training2.this, Alphay.class);
                        startActivity(intent);
                    }
                    if (finalI == 25) {
                        Intent intent = new Intent(Training2.this, Alphaz.class);
                        startActivity(intent);
                    }


                }
            });

        }


    }
}





