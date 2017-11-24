package com.example.tanveer.gui_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ViewQuestions extends AppCompatActivity {

    EditText editText;
    Button submit, fetch;
    DatabaseReference rootRef, demoRef;
    ExpandableListView demoValue;
    //final HashMap<String, String > Quesitons[] = new HashMap[0];

    public void getQuestions(){
        //database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();

        //database reference pointing to demo node
        demoRef = rootRef.child("questions");

        demoRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //HashMap<String, String> map = (HashMap<String,String>) dataSnapshot.getValue();
                ArrayList<String> arrlist = new ArrayList<String>();

                //Log.d("TAG", String.format("map: %s", map));
                //Log.d("TAG", String.format("map: %s", map.keySet().getClass().toString()));
                    for (DataSnapshot questionObject: dataSnapshot.getChildren()) {
                    String question = (String) questionObject.child("question").getValue();
                    arrlist.add(question);
                    Log.d("ADebugTag", "Question number : " + question.toString());

                    String choiceA = (String) questionObject.child("choiceA").getValue();
                        arrlist.add(choiceA);
                        Log.d("ADebugTag", "Question number : " + choiceA.toString());

                    String choiceB = (String) questionObject.child("choiceB").getValue();
                        arrlist.add(choiceB);
                        Log.d("ADebugTag", "Question number : " + choiceB.toString());

                    String choiceC = (String) questionObject.child("choiceC").getValue();
                        arrlist.add(choiceC);
                        Log.d("ADebugTag", "Question number : " + choiceC.toString());

                    String choiceD = (String) questionObject.child("choiceD").getValue();
                        arrlist.add(choiceD);
                        Log.d("ADebugTag", "Question number : " + choiceD.toString());

                    String answer = (String) questionObject.child("correctAnswer").getValue();
                        arrlist.add(answer);
                        Log.d("ADebugTag", "Correct Answer is  : " + choiceC.toString());
                        Log.d("debugtag","arrlist"+arrlist);
                }
                String stringArray[]=arrlist.toArray(new String[arrlist.size()]);
                Log.d("debugtag","stringArray"+ Arrays.toString(stringArray));
                Log.d("tag","Array_index_Val"+stringArray[0]);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_questions);

        demoValue = (ExpandableListView) findViewById(R.id.tvValue);
        fetch = (Button) findViewById(R.id.fetch);




        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getQuestions();
            }
        });
    }
}
