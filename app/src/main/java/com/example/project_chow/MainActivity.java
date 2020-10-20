package com.example.project_chow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project_chow.Common.Common;
import com.example.project_chow.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnSignUp;
    TextView txtSlogan;

    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);

        txtSlogan = (TextView)findViewById(R.id.txtSlogan);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/ABeeZee-Regular.ttf");
        txtSlogan.setTypeface(face);

        database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        table_user.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange (@NonNull DataSnapshot dataSnapshot){
            User localUser = dataSnapshot.getValue(User.class);
            Intent homeIntent = new Intent(MainActivity.this, Home.class);
            Common.currentUser = localUser;
            startActivity(homeIntent);
            finish();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(MainActivity.this, SignUp.class);
                startActivity(signUp);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signIn = new Intent(MainActivity.this, SignIn.class);
                startActivity(signIn);

            }
        });
    }


}