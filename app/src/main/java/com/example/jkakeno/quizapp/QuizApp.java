package com.example.jkakeno.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class QuizApp extends AppCompatActivity {
    //Declare our view variables
    private QuestionBank mQuestionBank = new QuestionBank();
    private TextView mFirstNumber;
    private TextView mSecondNumber;
    private Button mNextQuestion;
    private Button mCorrectAnswer;
    private Button mFirstIncorrectAnswer;
    private Button mSecondIncorrectAnswer;
    private ColorWheel mColorWheel = new ColorWheel();
    private RelativeLayout mRelativeLayout;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_app);

        //Assign views from the layout file to the corresponding variables
        mFirstNumber = (TextView) findViewById(R.id.firstNumber);
        mSecondNumber = (TextView) findViewById(R.id.secondNumber);
        mNextQuestion = (Button) findViewById(R.id.nextQuestion);
        mCorrectAnswer = (Button) findViewById(R.id.correctAnswer);
        mFirstIncorrectAnswer = (Button) findViewById(R.id.firstIncorrectAnswer);
        mSecondIncorrectAnswer = (Button) findViewById(R.id.secondIncorrectAnswer);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    //The "Next Question" button is pressed
                    case R.id.nextQuestion:
                        //Toast.makeText(QuizApp.this, "next question is pressed", Toast.LENGTH_SHORT).show();
                        int color   = mColorWheel.getColor();
                        mRelativeLayout.setBackgroundColor(color);
                        mNextQuestion.setTextColor(color);
                        mCorrectAnswer.setTextColor(color);
                        mFirstIncorrectAnswer.setTextColor(color);
                        mSecondIncorrectAnswer.setTextColor(color);

                        //Update the member variables declared above FirstNumber,SecondNumber,CorrectAnswer, FirstIncorrectAnswer, SecondIncorrectAnswer on the layout file
                        //with the value taken from the element of the respective arrays in QuestionoBank class
                        //increase the reading position on the array
                        //once all the elements in the array is read circle back to the start element in the array

                        mFirstNumber.setText(mQuestionBank.leftAdders[count] + "");
                        mSecondNumber.setText(mQuestionBank.rightAdders[count] + "");
                        mCorrectAnswer.setText(mQuestionBank.correctAnswers[count] + "");
                        mFirstIncorrectAnswer.setText(mQuestionBank.firstIncorrectAnswers[count] + "");
                        mSecondIncorrectAnswer.setText(mQuestionBank.secondIncorrectAnswers[count] + "");
                        count++;
                        if (count == mQuestionBank.leftAdders.length) {    //Reset the counter after reaching the end of the array
                            count = 0;
                        }
                        break;
                }
                //The "firstIncorrectAnswer" button is pressed
                switch (v.getId()) {
                    case R.id.firstIncorrectAnswer:
                        //Displays toast that says "Incorrect answer"
                        Toast.makeText(QuizApp.this, "Incorrect answer", Toast.LENGTH_SHORT).show();
                        break;
                }
                //The "secondIncorrectAnswer" button is pressed
                switch (v.getId()) {
                    case R.id.secondIncorrectAnswer:
                        //Displays toast that says "Incorrect answer"
                        Toast.makeText(QuizApp.this, "Incorrect answer", Toast.LENGTH_SHORT).show();
                        break;
                }
                //The "correctAnswer" button is pressed
                switch (v.getId()) {
                    case R.id.correctAnswer:
                        //Displays toast that says "Correct answer"
                        Toast.makeText(QuizApp.this, "Correct answer", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        //Assign lister object to each of the variables (buttons) defined
        mNextQuestion.setOnClickListener(listener);
        mCorrectAnswer.setOnClickListener(listener);
        mFirstIncorrectAnswer.setOnClickListener(listener);
        mSecondIncorrectAnswer.setOnClickListener(listener);
    }
}
