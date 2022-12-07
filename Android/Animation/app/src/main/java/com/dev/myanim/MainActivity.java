package com.dev.myanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView hello;
    Button bt1, bt2, bt3, bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello=findViewById(R.id.textView);
        bt1=findViewById(R.id.button1);
        bt2=findViewById(R.id.button2);
        bt3=findViewById(R.id.button3);
        bt4=findViewById(R.id.button4);

        Animation move = AnimationUtils.loadAnimation(this, R.anim.move);
        Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hello.startAnimation(move);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hello.startAnimation(alpha);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hello.startAnimation(scale);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hello.startAnimation(rotate);
            }
        });
    }
}