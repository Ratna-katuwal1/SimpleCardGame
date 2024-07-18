package com.ratna.labsheettwo;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView redCardValue, lifeValue, blackCardValue, resultTextView;
    ImageView redCardImage, blackCardImage;
    Button playButton, resetButton;
    int redCardScore = 0;
    int blackCardScore = 0;
    int life = 3;
    int drawCount = 0;
    Random random;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        redCardValue = findViewById(R.id.redCardValue);
        lifeValue = findViewById(R.id.lifeValue);
        blackCardValue = findViewById(R.id.blackCardValue);
        resultTextView = findViewById(R.id.resultTextView);
        redCardImage = findViewById(R.id.redCardImage);
        blackCardImage = findViewById(R.id.blackCardImage);
        playButton = findViewById(R.id.playButton);
        resetButton = findViewById(R.id.resetButton);
        random = new Random();
        handler = new Handler();

        playButton.setOnClickListener(view -> {
            playGame();
        });

        resetButton.setOnClickListener(view -> {
            resetGame();
        });
    }

    private void playGame() {
        int redCard = random.nextInt(13) + 1;
        int blackCard = random.nextInt(13) + 1;

        redCardImage.setImageResource(getResources().getIdentifier("red" + redCard, "drawable", getPackageName()));
        blackCardImage.setImageResource(getResources().getIdentifier("black" + blackCard, "drawable", getPackageName()));

        if (redCard > blackCard) {
            redCardScore++;
            redCardValue.setText(String.valueOf(redCardScore));
        } else if (blackCard > redCard) {
            blackCardScore++;
            blackCardValue.setText(String.valueOf(blackCardScore));
        } else {
            drawCount++;
            life--;
            lifeValue.setText(String.valueOf(life));
            if (life <= 0) {
                displayResult();
                return;
            }
        }
        lifeValue.setText(String.valueOf(life));
        if (life <= 0) {
            displayResult();
        }
    }

    private void displayResult() {
        String result;
        if (redCardScore > blackCardScore) {
            result = "Red Card Won the game by " + redCardScore + "points";
        } else if (blackCardScore > redCardScore) {
            result = "Black Card Won the game by " + blackCardScore + "points";
        } else {
            result = "the game is draw";
        }
        resultTextView.setText(result);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                resetGame();
            }
        }, 5000);
    }

    private void resetGame() {
        redCardScore = 0;
        blackCardScore = 0;
        life = 3;
        drawCount = 0;
        redCardValue.setText(String.valueOf(redCardScore));
        blackCardValue.setText(String.valueOf(blackCardScore));
        lifeValue.setText(String.valueOf(life));
        resultTextView.setText("");
        redCardImage.setImageResource(R.drawable.red0);
        blackCardImage.setImageResource(R.drawable.black0);
    }
}