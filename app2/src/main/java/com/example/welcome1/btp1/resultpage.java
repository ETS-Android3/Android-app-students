package com.example.welcome1.btp1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultpage extends AppCompatActivity {

    public Button back;
    public TextView test1_result;
    public TextView test2_result;
    public TextView test3_result;
    public TextView test4_result;


    public SharedPreferences sharedpreferences ;
    public static final String MyPREFERENCES = "testresults_demo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultpage);


        test1_result = (TextView)findViewById(R.id.test1_resultview);
        test2_result = (TextView)findViewById(R.id.test2_resultview);
        test3_result = (TextView)findViewById(R.id.test3_resultview);
        test4_result = (TextView)findViewById(R.id.test4_resultview);

        sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();



        String val1 = sharedpreferences.getString("test1_correct",null);

        if(val1!=null){

            String total = sharedpreferences.getString("test1_total",null);

            String result = "Attempted : "+total+" | Correct : "+val1;

            test1_result.setText(result);
        }

        String val2 = sharedpreferences.getString("test2_correct",null);

        if(val2!=null){

            String total = sharedpreferences.getString("test2_total",null);

            String result = "Attempted : "+total+" | Correct : "+val2;

            test2_result.setText(result);
        }

        String val3 = sharedpreferences.getString("test3_total",null);

        if(val3!=null){

            String result = "Attempted : "+val3 +" | Results will be uploaded later.";

            test3_result.setText(result);
        }


        String val4 = sharedpreferences.getString("test4_total",null);

        if(val4!=null){

            String result = "Attempted : "+val4 +" | Results will be uploaded later.";

            test4_result.setText(result);
        }




        click_back_button();
    }


    public void click_back_button(){

        back = (Button)findViewById(R.id.back_button);

        back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        finish();

                    }
                }
        );
    }
}
