package com.example.tanveer.gui_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Mcqactivity extends AppCompatActivity {
    DatabaseReference rootRef, demoRef;
    String[] mQuestions = new String[100];
    private TextView mScoreView;
    private TextView mQuestionView;
    private TextView mButtonChoice1;
    private TextView mButtonChoice2;
    private TextView mButtonChoice3;
    private TextView mButtonChoice4;
    private Button mButtonStartQuiz;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(Mcqactivity.this, "Yo", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcqactivity);
        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);
        mButtonStartQuiz = (Button) findViewById(R.id.startQuiz);
        getQuestions();

        mButtonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Mcqactivity.this, "wrong", Toast.LENGTH_SHORT).show();
                mButtonStartQuiz.setVisibility(View.INVISIBLE);
                mScoreView.setVisibility(View.VISIBLE);
                mButtonChoice1.setVisibility(View.VISIBLE);
                mButtonChoice2.setVisibility(View.VISIBLE);
                mButtonChoice3.setVisibility(View.VISIBLE);
                mButtonChoice4.setVisibility(View.VISIBLE);
                mQuestionView.setVisibility(View.VISIBLE);
                startQuiz();
            }
        });
    }

    private void startQuiz(){
        updateQuestion();
        //start button listener for button 1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //logic for the button goes here
                Log.d("DEBUG", "mAnswer" + mAnswer);
                Log.d("DEBUG", "Choice1"+mButtonChoice1.getText());
                if (mButtonChoice1.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //this line is optional code
                    Toast.makeText(Mcqactivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Mcqactivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();

                }
                //updateQuestion();
            }
        });

        // End of button listener for button 1

        //start button listener for button 2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //logic for the button goes here

                if (mButtonChoice2.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //this line is optional code
                    Toast.makeText(Mcqactivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Mcqactivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();

                }
            }
        });

        // End of button listener button 2

        //start button listener for button 3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //logic for the button goes here

                if (mButtonChoice3.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //this line is optional code
                    Toast.makeText(Mcqactivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Mcqactivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();

                }
            }
        });

        // End of button listener button 3

        //start button listener for button 4
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //logic for the button goes here

                if (mButtonChoice4.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //this line is optional code
                    Toast.makeText(Mcqactivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Mcqactivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();

                }
            }
        });

        // End of button listener button 4
    }

    private void updateQuestion() {
        Log.d("DEBUG", "UPDATE QUESTION CALLED");
        mButtonChoice1.setText("BLAH");
        Log.d("DEBUG", "SET TEXT CALLED");
        mQuestionView.setText(getQuestion(mQuestionNumber));
        mButtonChoice1.setText(getChoice1(mQuestionNumber + 1));
        mButtonChoice2.setText(getChoice2(mQuestionNumber + 2));
        mButtonChoice3.setText(getChoice3(mQuestionNumber + 3));
        mButtonChoice4.setText(getChoice4(mQuestionNumber + 4));

        mAnswer = getCorrectAnswer(mQuestionNumber + 5);
        mQuestionNumber = mQuestionNumber + 6;
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }

    public void getQuestions() {
        //database reference pointing to root of database
        Log.d("DEBUG", "CALLING GET QUESTIONS");
        rootRef = FirebaseDatabase.getInstance().getReference();

        //database reference pointing to demo node
        demoRef = rootRef.child("questions");

        demoRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> arrlist = new ArrayList<String>();
                for (DataSnapshot questionObject : dataSnapshot.getChildren()) {
                    String question = (String) questionObject.child("question").getValue();
                    arrlist.add(question);
                    String choiceA = (String) questionObject.child("choiceA").getValue();
                    arrlist.add(choiceA);
                    String choiceB = (String) questionObject.child("choiceB").getValue();
                    arrlist.add(choiceB);
                    String choiceC = (String) questionObject.child("choiceC").getValue();
                    arrlist.add(choiceC);
                    String choiceD = (String) questionObject.child("choiceD").getValue();
                    arrlist.add(choiceD);
                    String answer = (String) questionObject.child("correctAnswer").getValue();
                    arrlist.add(answer);
                }
                mQuestions = arrlist.toArray(new String[arrlist.size()]);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {

        String choice0 = mQuestions[a];
        return choice0;
    }

    public String getChoice2(int a) {

        String choice1 = mQuestions[a];
        return choice1;
    }

    public String getChoice3(int a) {

        String choice2 = mQuestions[a];
        return choice2;
    }

    public String getChoice4(int a) {

        String choice3 = mQuestions[a];
        return choice3;
    }

    public String getCorrectAnswer(int a) {
        String answer = mQuestions[a];
        return answer;
    }

}

