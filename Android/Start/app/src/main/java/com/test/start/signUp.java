package com.test.start;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class signUp extends AppCompatActivity implements View.OnClickListener {

   private EditText firstNameEditText, lastNameEditText, EmailEditText, passwordEditText, confirmPasswordEditText;
    private Button signUpButton;
        private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        mAuth = FirebaseAuth.getInstance();

        //this.setTitle("Sign Up Activity");

//        createAccountTextView = findViewById(R.id.createAccountTextView);
//        alreadyHaveAnAccountTextView = findViewById(R.id.alreadyHaveAnAccountTextView);
//        signInHereTextView = findViewById(R.id.signInHereTextView);

        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        EmailEditText = findViewById(R.id.EmailEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);

        signUpButton = findViewById(R.id.signUpButton);

        progressBar = findViewById(R.id.progressBar);


        signUpButton.setOnClickListener(this);
//        signInHereTextView.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.signUpButton) {
//            Intent intent = new Intent(sign_up.this, sign_in.class);
//            startActivity(intent);
            userRegister();
        }

//        if (view.getId() == R.id.signInHereTextView) {
//            Intent intent = new Intent(sign_up.this, sign_in.class);
//            startActivity(intent);
//            finish();
//        }
    }




    private void userRegister() {
        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String email = EmailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();

        if (firstName.isEmpty()) {
            firstNameEditText.setError("Enter Your First Name");
            firstNameEditText.requestFocus();
            return;
        }

        if (lastName.isEmpty()) {
            lastNameEditText.setError("Enter Your Last Name");
            lastNameEditText.requestFocus();
            return;
        }

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

        if(!password.equals(confirmPassword)){
            confirmPasswordEditText.setError("Password Does not Match");
            confirmPasswordEditText.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    Intent intent = new Intent(signUp.this, signIn.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Registration is Successful", Toast.LENGTH_LONG).show();
                    finish();
                }

                else {
                    progressBar.setVisibility(View.GONE);
                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(getApplicationContext(), "User is already Registered", Toast.LENGTH_LONG).show();

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Registration is Unsuccessful. Error: "+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

}