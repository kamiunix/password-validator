package com.example.acme.csci3130_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.k.password_validator.R;

public class LoginActivity extends AppCompatActivity {

    Button but;
    EditText etxt;
    TextView vtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        but = (Button) findViewById(R.id.validateButton);
        etxt = (EditText) findViewById(R.id.password);
        vtxt = (TextView) findViewById(R.id.textView);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = etxt.getText().toString();
                String msg = "";
                msg = notPassword(pass);
                msg = longEnough(pass);
                msg = hasLowerUpper(pass);
                msg = hasNum(pass);
                msg = specialChar(pass);
                if (msg == "") {
                    msg = "Validated!";
                }
                vtxt.setText(msg);
            }
        });
    }

    private String notPassword(String pass) {
        if (pass.equals("password")) {
            String tmp = "Password can not be 'password'\n";
            return tmp;
        }
        return "";
    }
    private String longEnough(String pass) {
        if (pass.length() < 8) {
            String tmp = "Password must be at least 8 characters\n";
            return tmp;
        }
        return "";
    }

    //3 extra tests
    public String hasLowerUpper(String pass){
        if(pass.equals(pass.toLowerCase()) || pass.equals(pass.toUpperCase())){
            String tmp = "password must have an uppercase and lowercase character\n";
            return tmp;
        }
        return "";
    }
    public String hasNum(String inputPassword){
        if(!inputPassword.matches(".*\\d.*")){
            String tmp = ("password must have at least one number\n");
            return tmp;
        }
        return "";
    }
    public String specialChar(String testpass){
        if(!testpass.matches(".*[~!@#$%^&*()_+].*")){
            String tmp = "password must have at least one special characters \n(~, !, @, #, $, %, ^, &, *, (, ), _, +)\n";
            return tmp;
        }
        return "";
    }
}