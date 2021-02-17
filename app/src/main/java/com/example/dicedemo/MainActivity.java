package com.example.dicedemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    int randLeftDie;
    int randRightDie;
    TextView mTextView;
    Button btnHigh;
    Button btnLow;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // we have two images left dice and right dice
        // link the code to those two image view inside your layout.....(activity main)
        final ImageView leftDie = findViewById(R.id.Left_dice);
        final ImageView rightDie = findViewById(R.id.right_dice);

        final int [] diceArray = {R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6};
        // we want to pick one of the dices in array randomly and replace it with left and right
        // image view inside your app!
        // Click listener look for an event on your view components.

        // begin text for the result text view
        mTextView = (TextView)this.findViewById(R.id.mytext);
        mTextView.setText("Begin!");

        // logic if user clicks higher button
        btnHigh = (Button)findViewById(R.id.higher);
        btnHigh.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rand = new Random();
                randLeftDie = rand.nextInt(6);
                randRightDie = rand.nextInt(6);

                leftDie.setImageResource(diceArray[randLeftDie]);
                rightDie.setImageResource(diceArray[randRightDie]);

                if(randLeftDie < randRightDie){
                       mTextView.setText("User Win!");
                   }else if(randLeftDie > randRightDie){
                       mTextView.setText("Computer Win!");
                   }
                   else{
                       mTextView.setText("Tie!");
                   }
            }
        });

        // logic if user clicks lower button
        btnLow = (Button)findViewById(R.id.lower);
        btnLow.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rand = new Random();
                randLeftDie = rand.nextInt(6);
                randRightDie = rand.nextInt(6);

                leftDie.setImageResource(diceArray[randLeftDie]);
                rightDie.setImageResource(diceArray[randRightDie]);

                if(randLeftDie > randRightDie){
                    mTextView.setText("User Win!");
                }else if(randLeftDie < randRightDie){
                    mTextView.setText("Computer Win!");
                }
                else{
                    mTextView.setText("Tie!");
                }
            }
        });
    }
}