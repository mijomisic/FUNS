package com.example.funs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup, signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.signup);
        signin = (Button) findViewById(R.id.signin);
        DB = new DBHelper(this);

        signup.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String repass = repassword.getText().toString();

            if(user.equals("") || pass.equals("") || repass.equals("")){
                Toast.makeText(MainActivity.this, "Unesite sva polja", Toast.LENGTH_SHORT).show();
            }else{
                if(pass.equals(repass)){
                    Boolean checkuser = DB.checkUsername(user);
                    if (!checkuser){
                        Boolean insertdata = DB.insterData(user, pass);
                        if(insertdata){
                            Toast.makeText(MainActivity.this, "Korisnički račun stvoren", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), ReviewsActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this, "Račun se nije mogao stvoriti", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Korisnik s tim računom već postoji", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Lozinke se ne podudaraju", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signin.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });
    }
}