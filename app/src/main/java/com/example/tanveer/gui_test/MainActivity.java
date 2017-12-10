package com.example.tanveer.gui_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void admin_login(View view) {
        Intent admin = new Intent(this, adminactivity.class);
        startActivity(admin);

    }

    public void take_test(View view) {
        Intent test = new Intent(this, Mcqactivity.class);
        startActivity(test);
    }
}
