package com.dev.recyceler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    RecycleViewerAdapter recycleViewerAdapter;

    EditText nameET, numberET;
    Button addButton;

    ArrayList<contract_sample_java_model> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        floatingActionButton = findViewById(R.id.fabId);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_item_layout);

                nameET = dialog.findViewById(R.id.nameEditText);
                numberET = dialog.findViewById(R.id.contact_number_EditText);
                addButton = dialog.findViewById(R.id.addButton);

                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="", number="";

                        if (!nameET.getText().toString().equals("")){
                            name = nameET.getText().toString();
                        }
                        else{
                            nameET.setError("Enter name please");
                        }

                        if (!numberET.getText().toString().equals("")){
                            number = numberET.getText().toString();
                        }
                        else{
                            numberET.setError("Enter number please");
                        }

                        arrayList.add(new contract_sample_java_model(R.drawable.a, name, number));
                        recycleViewerAdapter.notifyItemInserted(arrayList.size()-1);
                        recyclerView.scrollToPosition(arrayList.size()-1);

                        dialog.dismiss();
                    }
                });
                dialog.show();


            }
        });

        //kon layout e dekhate cai, linear or gird view etc.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        arrayList.add(new contract_sample_java_model(R.drawable.a,"Rayhan", "01303099926"));
        arrayList.add(new contract_sample_java_model(R.drawable.b,"Waliul", "6546465654"));
        arrayList.add(new contract_sample_java_model(R.drawable.g,"Islam", "545646546556"));
        arrayList.add(new contract_sample_java_model(R.drawable.d,"Nishat", "987894135435"));
        arrayList.add(new contract_sample_java_model(R.drawable.e,"Mahmud", "68765132101"));
        arrayList.add(new contract_sample_java_model(R.drawable.f,"Rhythm", "98710125465"));
        arrayList.add(new contract_sample_java_model(R.drawable.g,"Farhan", "698702165456"));
        arrayList.add(new contract_sample_java_model(R.drawable.h,"Roudra", "545641535135"));
        arrayList.add(new contract_sample_java_model(R.drawable.i,"Masud", "9874106546"));
        arrayList.add(new contract_sample_java_model(R.drawable.j,"Bulbuli", "84615068465"));
        arrayList.add(new contract_sample_java_model(R.drawable.k,"Mim", "897461056841"));
        arrayList.add(new contract_sample_java_model(R.drawable.l,"Love", "8974156565"));
        arrayList.add(new contract_sample_java_model(R.drawable.m,"Test", "86746156616"));

        arrayList.add(new contract_sample_java_model(R.drawable.a,"Rayhan", "01303099926"));
        arrayList.add(new contract_sample_java_model(R.drawable.b,"Waliul", "6546465654"));
        arrayList.add(new contract_sample_java_model(R.drawable.g,"Islam", "545646546556"));
        arrayList.add(new contract_sample_java_model(R.drawable.d,"Nishat", "987894135435"));
        arrayList.add(new contract_sample_java_model(R.drawable.e,"Mahmud", "68765132101"));
        arrayList.add(new contract_sample_java_model(R.drawable.f,"Rhythm", "98710125465"));
        arrayList.add(new contract_sample_java_model(R.drawable.g,"Farhan", "698702165456"));
        arrayList.add(new contract_sample_java_model(R.drawable.h,"Roudra", "545641535135"));
        arrayList.add(new contract_sample_java_model(R.drawable.i,"Masud", "9874106546"));
        arrayList.add(new contract_sample_java_model(R.drawable.j,"Bulbuli", "84615068465"));
        arrayList.add(new contract_sample_java_model(R.drawable.k,"Mim", "897461056841"));
        arrayList.add(new contract_sample_java_model(R.drawable.l,"Love", "8974156565"));
        arrayList.add(new contract_sample_java_model(R.drawable.m,"Test", "86746156616"));

        arrayList.add(new contract_sample_java_model(R.drawable.a,"Rayhan", "01303099926"));
        arrayList.add(new contract_sample_java_model(R.drawable.b,"Waliul", "6546465654"));
        arrayList.add(new contract_sample_java_model(R.drawable.g,"Islam", "545646546556"));
        arrayList.add(new contract_sample_java_model(R.drawable.d,"Nishat", "987894135435"));
        arrayList.add(new contract_sample_java_model(R.drawable.e,"Mahmud", "68765132101"));
        arrayList.add(new contract_sample_java_model(R.drawable.f,"Rhythm", "98710125465"));
        arrayList.add(new contract_sample_java_model(R.drawable.g,"Farhan", "698702165456"));
        arrayList.add(new contract_sample_java_model(R.drawable.h,"Roudra", "545641535135"));
        arrayList.add(new contract_sample_java_model(R.drawable.i,"Masud", "9874106546"));
        arrayList.add(new contract_sample_java_model(R.drawable.j,"Bulbuli", "84615068465"));
        arrayList.add(new contract_sample_java_model(R.drawable.k,"Mim", "897461056841"));
        arrayList.add(new contract_sample_java_model(R.drawable.l,"Love", "8974156565"));
        arrayList.add(new contract_sample_java_model(R.drawable.m,"Test", "86746156616"));
        
        recycleViewerAdapter = new RecycleViewerAdapter(this, arrayList);
        recyclerView.setAdapter(recycleViewerAdapter);
    }
}