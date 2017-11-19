package com.example.tanveer.gui_test;

/**
 * Created by tanveer on 15/11/17.
 */

public class QuestionLibrary {

    private String mQuestions[] = {
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



    public String getQuestion(int a){
        String question =mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {

        String choice0 = mChoices[a] [0];
        return choice0;
    }

    public String getChoice2(int a) {

        String choice1 = mChoices[a] [1];
        return choice1;
    }

    public String getChoice3(int a) {

        String choice2 = mChoices[a] [2];
        return choice2;
    }

    public String getChoice4(int a) {

        String choice3 = mChoices[a] [3];
        return choice3;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectanswers [a];
        return answer;
    }

}
