package com.example.rayanapppp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class LoggedInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Logged");
        Button Exit = findViewById(R.id.Exit);


        Exit.setOnClickListener(v -> {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.finishAffinity();
        });

        Button showAnimalsButton = findViewById(R.id.button1);
        showAnimalsButton.setOnClickListener(v -> {
            // Start the second activity (replace SecondApiActivity with your actual activity)
            Intent intent = new Intent(LoggedInActivity.this, SecondApi.class);
            startActivity(intent);
        });
        Button showInstagramButton = findViewById(R.id.button2);
        showInstagramButton.setOnClickListener(v -> {
            // Start the RayanMainActivity (replace RayanMainActivity with your actual activity)
            Intent intent = new Intent(LoggedInActivity.this, rayanMain.class);
            startActivity(intent);
        });


    }
}