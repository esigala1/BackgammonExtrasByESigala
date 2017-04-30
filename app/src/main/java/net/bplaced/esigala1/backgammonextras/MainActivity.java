package net.bplaced.esigala1.backgammonextras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The "MainActivity" class is the entry point of the program.
 */
public class MainActivity extends AppCompatActivity {

    public static final String SCORE_A = "score_a";
    public static final String SCORE_B = "score_b";
    public static final String TAG_INFO = "Backgammon";

    int scoreTeamA;  // Keep score for Team A
    int scoreTeamB;  // Keep score for Team B

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // If there is no saved state, then...
        if (savedInstanceState == null) {
            // Initialize both scores to zero.
            scoreTeamA = 0;
            scoreTeamB = 0;
        }
        // There is a saved state, so restore it...
        else
        {
            scoreTeamA = savedInstanceState.getInt(SCORE_A);
            scoreTeamB = savedInstanceState.getInt(SCORE_B);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(TAG_INFO, "onSaveInstanceState()");
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE_A, scoreTeamA);
        outState.putInt(SCORE_B, scoreTeamB);
    }

    @Override
    protected void onResume() {
        Log.i(TAG_INFO, "onResume()");
        super.onResume();
        // Display score.
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
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