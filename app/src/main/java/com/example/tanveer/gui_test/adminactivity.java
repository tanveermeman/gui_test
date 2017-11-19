package com.example.tanveer.gui_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class adminactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminactivity);
    }
    public void Add_Question(View view) {
        Intent Question = new Intent(this, question_activity.class);
        startActivity(Question);
    }

    public void ViewQuestions(View view) {
        Intent disp = new Intent(this, view_questions.class);
        startActivity(disp);
    }


}
