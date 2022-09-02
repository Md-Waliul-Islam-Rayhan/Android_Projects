package com.test.start;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addExpanse extends AppCompatActivity {
    String[] ExpanseSpinner;
    private Button addExpanseButton;
    private EditText amount, comment;
    Spinner spinner;
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expanse);

        databaseReference = FirebaseDatabase.getInstance().getReference("Add Expanse User Data");
        mAuth = FirebaseAuth.getInstance();

        ExpanseSpinner = getResources().getStringArray(R.array.Add_Expanse_Items);

        getSupportActionBar().setTitle("Add Expense");
        //Notification Color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.TitleBarColor)));

        //This is for Back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        addExpanseButton = findViewById(R.id.addExpeseButton);
        spinner = findViewById(R.id.AddExpanseSpinner);
        amount = findViewById(R.id.ExpanseAmountTakaEditText);
        comment = findViewById(R.id.ExpanseCommentEditText);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.TextViewSample,ExpanseSpinner);
        spinner.setAdapter(adapter);

        addExpanseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpanseFunction();
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

    private void addExpanseFunction() {

        String value = spinner.getSelectedItem().toString();
        String am = amount.getText().toString().trim();
        String cmnt = comment.getText().toString().trim();
        //Toast.makeText(getApplicationContext(), value+" is Selected", Toast.LENGTH_LONG).show();


        String key = databaseReference.push().getKey();

        AddUserDetails data = new AddUserDetails(value, am, cmnt);
        databaseReference.child(key).setValue(data);
        Toast.makeText(getApplicationContext(), "User data saved Successfully", Toast.LENGTH_LONG).show();

    }
}