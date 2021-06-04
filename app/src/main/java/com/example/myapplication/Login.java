package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class Login extends AppCompatActivity {
    Button login;
    EditText email,password;
    TextView creat_acount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login_btn);
        email = findViewById(R.id.email_login);
        password = findViewById(R.id.password_login);
        creat_acount = findViewById(R.id.creat_acount);

        creat_acount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Registration.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    FileInputStream br = openFileInput("user.txt");
                    int c;
                    String s="";

                    while((c= br.read())!=-1){

                        if ((char)c!='\n') {
                            s = s + (char) c;
                        }else
                        {


                        String[] e = s.split(",");

                        if (e[0].equals(email.getText().toString())&& e[1].equals(password.getText().toString())){
                            startActivity(new Intent(Login.this,ForistFire.class));
                            return;
                        }
                        s="";
                    }
                    }
                    Toast.makeText(Login.this, "your email and password is wrong", Toast.LENGTH_LONG).show();

                } catch (Exception e) {

                }

            }
        });
    }
}