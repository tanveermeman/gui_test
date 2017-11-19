package com.example.tanveer.gui_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Random;


public class question_activity extends AppCompatActivity {
    private DatabaseReference mDatabase;

    private int getRandomNumber(int min,int max) {
        return (new Random()).nextInt((max - min) + 1) + min;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_activity);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        final Button button = findViewById(R.id.SaveQButton);
        final EditText question = findViewById(R.id.QuestionBox);
        final EditText choiceA = findViewById(R.id.ChoiceABox);
        final EditText choiceB = findViewById(R.id.ChoiceBBox);
        final EditText choiceC = findViewById(R.id.ChoiceCBox);
        final EditText choiceD = findViewById(R.id.ChoiceDBox);
        final EditText correctAnswer = findViewById(R.id.CorrectAnswer);

        final HashMap<String, String > myquestion;
        myquestion = new HashMap<String, String>();


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final int randomInt;
                randomInt = getRandomNumber(1, 10000);
                myquestion.put("question", question.getText().toString());
                myquestion.put("choiceA", choiceA.getText().toString());
                myquestion.put("choiceB", choiceB.getText().toString());
                myquestion.put("choiceC", choiceC.getText().toString());
                myquestion.put("choiceD", choiceD.getText().toString());

                myquestion.put("correctAnswer", correctAnswer.getText().toString());
                // Log.d("ADebugTag", "myquestion : " + Arrays.toString(myquestion));
                // mDatabase.child("questions").child(Integer.toString(randomInt)).setValue(myquestion);
                mDatabase.child("questions").push().setValue(myquestion);
            }


        });

    }


}
