package com.example.tanveer.gui_test;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tanveer on 15/11/17.
 */



public class QuestionLibrary  {

    EditText editText;
    Button submit, fetch;
    DatabaseReference rootRef, demoRef;
    ExpandableListView demoValue;
    String[] mQuestions = new String[100];

    public QuestionLibrary() {
        getQuestions();
        Log.d("DEBUG", "CALLING GETQUESTIONS");
    }


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
                    //Log.d("ADebugTag", "Question number : " + question);

                    String choiceA = (String) questionObject.child("choiceA").getValue();
                    arrlist.add(choiceA);
                    //Log.d("ADebugTag", "Question number : " + choiceA.toString());

                    String choiceB = (String) questionObject.child("choiceB").getValue();
                    arrlist.add(choiceB);
                    //Log.d("ADebugTag", "Question number : " + choiceB.toString());

                    String choiceC = (String) questionObject.child("choiceC").getValue();
                    arrlist.add(choiceC);
                    //Log.d("ADebugTag", "Question number : " + choiceC.toString());

                    String choiceD = (String) questionObject.child("choiceD").getValue();
                    arrlist.add(choiceD);
                    //Log.d("ADebugTag", "Question number : " + choiceD.toString());

                    String answer = (String) questionObject.child("correctAnswer").getValue();
                    arrlist.add(answer);
                    //Log.d("ADebugTag", "Correct Answer is  : " + answer.toString());
                    //Log.d("debugtag","arrlist"+arrlist);
                }
                mQuestions = arrlist.toArray(new String[arrlist.size()]);
/*                Log.d("debugtag","stringArray"+ Arrays.toString(mQuestions));
                Log.d("debugtag","indexvalue"+mQuestions[0]);
                Log.d("debugtag","indexvalue"+mQuestions[1]);
                Log.d("debugtag","indexvalue"+mQuestions[2]);
                Log.d("debugtag","indexvalue"+mQuestions[3]);
                Log.d("debugtag","indexvalue"+mQuestions[4]);
                Log.d("debugtag","indexvalue"+mQuestions[5]);
                Log.d("debugtag","indexvalue"+mQuestions[6]);
                Log.d("debugtag","indexvalue"+mQuestions[7]);*/



            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }



    /*  public static String mQuestions[] = {
            "What is the full form of IP ?",
            "C++ is what type of language ?",
            "How many layers are there in the OSI model ?",
            "Which is an operating sytem amongst the following ?"
    };

    private String mChoices [] [] = {
            {"internet package","intranet protocol","internet protocol","internet pool"},
            {"static","dynamic","object oriented","interpreted"},
            {"three","five","seven","six"},
            {"linux","eclipse","MS_office","android-studio"}
    };

    private String mCorrectanswers[] = {"internet protocol","object oriented","seven","linux"};

*/

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
