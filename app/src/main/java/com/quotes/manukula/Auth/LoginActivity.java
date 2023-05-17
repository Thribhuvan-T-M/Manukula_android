package com.quotes.manukula.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.quotes.manukula.Core.Activities.DashboardActivity;
import com.quotes.manukula.R;

public class LoginActivity extends AppCompatActivity {
    private TextView registerButton;
    private EditText emailLoginET, passwordLoginET;
    private Button loginBT;
    private FirebaseAuth auth;
    private TextView forgotPassword;

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
        emailLoginET = findViewById(R.id.fP_email_login_et);
        passwordLoginET = findViewById(R.id.password_login_et);
        loginBT = findViewById(R.id.login_button);
        forgotPassword = findViewById(R.id.forgot_password_button);
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


        forgotPassword.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
            View dialogView = getLayoutInflater().inflate(R.layout.dialog_forgot, null);
            EditText emailBox = dialogView.findViewById(R.id.fP_email_login_et);
            builder.setView(dialogView);
            AlertDialog dialog = builder.create();

            //reset dialog
            resetLogic(dialogView, emailBox, dialog);

            //cancel dialog
            dialogView.findViewById(R.id.fP_cancel_BT).setOnClickListener(view1 -> dialog.dismiss());
            dialog.show();
        });

    }

    private void resetLogic(@NonNull View dialogView, EditText emailBox, AlertDialog dialog) {
        dialogView.findViewById(R.id.fP_Reset_Bt).setOnClickListener(view -> {
            String userEmail = emailBox.getText().toString();
            if (TextUtils.isEmpty(userEmail)) {
                Toast.makeText(LoginActivity.this, "Enter your registered email id", Toast.LENGTH_SHORT).show();
                return;
            }
            auth.sendPasswordResetEmail(userEmail).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Check your email", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(LoginActivity.this, "Unable to send, failed", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    //Login Button connection code
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


