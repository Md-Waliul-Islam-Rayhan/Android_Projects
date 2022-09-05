package com.test.start;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class accountSettings extends AppCompatActivity {

    FirebaseAuth mAuth;
    private Button SOButton;
    String Fname, LName, FullName;
    TextView name, mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        name = findViewById(R.id.AccountNameTextView);
        mail = findViewById(R.id.AccountEmailIdTextView);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            Fname = bundle.getString("Fname");
            LName = bundle.getString("Lname");

            FullName = Fname+" "+LName;

            name.setText(FullName);
        }


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