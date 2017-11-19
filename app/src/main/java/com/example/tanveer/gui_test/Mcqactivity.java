package com.example.tanveer.gui_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Mcqactivity extends AppCompatActivity {

        private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

        private TextView mScoreView;
        private TextView mQuestionView;
        private TextView mButtonChoice1;
        private TextView mButtonChoice2;
        private TextView mButtonChoice3;
        private TextView mButtonChoice4;



        private String mAnswer;
        private int mScore = 0;
        private int mQuestionNumber = 0;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mcqactivity);

            mScoreView = (TextView)findViewById(R.id.score);
            mQuestionView = (TextView)findViewById(R.id.question);
            mButtonChoice1 = (Button)findViewById(R.id.choice1);
            mButtonChoice2 = (Button)findViewById(R.id.choice2);
            mButtonChoice3 = (Button)findViewById(R.id.choice3);
            //mButtonChoice4 = (Button)findViewById(R.id.choice4);

            updateQuestion();


            //start button listener for button 1
            mButtonChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //logic for the button goes here

                    if (mButtonChoice1.getText() == mAnswer){
                        mScore = mScore + 1;
                        updateScore(mScore);
                        updateQuestion();
                        //this line is optional code
                        Toast.makeText(Mcqactivity.this,"correct",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Mcqactivity.this,"wrong",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            // End of button listener for button 1

            //start button listener for button 2
            mButtonChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //logic for the button goes here

                    if (mButtonChoice2.getText() == mAnswer){
                        mScore = mScore + 1;
                        updateScore(mScore);
                        updateQuestion();
                        //this line is optional code
                        Toast.makeText(Mcqactivity.this,"correct",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Mcqactivity.this,"wrong",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            // End of button listener button 2

            //start button listener for button 3
            mButtonChoice3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //logic for the button goes here

                    if (mButtonChoice3.getText() == mAnswer){
                        mScore = mScore + 1;
                        updateScore(mScore);
                        updateQuestion();
                        //this line is optional code
                        Toast.makeText(Mcqactivity.this,"correct",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Mcqactivity.this,"wrong",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            // End of button listener button 3

            //start button listener for button 4
            // mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            //     @Override
            //     public void onClick(View view) {
            //         //logic for the button goes here
            //
            //         if (mButtonChoice4.getText() == mAnswer){
            //             mScore = mScore + 1;
            //             updateScore(mScore);
            //             updateQuestion();
            //             //this line is optional code
            //             Toast.makeText(McqActivity.this,"correct",Toast.LENGTH_SHORT).show();
            //         }
            //         else {
            //             Toast.makeText(McqActivity.this,"wrong",Toast.LENGTH_SHORT).show();
            //         }
            //     }
            // });
            //
            // End of button listener button 4


        }

        private void updateQuestion(){

            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
            //mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }

        private void updateScore(int point) {
            mScoreView.setText("" + mScore);
        }


    }

