package com.example.welcome1.btp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Training2 extends AppCompatActivity {

    GridLayout mainGrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training2);

        mainGrid = findViewById(R.id.MainGrid);
        setSingleEvent(mainGrid);
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




