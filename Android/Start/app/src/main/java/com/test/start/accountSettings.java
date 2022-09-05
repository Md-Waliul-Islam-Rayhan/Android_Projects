package com.test.start;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class accountSettings extends AppCompatActivity {

    FirebaseAuth mAuth;
    private Button SOButton;

    /*TextView name, mail;
    String fullName="firstName", firstName;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        /*name = findViewById(R.id.AccountNameTextView);
        mail = findViewById(R.id.AccountEmailIdTextView);


        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){
            firstName = bundle.getString("key");
            //String lastName = bundle.getString("lastnameKey");

            //fullName = firstName+" "+lastName;
        }

        name.setText(firstName);*/



        mAuth = FirebaseAuth.getInstance();

        getSupportActionBar().setTitle("Account");
        //Notification Color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.TitleBarColor)));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        SOButton = findViewById(R.id.AccountSettingSingOutButton);

        SOButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();
                Intent intent = new Intent(accountSettings.this, signIn.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Sign out is Successful", Toast.LENGTH_LONG).show();
                //finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}