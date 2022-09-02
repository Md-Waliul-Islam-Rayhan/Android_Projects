package com.test.start;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class addExpanse extends AppCompatActivity {
    String[] ExpanseSpinner;
    private Button addExpanseButton;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expanse);

        ExpanseSpinner = getResources().getStringArray(R.array.Add_Expanse_Items);

        getSupportActionBar().setTitle("Add Expense");
        //Notification Color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.TitleBarColor)));

        //This is for Back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        addExpanseButton = findViewById(R.id.addExpeseButton);
        spinner = findViewById(R.id.AddExpanseSpinner);

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
        Toast.makeText(getApplicationContext(), value+" is Selected", Toast.LENGTH_LONG).show();

    }
}