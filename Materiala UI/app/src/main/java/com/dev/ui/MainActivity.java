package com.dev.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText txt1, txt2;
    Button bt;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.phoneNumberId);
        txt2 = findViewById(R.id.passwordId);
        result = findViewById(R.id.showresult);

        bt = findViewById(R.id.materialButton);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txt1.getText().toString();
                result.setText(name);

            }
        });

    }
}