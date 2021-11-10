package com.example.welcome1.btp1;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends Fragment {
    private TextView RegText;
    private EditText UserName, UserPassword;
    private Button Loginbtn;
    OnLoginFormActivityListener loginFormActivityListener;
    public interface OnLoginFormActivityListener
    {
        public void performRegister();
        public void performLogin(String name);
    }
    public LoginFragment(){

    }
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
     {
            View view=inflater.inflate(R.layout.fragment_login,container,false);
            RegText=(TextView) view.findViewById(R.id.create_account);
            UserName=view.findViewById(R.id.username_field);
            UserPassword=view.findViewById(R.id.password_field);
            Loginbtn=view.findViewById(R.id.login);
            Loginbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    performLogin();
                }
            });

            UserPassword=view.findViewById(R.id.password_field);
            RegText.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            loginFormActivityListener.performRegister();
                        }
                    }
            );
            return view;

     }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity=(Activity)context;
        loginFormActivityListener=(OnLoginFormActivityListener)activity;
    }

    private void performLogin()
    {
        String username=UserName.getText().toString();
        String password=UserPassword.getText().toString();

        Call<User> call=MainActivity.apiInterface.performUserLogin(username,password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body().getResponse().equals("ok")) {
                    MainActivity.pref_config.writeLoginStatus(true);
                    loginFormActivityListener.performLogin(response.body().getName());
                } else if (response.body().getResponse().equals("failed"))
                {
                    MainActivity.pref_config.displayToast("Login failed...");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        UserName.setText("");
        UserPassword.setText("");

    }
}
