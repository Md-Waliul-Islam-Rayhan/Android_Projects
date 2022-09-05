/*
package com.test.start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReadSignUpDataFromFirebase  extends AppCompatActivity {

    //ActivityReadDataBinding binding;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){
            String firstName = bundle.getString("key");

            readData(firstName);
        }


    }

    private void readData(String firstName) {

        reference = FirebaseDatabase.getInstance().getReference("Sign Up User Data");
        reference.child(firstName).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if(task.isSuccessful()){

                    if (task.getResult().exists()){

                        DataSnapshot dataSnapshot = task.getResult();

                        String first = String.valueOf(dataSnapshot.child("firstName").getValue());
                        String last = String.valueOf(dataSnapshot.child("lastName").getValue());
                        String mail = String.valueOf(dataSnapshot.child("email").getValue());

                        Intent intent1 = new Intent(ReadSignUpDataFromFirebase.this, accountSettings.class);
                        intent1.putExtra("firstnameKey", first);
                        startActivity(intent1);

                        Intent intent2 = new Intent(ReadSignUpDataFromFirebase.this, accountSettings.class);
                        intent2.putExtra("lastnameKey", last);
                        startActivity(intent2);

                        Intent intent3= new Intent(ReadSignUpDataFromFirebase.this, accountSettings.class);
                        intent3.putExtra("EmailKey", mail);
                        startActivity(intent3);



                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Null", Toast.LENGTH_LONG).show();

                    }

                }

                else{
                    Toast.makeText(getApplicationContext(), "Unsuccessful", Toast.LENGTH_LONG).show();

                }

            }
        });
    }


}
*/
