package com.example.welcome1.btp1;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class WelcomeFragment extends Fragment {

    private TextView textView;
    private Button BnLogOut;
    OnLogoutListener onLogoutListener;
    public interface OnLogoutListener{

        public void logoutPerformed();
    }

    public WelcomeFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_welcome,container,false);
        textView=view.findViewById(R.id.textView41);
        textView.setText("Welcome"+MainActivity.pref_config.readName());
        BnLogOut=view.findViewById(R.id.button24);
        BnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogoutListener.logoutPerformed();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity=(Activity)context;
        onLogoutListener=(OnLogoutListener)activity;
    }
}
