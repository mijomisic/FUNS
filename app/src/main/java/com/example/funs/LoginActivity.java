package com.example.funs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        signin = findViewById(R.id.signin);

        signin.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            DB = new DBHelper(this);
            if(user.equals("") || pass.equals("")){
                Toast.makeText(LoginActivity.this, "Unesite sva polja", Toast.LENGTH_SHORT).show();
            }else{
                Boolean loginsuccess = DB.checkLogin(user, pass);
                if(loginsuccess){
                    Intent intent = new Intent(LoginActivity.this, ReviewsActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Pogrešan korisnički račun ili lozinka", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}