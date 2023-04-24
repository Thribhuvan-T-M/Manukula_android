package com.quotes.manukula.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.quotes.manukula.Core.DashboardActivity;
import com.quotes.manukula.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    private EditText fullNameET, emailET, passwordET;
    private Button signUpButton;
    private TextView backToLoginButton;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        init();

        mainLogic();

    }

    private void init() {
        fullNameET = findViewById(R.id.full_name_et);
        emailET = findViewById(R.id.email_sign_up_et);
        passwordET = findViewById(R.id.password_sign_up_et);
        signUpButton = findViewById(R.id.sign_up_button);
        backToLoginButton = findViewById(R.id.back_to_login_button);
        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
    }

    private void mainLogic() {
        //back to login page
        backToLoginButton.setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });

        //sign up user
        signUpButton.setOnClickListener(this::signUpUser);
    }

    private void signUpUser(View view) {
        if (!TextUtils.isEmpty(fullNameET.getText().toString())) {
            if (!TextUtils.isEmpty(emailET.getText().toString())) {
                if (!TextUtils.isEmpty(passwordET.getText().toString())) {
                    firebaseAuth.signInWithEmailAndPassword(emailET.getText().toString(), passwordET.getText().toString())
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    setUserDataToDB(emailET.getText().toString(), fullNameET.getText().toString());
                                } else {
                                    Snackbar.make(view, "Something went wrong", Snackbar.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Snackbar.make(view, "Please enter a new password", Snackbar.LENGTH_SHORT).show();
                }
            } else {
                Snackbar.make(view, "Please enter your Email ID", Snackbar.LENGTH_SHORT).show();
            }
        } else {
            Snackbar.make(view, "Please enter your full name", Snackbar.LENGTH_SHORT).show();
        }
    }

    private void setUserDataToDB(String email, String fullName) {
        Map<String, Object> updateUserMap = new HashMap<>();
        updateUserMap.put("Name", fullName);
        updateUserMap.put("Email", email);
        updateUserMap.put("InstalledDate", FieldValue.serverTimestamp());

        firestore.collection("Users").document(Objects.requireNonNull(firebaseAuth.getUid()))
                .update(updateUserMap).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(this, DashboardActivity.class));
                        finish();
                    } else {
                        Log.e("error",
                                "" + Objects.requireNonNull(task.getException()).getMessage());
                    }
                });
    }
}