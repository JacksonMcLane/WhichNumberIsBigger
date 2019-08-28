package com.example.whichnumberisbigger;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private BiggerNumberGame game;
    private TextView scoreDisplayTextView;
    private Button leftButton;
    private Button rightButton;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wiring
        wireWidgets();
        setListeners();
        //construct game
        game = new BiggerNumberGame(0,100);
        //perform any setup before the user takes any action
        updateGameDisplay();
    }

    private void updateGameDisplay() {
        leftButton.setText(String.valueOf(game.getNumberLeft()));
        rightButton.setText(String.valueOf(game.getNumberRight()));
        scoreDisplayTextView.setText("Score: " + String.valueOf(game.getScore()));

    }

    private void setListeners() {
        //Creating an Anonymous Inner Class that implements View.OnClickListener()
        //Overriding the one abstract method onClick(View V)
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer = Integer.parseInt(leftButton.getText().toString());
                String message = game.checkAnswer(answer);
                Toast.makeText(MainActivity.this, message,
                        Toast.LENGTH_SHORT).show();
                flashColor(message);
                game.generateRandomNumbers();
                updateGameDisplay();
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer = Integer.parseInt(rightButton.getText().toString());
                String message = game.checkAnswer(answer);
                Toast.makeText(MainActivity.this, message,
                        Toast.LENGTH_SHORT).show();
                flashColor(message);
                game.generateRandomNumbers();
                updateGameDisplay();
            }
        });
    }

    private void flashColor(String message) {

        int red = 255;
        int blue = 255;
        int green = 255;
        final int shade = Color.rgb(red, blue ,green);

        if(message.equals("Correct!")) {
            int r = 50;
            int g = 205;
            int b = 50;
            int color = Color.rgb(r, g, b);
            constraintLayout.setBackgroundColor(color);
        }
        else {
            int r = 178;
            int g = 34;
            int b = 34;
            int color = Color.rgb(r, g, b);
            constraintLayout.setBackgroundColor(color);
        }

        new CountDownTimer(300,300){
            public void onFinish(){
                constraintLayout.setBackgroundColor(shade);
            }

            @Override
            public void onTick(long l) {

            }
        }.start();


    }

    private void wireWidgets() {
        scoreDisplayTextView = findViewById(R.id.textView_main_score);
        leftButton = findViewById(R.id.button_main_left);
        rightButton = findViewById(R.id.button_main_right);
        constraintLayout = findViewById(R.id.constraintLayout_main);

    }


}
