package com.test.myapplicationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView newtext, newtext_2;
    int count = 0;


    private Object handler_Listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newtext = findViewById(R.id.text_1_id);
        newtext_2 = findViewById(R.id.text_id_2);

        ImageButton b = findViewById(R.id.pic_id);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

//                Intent intent = new Intent(MainActivity.this, FAB.class);
//                startActivity(intent);
            }
        });


//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                count++;
//////                newtext_2.setText("This is new "+count+" times");
////                Toast t = Toast.makeText(MainActivity.this,"This is new "+count+" times", Toast.LENGTH_SHORT);
////                    t.setGravity(Gravity.CENTER_VERTICAL, 0,0);
////                    t.show();
//            }
//        });

        b.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.pic_id) {
//            count++;
//            Toast t = Toast.makeText(MainActivity.this,"This is new "+count+" times", Toast.LENGTH_SHORT);
//                    t.setGravity(Gravity.CENTER_VERTICAL, 0,0);
//                    t.show();

//            Log.d("tag","Image Button is clicked");

//            LayoutInflater LI = getLayoutInflater();
//
//            View custom_view = LI.inflate(R.layout.custom_toast,findViewById(R.id.Custom_Toast));
//
//                        Toast t = Toast.makeText(MainActivity.this,"This is new "+count+" times", Toast.LENGTH_SHORT);
//                    t.setGravity(Gravity.CENTER_VERTICAL, 0,0);
//                    t.setView(custom_view);
//                    t.show();

        }

    }
}