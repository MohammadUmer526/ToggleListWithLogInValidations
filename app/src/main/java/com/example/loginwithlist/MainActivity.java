package com.example.loginwithlist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView frg_Pass, link_Regst;
    private EditText edt_Email, edt_Pass;
    private Button btn_lgnIn;
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frg_Pass = (TextView) findViewById(R.id.edt_frgtPass);
        link_Regst = (TextView) findViewById(R.id.txt_LinkRgst);
        edt_Email = (EditText) findViewById(R.id.edt_Email);
        edt_Pass = (EditText) findViewById(R.id.edt_Pass);
        btn_lgnIn = (Button) findViewById(R.id.btnLogin);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);


        //validations for input credentials
        awesomeValidation.addValidation(this, R.id.edt_Email, Patterns.EMAIL_ADDRESS,
                R.string.emailerror);
        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)" +
                "\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        awesomeValidation.addValidation(this, R.id.edt_Pass, regexPassword,
                R.string.passworderror);

        btn_lgnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
    }
        private void submitForm(){
            if (awesomeValidation.validate()) {
                Toast.makeText(this, "Validation Successfull", Toast.LENGTH_LONG).show();

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
