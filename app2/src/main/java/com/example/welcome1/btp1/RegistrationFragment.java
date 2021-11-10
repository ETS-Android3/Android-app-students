package com.example.welcome1.btp1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationFragment extends Fragment{
    private EditText User,UserPassword;
    private Button MeRegister;

    public RegistrationFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_registration,container,false);
       User= view.findViewById(R.id.username);
       UserPassword=view.findViewById(R.id.pass);
       MeRegister=view.findViewById(R.id.create_button);

       MeRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                performRegistration();
           }
       });
        return view;
    }

    public void performRegistration()
    {
        String username= User.getText().toString();
        String password=UserPassword.getText().toString();
        Call<User> call=MainActivity.apiInterface.performRegistration(username,password);
        call.enqueue(new Callback<com.example.welcome1.btp1.User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                 if(response.body().getResponse().equals("ok"))
                 {
                     MainActivity.pref_config.displayToast("Registration success");
                 }
                 else if(response.body().getResponse().equals("exist"))
                 {
                     MainActivity.pref_config.displayToast("Account Already Exists");
                 }
                 else if(response.body().getResponse().equals("error"))
                 {
                     MainActivity.pref_config.displayToast("Something went wrong");
                 }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        UserPassword.setText("");
        User.setText("");

    }
}


