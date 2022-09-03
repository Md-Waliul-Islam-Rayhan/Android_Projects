package com.test.start;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailsAddIncome extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<AddUserDetails> IncomeDataList;
    private Custom_Adapter custom_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_add_income);

        getSupportActionBar().setTitle("Cash History");
        //Notification Color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.TitleBarColor)));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        listView = findViewById(R.id.DetailsAddIncomeListView);


        databaseReference = FirebaseDatabase.getInstance().getReference("Add Income User Data");
        IncomeDataList = new ArrayList<>();
        custom_adapter = new Custom_Adapter(DetailsAddIncome.this,IncomeDataList);


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                IncomeDataList.clear();
                for (DataSnapshot dataSnapshot1 : snapshot.getChildren()) {

                    AddUserDetails UserData = dataSnapshot1.getValue(AddUserDetails.class);
                    IncomeDataList.add(UserData);

                }

                listView.setAdapter(custom_adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        super.onStart();
    }
}