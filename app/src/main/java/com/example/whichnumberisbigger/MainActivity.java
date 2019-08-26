package com.example.whichnumberisbigger;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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


    }

    private void wireWidgets() {
        game = new BiggerNumberGame(1,90);
        scoreDisplayTextView = findViewById(R.id.textView_main_score);
        leftButton = findViewById(R.id.button_main_left);
        rightButton = findViewById(R.id.button_main_right);
        constraintLayout = findViewById(R.id.constraintLayout_main);

    }


}
