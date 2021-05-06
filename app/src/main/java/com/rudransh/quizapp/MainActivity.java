package com.rudransh.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] questions = {"Q1. Can we compare int variable with a boolean variable?",
            "Q2. Can we have two public classes in one java file?",
    "Q3. In an instance method or a constructor, \"this\" is a reference to the current object?",
    "Q4. Garbage Collection is manual process?",
    "Q5. The JRE deletes objects when it determines that they are no longer being used. This process is called Garbage Collection."};

    private boolean[] answers = {false,false,true,false,true};
    private int score = 0;
    private int index = 0;
    Button yes;
    Button no;

    TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yes = (Button) findViewById(R.id.true1);
        no = (Button) findViewById(R.id.false1);
        question = (TextView) findViewById(R.id.question);
        question.setText(questions[index]);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // If the array is not out of bounds
                if (index<=questions.length-1){
                    // If you have given correct answer
                    if (answers[index]==true){
                        score++;
                    }
                    // Go to the next question
                    index++;
                    if (index<=questions.length-1){
                        question.setText(questions[index]);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "YOUR SCORE IS: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "THANKS FOR PLAYING. RESTART TO PLAY AGAIN", Toast.LENGTH_SHORT).show();
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // If the array is not out of bounds
                if (index<=questions.length-1){
                // If you have given correct answer
                    if (answers[index]==false){
                        score++;
                    }
                    // Go to the next question
                    index++;
                    if (index<=questions.length-1){
                        question.setText(questions[index]);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "YOUR SCORE IS: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }

                else {
                    Toast.makeText(MainActivity.this, "THANKS FOR PLAYING. RESTART TO PLAY AGAIN", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}