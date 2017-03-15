package net.bplaced.esigala1.backgammonextras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increase the score for Player 1 by 1 point.
     */
    public void addOneForPlayer1(View v) {
        scoreTeamA++;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Player 1 by 2 points.
     */
    public void addTwoForPlayer1(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Player 1 by 3 points.
     */
    public void addThreeForPlayer1(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Displays the given score for Player 1.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Player 2 by 1 point.
     */
    public void addOneForPlayer2(View v) {
        scoreTeamB++;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Player 2 by 2 points.
     */
    public void addTwoForPlayer2(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Player 2 by 3 points.
     */
    public void addThreeForPlayer2(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Player 2.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Reset the Score for both Teams.
     */
    public void resetScore(View view){
        if (scoreTeamA == 0 && scoreTeamB == 0){
            // Display a toast message
            Toast.makeText(this, getResources().getString(R.string.lets_play), Toast.LENGTH_SHORT).show();
            // Terminate the current method.
            return;
        }
        // Initialize scores.
        scoreTeamA = 0;
        scoreTeamB = 0;
        // Display the scores.
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        // Display a toast message
        Toast.makeText(this, getResources().getString(R.string.reset_score), Toast.LENGTH_SHORT).show();
    }

}
