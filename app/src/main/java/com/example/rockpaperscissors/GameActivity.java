package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button btnRock = findViewById(R.id.buttonRock);
        Button btnPaper = findViewById(R.id.buttonPaper);
        Button btnScissors = findViewById(R.id.buttonScissors);

        final TextView nWins = findViewById(R.id.winCount);
        final TextView nLosses = findViewById(R.id.lossCount);
        final TextView playerChoice = findViewById(R.id.playerChoice);
        final TextView opponentChoice = findViewById(R.id.opponentChoice);
        final TextView result = findViewById(R.id.result);

        // rock button
        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoice.setText("You chose rock.");
                int op = opponentsChoice(opponentChoice);
                evaluate(1, op, result, nWins, nLosses);
            }
        });

        // paper button
        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoice.setText("You chose paper.");
                int op = opponentsChoice(opponentChoice);
                evaluate(2, op, result, nWins, nLosses);
            }
        });

        // scissors button
        btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoice.setText("You chose scissors.");
                int op = opponentsChoice(opponentChoice);
                evaluate(3, op, result, nWins, nLosses);
            }
        });
    }

    private int opponentsChoice(TextView oc) {
        // pick number between 1 and 3
        int ran = new Random().nextInt(3) + 1;

        switch (ran) {
            case 1:
                oc.setText("Your opponent chose rock.");
                break;
            case 2:
                oc.setText("Your opponent chose paper.");
                break;
            case 3:
                oc.setText("Your opponent chose scissors.");
        }

        return ran;
    }

    private void evaluate(int p, int o, TextView r, TextView nw, TextView nl) {
        // tie
        if (p == o) {
            r.setText("It's a tie!");
            return;
        }

        // player chooses rock
        if (p == 1) {
            // opponent chooses paper
            if (o == 2) {
                r.setText("Opponent wins!");
                updateLosses(nl);
            }
            // opponent chooses scissors
            else {
                r.setText("You win!");
                updateWins(nw);
            }
        }

        // player chooses paper
        else if (p == 2) {
            // opponent chooses rock
            if (o == 1) {
                r.setText("You win!");
                updateWins(nw);
            }
            // opponent chooses scissors
            else {
                r.setText("Opponent wins!");
                updateLosses(nl);
            }
        }

        // player chooses scissors
        else {
            // opponent chooses rock
            if (o == 1) {
                r.setText("Opponent wins!");
                updateLosses(nl);
            }
            // opponent chooses paper
            else {
                r.setText("You win!");
                updateWins(nw);
            }
        }
    }

    private void updateLosses(TextView l) {
        int losses = Integer.valueOf(l.getText().toString()) + 1;
        l.setText(String.valueOf(losses));
    }

    private void updateWins(TextView w) {
        int wins = Integer.valueOf(w.getText().toString()) + 1;
        w.setText(String.valueOf(wins));
    }
}
