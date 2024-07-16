package com.ratna.labsheettwo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView blackCard, redCard;
    Button reset, play;
    TextView msgTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        blackCard = findViewById(R.id.blackCard);
        redCard = findViewById(R.id.redCard);
        reset = findViewById(R.id.reset);
        play = findViewById(R.id.btn);
        msgTextView = findViewById(R.id.draw);

        play.setOnClickListener(view -> {
            int blackNum = randomNumber();
            int redNum = randomNumber();
            int resource1 = getResources().getIdentifier("black" + blackNum, "drawable", getPackageName());
            blackCard.setImageResource(resource1);
            int resource2 = getResources().getIdentifier("red" + redNum, "drawable", getPackageName());
            redCard.setImageResource(resource2);
            checkWin(blackNum, redNum);
        });

        reset.setOnClickListener(view -> reset());
    }

    private int randomNumber() {
        Random randomNum = new Random();
        return randomNum.nextInt(13);
    }

    private void checkWin(int blackNum, int redNum) {
        String result;
        if (blackNum > redNum) {
            result = "Black Wins!";
        } else if (blackNum < redNum) {
            result = "Red Wins!";
        } else {
            result = "Draw!";
        }
        msgTextView.setText(result);
    }

    private void reset() {
        blackCard.setImageResource(R.drawable.black0);
        redCard.setImageResource(R.drawable.red0);
        msgTextView.setText("");
    }
}