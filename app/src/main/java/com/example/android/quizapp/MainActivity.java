package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreResult = 0;
    private RadioGroup radioSexGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Create Quiz Summary message with score
     *
     * @param name  of the player
     * @param score of the game
     * @return scoreMessage
     */
    private String scoreQuizSummary(String name, int score) {

        String scoreMessage = "Hi " + name;
        scoreMessage += "\nYour score is " + score + "/5 points!";
        scoreMessage += "\n" + "Try again!";
        scoreMessage += "\n" + "Thank you.";
        return scoreMessage;
    }

    /**
     * Calculates the total score of the quiz.
     *
     * @return total price
     */
    private int calculateScore(boolean selectedQuestionTwoAnswerOne, boolean selectedQuestionTwoAnswerTwo, boolean selectedQuestionTwoAnswerThree, boolean selectedQuestionTwoAnswerFour) {

        RadioButton radioOne = findViewById(R.id.question_one_answer_one);
        boolean questionOne = radioOne.isChecked();
        RadioButton radioFive = findViewById(R.id.question_five_answer_two);
        boolean questionFive = radioFive.isChecked();
        RadioButton radioFour = findViewById(R.id.question_four_answer_two);
        boolean questionFour = radioFour.isChecked();

        if (questionOne) {
            scoreResult++;
        }

        if (selectedQuestionTwoAnswerOne && selectedQuestionTwoAnswerTwo && selectedQuestionTwoAnswerThree && selectedQuestionTwoAnswerFour) {
            scoreResult++;
        }

        if (questionFour) {
            scoreResult++;
        }

        if (questionFive) {
            scoreResult++;
        }
        return scoreResult;
    }

    /**
     * This method is called when the Check Result button is clicked.
     */
    public void checkQuizScore(View view) {
        CheckBox questionTwoAnswerOne = (CheckBox) findViewById(R.id.question_two_answer_one);
        boolean selectedQuestionTwoAnswerOne = questionTwoAnswerOne.isChecked();
        CheckBox questionTwoAnswerTwo = (CheckBox) findViewById(R.id.question_two_answer_two);
        boolean selectedQuestionTwoAnswerTwo = questionTwoAnswerTwo.isChecked();
        CheckBox questionTwoAnswerThree = (CheckBox) findViewById(R.id.question_two_answer_three);
        boolean selectedQuestionTwoAnswerThree = questionTwoAnswerThree.isChecked();
        CheckBox questionTwoAnswerFour = (CheckBox) findViewById(R.id.question_two_answer_four);
        boolean selectedQuestionTwoAnswerFour = questionTwoAnswerFour.isChecked();
        EditText txt = (EditText) findViewById(R.id.name_field);
        String name = txt.getText().toString();
        EditText txtTwo = (EditText) findViewById(R.id.question_three_answer);
        String answerThree = txtTwo.getText().toString();
        Log.v("MainActivity", "answerThree : " + answerThree);
        scoreResult = calculateScore(selectedQuestionTwoAnswerOne, selectedQuestionTwoAnswerTwo, selectedQuestionTwoAnswerThree, selectedQuestionTwoAnswerFour);
        if (answerThree.equals("2008")) {
            Log.v("MainActivity", "Score 3A : " + scoreResult);
            scoreResult++;
            Log.v("MainActivity", "Score 3B : " + scoreResult);
        }
        String quizMessage = scoreQuizSummary(name, scoreResult);
        Context context = getApplicationContext();
        CharSequence text = quizMessage;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        scoreResult = 0;
    }

}
