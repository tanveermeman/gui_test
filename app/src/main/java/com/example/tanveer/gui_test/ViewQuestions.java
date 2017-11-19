package com.example.tanveer.gui_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewQuestions extends AppCompatActivity {

    EditText editText;
    Button submit, fetch;
    DatabaseReference rootRef, demoRef;
    TextView demoValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_questions);

        demoValue = (TextView) findViewById(R.id.tvValue);
        fetch = (Button) findViewById(R.id.fetch);

        //database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();

        //database reference pointing to demo node
        demoRef = rootRef.child("questions");


        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demoRef.child("value").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);
                        demoValue.setText(value);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });
    }
}
