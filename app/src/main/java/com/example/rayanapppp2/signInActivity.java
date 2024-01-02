package com.example.rayanapppp2;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signInActivity extends AppCompatActivity {
    Intent  stay;
    EditText emailID, passcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailID = findViewById(R.id.UserName);
        passcode = findViewById(R.id.password);
        checkDataEntered();

        Button signIn = findViewById(R.id.signIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signInActivity.this, rayanMain.class);
                startActivity(intent);
            }
        });

    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(passcode)){
            passcode.setError("Password is required!");
        }
        if (isEmpty(emailID)){
            emailID.setError("Email is required");
        }
    }
}