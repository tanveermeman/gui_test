package com.example.tanveer.gui_test;
import android.util.Log;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
public class QuestionLibrary  {
    DatabaseReference rootRef, demoRef;
    String[] mQuestions = new String[100];
    public void getQuestions(){
        //database reference pointing to root of database
        Log.d("DEBUG", "CALLING GET QUESTIONS");
        rootRef = FirebaseDatabase.getInstance().getReference();

        //database reference pointing to demo node
        demoRef = rootRef.child("questions");

        demoRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> arrlist = new ArrayList<String>();
                for (DataSnapshot questionObject: dataSnapshot.getChildren()) {
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
    public String getQuestion(int a){
        String question =mQuestions[a];
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

        String choice2 = mQuestions[a] ;
        return choice2;
    }
    public String getChoice4(int a) {

        String choice3 = mQuestions[a] ;
        return choice3;
    }
    public String getCorrectAnswer(int a){
        String answer = mQuestions [a];
        return answer;
    }

}
