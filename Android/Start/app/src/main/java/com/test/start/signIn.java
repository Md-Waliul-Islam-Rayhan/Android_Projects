package com.test.start;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signIn extends AppCompatActivity implements View.OnClickListener {

    private TextView newUser, createAccount;
    private EditText EmailEditText, passwordEditText;
    private Typeface typeface;
    private ProgressBar progressBar;
    private Button signInButton;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        try {
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();


            newUser = findViewById(R.id.newUser);
            createAccount = findViewById(R.id.createAccount);
            EmailEditText = findViewById(R.id.SignInEmailEditText);
            passwordEditText = findViewById(R.id.SignInPasswordEditText);
            signInButton = findViewById(R.id.signInButton);
            progressBar = findViewById(R.id.progressBar);

            typeface = Typeface.createFromAsset(getAssets(), "fonts/roboto_bold.ttf");
            newUser.setTypeface(typeface);
            createAccount.setTypeface(typeface);


            signInButton.setOnClickListener(this);
            createAccount.setOnClickListener(this);
        }

        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Exception", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.signInButton) {
//            Intent intent = new Intent(sign_in.this, MainActivity.class);
//            startActivity(intent);
            userSignIn();
        }
        if (view.getId() == R.id.createAccount) {
            Intent intent = new Intent(signIn.this, signUp.class);
            startActivity(intent);
        }
    }


    private void userSignIn() {
        String email = EmailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty()) {
            EmailEditText.setError("Enter a Email Address");
            EmailEditText.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            EmailEditText.setError("Enter a Valid Email Address");
            EmailEditText.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordEditText.setError("Enter a Password");
            passwordEditText.requestFocus();
            return;
        }

        if (password.length() < 6) {
            passwordEditText.setError("Minimum Length of Password should be 6");
            passwordEditText.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    Intent intent = new Intent(signIn.this, homePage.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Login is Successful", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Email and Password Does not match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}