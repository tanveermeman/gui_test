package com.example.tanveer.gui_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;


public class question_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_activity);

        final Button button = findViewById(R.id.SaveQButton);
        final EditText question = findViewById(R.id.QuestionBox);
        final EditText choiceA = findViewById(R.id.ChoiceABox);
        final EditText choiceB = findViewById(R.id.ChoiceBBox);
        final EditText choiceC = findViewById(R.id.ChoiceCBox);
        final EditText choiceD = findViewById(R.id.ChoiceDBox);
        final EditText correctAnswer = findViewById(R.id.CorrectAnswer);



        // Initialize Array of lenght 6.
        // array[0] = myquestion
        // array[1-4] = myquestion
        // array[5] = correct answer

        final String[] myquestion = new String[6];

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myquestion[0] = question.getText().toString();
                myquestion[1] = choiceA.getText().toString();
                myquestion[2] = choiceB.getText().toString();
                myquestion[3] = choiceC.getText().toString();
                myquestion[4] = choiceD.getText().toString();
                myquestion[5] = correctAnswer.getText().toString();
                 Log.d("ADebugTag", "myquestion : " + Arrays.toString(myquestion));
            }

        });

    }


}
