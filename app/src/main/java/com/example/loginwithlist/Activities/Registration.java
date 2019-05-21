package com.example.loginwithlist.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginwithlist.R;

public class Registration extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //initialize the views
        final  EditText edt_FirstName = (EditText) findViewById(R.id.f_name);
        final  EditText edt_LastName = (EditText) findViewById(R.id.l_name);
        final  EditText edt_Email = (EditText) findViewById(R.id.email);
        final  EditText edt_Phone = (EditText) findViewById(R.id.phone);
        final  EditText edt_Password = (EditText) findViewById(R.id.password);
        Button btn_Rgst = (Button) findViewById(R.id.btn_register);

        // validations for input credentials
        btn_Rgst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String f_name= edt_FirstName.getText().toString().trim();
                String l_name = edt_LastName.getText().toString().trim();
                String email = edt_Email.getText().toString().trim();
                String phone = edt_Phone.getText().toString().trim();
                String password = edt_Password.getText().toString().trim();

                String namePttern = "[A-Z][a-z]*";
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String passPattern ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

                if(f_name.matches(namePttern)){
                    Toast.makeText(getApplicationContext(), "Valid First Name",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(), "Invalid First Name",Toast.LENGTH_SHORT).show();
                }if(l_name.matches(namePttern)){
                    Toast.makeText(getApplicationContext(), "Valid Last Name",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Invalid Last Name",Toast.LENGTH_SHORT).show();

                }if(email.matches(emailPattern)){
                    Toast.makeText(getApplicationContext(), "Valid Email",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid Email",Toast.LENGTH_SHORT).show();
                }
                if(phone.matches(String.valueOf(Patterns.PHONE))){
                    Toast.makeText(getApplicationContext(), "Valid Phone",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid Phone",Toast.LENGTH_SHORT).show();
                }if(password.matches(passPattern)){
                    Toast.makeText(getApplicationContext(), "Valid Password",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid Password",Toast.LENGTH_SHORT).show();
                }if(f_name.matches(namePttern) && l_name.matches(namePttern) && email.matches(emailPattern)
                    && password.matches(passPattern)){
                    Intent rdt_Trans = new Intent(Registration.this, Transaction.class);
                    startActivity(rdt_Trans);
                }

            }
        });
    }
}
