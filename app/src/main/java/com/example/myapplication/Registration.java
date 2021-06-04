package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Registration extends AppCompatActivity {
    Button register;
    EditText email,password;
    String path_pw = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,10}";
    String path_email = "^(.+)@(.+)";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        register = findViewById(R.id.register_btn);
        email = findViewById(R.id.email_register);
        password = findViewById(R.id.password_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s2 = String.valueOf(password.getText());

                String s3 = String.valueOf(email.getText());
                boolean v_password = s2.matches(path_pw);
                boolean v_email= s3.matches(path_email);
                if (v_password){
                    if (v_email){
                        try {
String userInfo = email.getText().toString()+","+password.getText().toString()+"\n";
                            FileOutputStream bw = openFileOutput("user.txt",MODE_PRIVATE);
                            bw.write(userInfo.getBytes());
                            bw.close();
                            Toast.makeText(Registration.this, "your account created successfully ", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Registration.this,Login.class);
                            startActivity(intent);
                        }catch (IOException e){
                            System.out.println(e.getMessage());
                        }


                    }else{
                        email.setError("email is wrong");
                    }
                }else{
                    password.setError("password is wrong");
                }
            }
        });


    }
}