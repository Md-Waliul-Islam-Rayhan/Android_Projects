package com.dev.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt;
    ConstraintLayout main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = findViewById(R.id.button);
        main = findViewById(R.id.Main);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.setBackgroundColor(getResources().getColor(R.color.purple_200));
            }
        });

    }
}