package com.example.loginwithlist.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.example.loginwithlist.R;
import com.raywenderlich.android.validatetor.ValidateTor;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView frg_Pass, link_Regst;
    private Button btn_lgnIn;
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frg_Pass = (TextView) findViewById(R.id.edt_frgtPass);
        link_Regst = (TextView) findViewById(R.id.txt_LinkRgst);
        final EditText edt_Email = (EditText) findViewById(R.id.edt_Email);
        final EditText edt_Pass = (EditText) findViewById(R.id.edt_Pass);
        btn_lgnIn = (Button) findViewById(R.id.btnLogin);


        //validations for input credentials

        btn_lgnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edt_Email.getText().toString().trim();
                String password = edt_Pass.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String passPattern ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
                if (email.matches(emailPattern)) {
                    Toast.makeText(getApplicationContext(), "Valid email address",
                            Toast.LENGTH_SHORT).show();
                }else
                {
                    edt_Email.setError("Invalid E-mail");
                }
                if(password.matches(passPattern)){
                    Toast.makeText(getApplicationContext(),"Valid Password",
                            Toast.LENGTH_SHORT).show();
                } else {
                  edt_Pass.setError("Password is invalid");
                }
                if (email.matches(emailPattern) && password.matches(passPattern)){
                    Intent rdrt_Rgst = new Intent(MainActivity.this, Registration.class);
                    startActivity(rdrt_Rgst);
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
                Intent lin_Rgst = new Intent(MainActivity.this, Registration.class);
                startActivity(lin_Rgst);
            }
        });
    }

        private void submitForm(){
            if (awesomeValidation.validate()) {
                Toast.makeText(this, "Validation Successful", Toast.LENGTH_LONG).show();

                //process the data further
            }

        }


    @Override
    public void onClick(View view) {
        if (view == btn_lgnIn) {
            submitForm();
        }
    }

}
