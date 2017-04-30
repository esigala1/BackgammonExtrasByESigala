package net.bplaced.esigala1.backgammonextras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The "MainActivity" is the entry point of the program.
 */
public class MainActivity extends AppCompatActivity {

    public static final String SCORE_1 = "score_1";
    public static final String SCORE_2 = "score_2";
    public static final String TAG_INFO = "Backgammon";

    int scorePlayer1;  // Keep score for Player 1
    int scorePlayer2;  // Keep score for Player 2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // If there is no saved state, then...
        if (savedInstanceState == null) {
            // Initialize both scores to zero.
            scorePlayer1 = 0;
            scorePlayer2 = 0;
        }
        // There is a saved state, so restore it...
        else
        {
            scorePlayer1 = savedInstanceState.getInt(SCORE_1);
            scorePlayer2 = savedInstanceState.getInt(SCORE_2);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(TAG_INFO, "onSaveInstanceState()");
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE_1, scorePlayer1);
        outState.putInt(SCORE_2, scorePlayer2);
    }

    @Override
    protected void onResume() {
        Log.i(TAG_INFO, "onResume()");
        super.onResume();
        displayForPlayer1(scorePlayer1);  // Display score for Player 1
        displayForPlayer2(scorePlayer2);  // Display score for Player 2
    }

    /**
     * Increase the score for Player 1 by 1 point.
     */
    public void addOneForPlayer1(View v) {
        scorePlayer1++;
        displayForPlayer1(scorePlayer1);
    }

    /**
     * Increase the score for Player 1 by 2 points.
     */
    public void addTwoForPlayer1(View v) {
        scorePlayer1 = scorePlayer1 + 2;
        displayForPlayer1(scorePlayer1);
    }

    /**
     * Increase the score for Player 1 by 3 points.
     */
    public void addThreeForPlayer1(View v) {
        scorePlayer1 = scorePlayer1 + 3;
        displayForPlayer1(scorePlayer1);
    }

    /**
     * Displays the given score for Player 1.
     * @param score is the given score
     */
    public void displayForPlayer1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Player 2 by 1 point.
     */
    public void addOneForPlayer2(View v) {
        scorePlayer2++;
        displayForPlayer2(scorePlayer2);
    }

    /**
     * Increase the score for Player 2 by 2 points.
     */
    public void addTwoForPlayer2(View v) {
        scorePlayer2 = scorePlayer2 + 2;
        displayForPlayer2(scorePlayer2);
    }

    /**
     * Increase the score for Player 2 by 3 points.
     */
    public void addThreeForPlayer2(View v) {
        scorePlayer2 = scorePlayer2 + 3;
        displayForPlayer2(scorePlayer2);
    }

    /**
     * Displays the given score for Player 2.
     * @param score is the given score
     */
    public void displayForPlayer2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Reset the Score for both Players.
     */
    public void resetScore(View view){
        // If both scores are zero, then...
        if (scorePlayer1 == 0 && scorePlayer2 == 0){
            // Display a toast message
            Toast.makeText(this, getResources().getString(R.string.lets_play), Toast.LENGTH_SHORT).show();
            // Terminate the current method.
            return;
        }
        // Initialize scores.
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        // Display the scores.
        displayForPlayer1(scorePlayer1);
        displayForPlayer2(scorePlayer2);
        // Display a toast message
        Toast.makeText(this, getResources().getString(R.string.reset_score), Toast.LENGTH_SHORT).show();
    }
}