package com.dev.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<String> name = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=findViewById(R.id.listView);

        name.add("Rayhan");
        name.add("Nishat");
        name.add("Rabib");
        name.add("Ammu");
        name.add("Abbu");
        name.add("Waliul");
        name.add("Roudra");
        name.add("Farhan");
        name.add("Masus vai");
        name.add("kana");
        name.add("Fuck");
        name.add("Tomatto");
        name.add("Kunji");
        name.add("zpanda");
        name.add("ziraff");
        name.add("dog");
        name.add("Gekol");
        name.add("gieko");
        name.add("honda");
        name.add("asus");
        name.add("volvo");
        name.add("tempo");
        name.add("minu");
        name.add("Rayhan");
        name.add("Nishat");
        name.add("Rabib");
        name.add("Ammu");
        name.add("Abbu");
        name.add("Waliul");
        name.add("Roudra");
        name.add("Farhan");
        name.add("Masus vai");
        name.add("kana");
        name.add("Fuck");
        name.add("Tomatto");
        name.add("Kunji");
        name.add("zpanda");
        name.add("ziraff");
        name.add("dog");
        name.add("Gekol");
        name.add("gieko");
        name.add("honda");
        name.add("asus");
        name.add("volvo");
        name.add("tempo");
        name.add("minu");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, name);

        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    Toast.makeText(MainActivity.this,"Hello", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}