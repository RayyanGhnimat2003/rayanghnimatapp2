package com.example.rayanapppp2;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText firstName, lastName, regNo, email, password;
    Button btnNextActivity, btnSignIn;
    Intent signInActivity;
    Intent stay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        firstName = findViewById(R.id.fName);
        lastName = findViewById(R.id.Name);
        regNo = findViewById(R.id.regNo);
        password = findViewById(R.id.password);
        email = findViewById(R.id.username);
        btnNextActivity = findViewById(R.id.register);
        btnSignIn = findViewById(R.id.homeSignIn);
        checkDataEntered();
        btnNextActivity.setOnClickListener(v -> {
            checkDataEntered();
            if (isEmpty(email)) {
                stay = new Intent(MainActivity2.this, MainActivity2.class);
                startActivity(stay);
                Toast.makeText(getApplicationContext(), "Must Enter Email to Register", Toast.LENGTH_SHORT).show();
            } else if (isEmpty(password)) {
                stay = new Intent(MainActivity2.this, MainActivity2.class);
                startActivity(stay);
                Toast.makeText(getApplicationContext(), "Must Enter Password to Register", Toast.LENGTH_SHORT).show();
            } else if (isEmpty(firstName)) {
                stay = new Intent(MainActivity2.this, MainActivity2.class);
                startActivity(stay);
                Toast.makeText(getApplicationContext(), "Must Enter First Name to Register", Toast.LENGTH_SHORT).show();
            } else if (isEmpty(lastName)) {
                stay = new Intent(MainActivity2.this, MainActivity2.class);
                startActivity(stay);
                Toast.makeText(getApplicationContext(), "Must Enter Last Name to Register", Toast.LENGTH_SHORT).show();
            } else if (isEmpty(regNo)) {
                stay = new Intent(MainActivity2.this, MainActivity2.class);
                startActivity(stay);
                Toast.makeText(getApplicationContext(), "Must Enter Registration No to Register", Toast.LENGTH_SHORT).show();
            } else {
                Intent secondApiIntent = new Intent(MainActivity2.this, SecondApi.class);
                startActivity(secondApiIntent);
            }
        });

        btnSignIn.setOnClickListener(v -> {
            signInActivity = new Intent(MainActivity2.this, signInActivity.class);
            startActivity(signInActivity);
        });


    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    void checkDataEntered() {
        if (isEmpty(firstName)) {
            firstName.setError("First Name is required!");
        }

        if (isEmpty(lastName)) {
            lastName.setError("Last Name is required!");
        }

        if (isEmpty(regNo)) {
            regNo.setError("Registration No is required!");
        }

        if (!isEmail(email)) {
            email.setError("Enter valid Email!");
        }

        if (isEmpty(password)) {
            password.setError("Password is required!");
        }
    }
}