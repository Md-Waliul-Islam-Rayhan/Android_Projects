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

public class addIncome extends AppCompatActivity {
    String[] IncomeSpinner;
    private Button addIncomeButton;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        IncomeSpinner = getResources().getStringArray(R.array.Add_Income_Items);

        getSupportActionBar().setTitle("Add Income");
        //Notification Color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.TitleBarColor)));

        //This is for Back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        addIncomeButton = findViewById(R.id.addIncomeButton);
        spinner = findViewById(R.id.AddIncomeSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.TextViewSample,IncomeSpinner);
        spinner.setAdapter(adapter);

        addIncomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addIncomeFunction();
            }
        });



    }

    //This is for Back Button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


    private void addIncomeFunction() {

        String value = spinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), value+" is Selected", Toast.LENGTH_LONG).show();

    }
}