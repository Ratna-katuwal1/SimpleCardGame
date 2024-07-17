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

        });

        resetButton.setOnClickListener(view -> {

        });
    }

    private void playGame(){
        int redCardValue = random.nextInt(13) + 1;
        int blackCardValue = random.nextInt(13) + 1;

    }
}