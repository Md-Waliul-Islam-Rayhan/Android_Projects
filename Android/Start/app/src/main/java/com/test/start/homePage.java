package com.test.start;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class homePage extends AppCompatActivity {

    //For Floating Action Button
    FloatingActionButton add, income, expanse;
    Animation fabOpen, fabClose, rotateForword, rotateBackword;
    ImageView cashImg;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        getSupportActionBar().setTitle(R.string.Coinbank_Wallet);
        //Notification Color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.TitleBarColor)));


        add = findViewById(R.id.addFloatingActionButton);
        income = findViewById(R.id.addIncomeFloatingActionButton);
        expanse = findViewById(R.id.addExpanseFloatingActionButton);
        cashImg = findViewById(R.id.cashImage);

        cashImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homePage.this, DetailsAddIncome.class);
                startActivity(intent);

            }
        });

        //Animation
        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        rotateForword = AnimationUtils.loadAnimation(this, R.anim.rotate_forword);
        rotateBackword = AnimationUtils.loadAnimation(this, R.anim.rotate_backword);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });

        income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Intent intent = new Intent(homePage.this, addIncome.class);
                startActivity(intent);
            }
        });

        expanse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Intent intent = new Intent(homePage.this, addExpanse.class);
                startActivity(intent);
            }
        });
    }

    private void animateFab() {
        if(isOpen){
            add.startAnimation(rotateForword);
            income.startAnimation(fabClose);
            expanse.startAnimation(fabClose);
            income.setClickable(false);
            expanse.setClickable(false);
            isOpen = false;
        }

        else{
            add.startAnimation(rotateBackword);
            income.startAnimation(fabOpen);
            expanse.startAnimation(fabOpen);
            income.setClickable(true);
            expanse.setClickable(true);
            isOpen = true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.SettingsMenu)
        {
            //Toast.makeText(getApplicationContext(), "Login is Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(homePage.this, settings.class);
            startActivity(intent);
        }

        if(item.getItemId()==R.id.ShareMenu)
        {
            //Toast.makeText(getApplicationContext(), "Login is Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(homePage.this, error.class);
            startActivity(intent);
        }

        if(item.getItemId()==R.id.RateUsMenu)
        {
            //Toast.makeText(getApplicationContext(), "Login is Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(homePage.this, error.class);
            startActivity(intent);
        }

        if(item.getItemId()==R.id.FeedbackMenu)
        {
            //Toast.makeText(getApplicationContext(), "Login is Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(homePage.this, error.class);
            startActivity(intent);
        }

        if(item.getItemId()==R.id.HelpMenu)
        {
            //Toast.makeText(getApplicationContext(), "Login is Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(homePage.this, error.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}