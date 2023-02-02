package com.example.funs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ReviewsActivity extends AppCompatActivity {

    Button go_to_map;
    TextView ponuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        go_to_map = (Button) findViewById(R.id.button2);
        ponuda = findViewById(R.id.textView2);

        go_to_map.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MapActivity.class);
            startActivity(intent);
        });
    }

}