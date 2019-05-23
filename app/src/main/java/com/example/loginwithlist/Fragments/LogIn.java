package com.example.loginwithlist.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginwithlist.Activities.MainActivity;
import com.example.loginwithlist.Activities.Registration;
import com.example.loginwithlist.Activities.Transaction;
import com.example.loginwithlist.R;

import java.util.Objects;

public class LogIn extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lgn, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //initialize the views
        TextView frg_Pass = (TextView) view.findViewById(R.id.edt_frgtPass);
        TextView link_Regst = (TextView)  view.findViewById(R.id.txt_LinkRgst);
        final EditText edt_Email = (EditText)  view.findViewById(R.id.edt_Email);
        final EditText edt_Pass = (EditText) view.findViewById(R.id.edt_Pass);
        Button btn_lgnIn = (Button)  view.findViewById(R.id.btnLogin);


        //validations for input credentials

        btn_lgnIn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                String email = edt_Email.getText().toString().trim();
                String password = edt_Pass.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String passPattern ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\" +
                                    "d@$!%*?&]{8,}$";
                if (email.matches(emailPattern)) {
                    Toast.makeText(getActivity(), "Valid email address",
                            Toast.LENGTH_SHORT).show();
                }else
                {
                    edt_Email.setError("Invalid E-mail");
                }
                if(password.matches(passPattern)){
                    Toast.makeText(Objects.requireNonNull(getActivity()).getApplicationContext(),
                            "Valid Password", Toast.LENGTH_SHORT).show();
                } else {
                    edt_Pass.setError("Password is invalid");
                }
                if (email.matches(emailPattern) && password.matches(passPattern)){

                    Intent ab = new Intent(getContext(), Transaction.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("FRAG" , "trans");
                    bundle.putString("EMAIL" , edt_Email.getText().toString());
                    bundle.putString("PASS" , edt_Pass.getText().toString());
                    ab.putExtras(bundle);
                    startActivity(ab);

                }
            }
        });

        //open web link
        frg_Pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.google.com/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        //intent to registration acitivity
        link_Regst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lin_Rgst = new Intent(getActivity(), Registration.class);
                startActivity(lin_Rgst);
            }
        });
    }

    }



