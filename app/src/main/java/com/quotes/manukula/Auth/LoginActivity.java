package com.quotes.manukula.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.quotes.manukula.Core.DashboardActivity;
import com.quotes.manukula.R;

public class LoginActivity extends AppCompatActivity {
    private TextView registerButton;
    private EditText emailLoginET, passwordLoginET;
    private Button loginBT;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        init();
        logicsInMain();
    }

    private void init() {
        registerButton = findViewById(R.id.back_to_signup_button);
        auth = FirebaseAuth.getInstance();
        emailLoginET = findViewById(R.id.email_login_et);
        passwordLoginET = findViewById(R.id.password_login_et);
        loginBT = findViewById(R.id.login_button);
    }

    private void logicsInMain() {
        //Signup redirect
        registerButton.setOnClickListener(view -> {
            Intent signUpIntent = new Intent(this, SignUpActivity.class);
            startActivity(signUpIntent);
            finish();

        });

        //Login user
        loginBT.setOnClickListener(view -> {
            if (!TextUtils.isEmpty(emailLoginET.getText().toString())) {
                if (!TextUtils.isEmpty(passwordLoginET.getText().toString())) {
                    loginUserFunc(view);
                } else {
                    Snackbar.make(view, "Please enter your password", Snackbar.LENGTH_SHORT).show();
                }
            } else {
                Snackbar.make(view, "Please enter your email id", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void loginUserFunc(View view) {
        auth.signInWithEmailAndPassword(emailLoginET.getText().toString(), passwordLoginET.getText().toString()).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Intent intent = new Intent(this, DashboardActivity.class);
                startActivity(intent);
                finish();
            } else {
                Snackbar.make(view, "Login Failed", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}