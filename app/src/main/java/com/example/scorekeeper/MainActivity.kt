package com.example.scorekeeper

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity() {

    // Member variables for holding the score.
    private var mScore1: Int = 0
    private var mScore2: Int = 0

    val STATE_SCORE_1: String = "Team 1 Score"
    val STATE_SCORE_2: String = "Team 2 Score"



    // Member variables for holding the score.
    private lateinit var mScoreText1: TextView
    private lateinit var mScoreText2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the TextViews by ID.
        mScoreText1 = findViewById(R.id.score_1) as TextView
        mScoreText2 = findViewById(R.id.score_2) as TextView

        savedInstanceState?.run {
            mScore1 = getInt(STATE_SCORE_1)
            mScore2 = getInt(STATE_SCORE_2)

            // Set the score text views.
            mScoreText1.text = mScore1.toString()
            mScoreText2.text = mScore2.toString()
        }

    }


    /**
     * Method that handles the onClick of both the decrement buttons
     * @param view The button view that was clicked
     */
    fun decreaseScore(view: View) {
        // Get the ID of the button that was clicked.
        val viewID = view.id
        when (viewID) {
            // If it was on Team 1
            R.id.decreaseTeam1 -> {
                // Decrement the score and update the TextView
                mScore1--
                mScoreText1.text = mScore1.toString()
            }
            // If it was Team 2
            R.id.decreaseTeam2 -> {
                // Decrement the score and update the TextView
                mScore2--
                mScoreText2.text = mScore2.toString()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        var nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            if (menu != null) {
                menu.findItem(R.id.night_mode).setTitle(R.string.day_mode)
            };
        } else {
            if (menu != null) {
                menu.findItem(R.id.night_mode).setTitle(R.string.night_mode)
            };
        }
        return true;
    }

    /**
     * Method that handles the onClick of both the increment buttons
     * @param view The button view that was clicked
     */
    fun increaseScore(view: View) {
        // Get the ID of the button that was clicked
        val viewID = view.id
        when (viewID) {
            // If it was on Team 1
            R.id.increaseTeam1 -> {
                // Increment the score and update the TextView
                mScore1++
                mScoreText1.text = mScore1.toString()
            }
            // If it was Team 2
            R.id.increaseTeam2 -> {
                // Increment the score and update the TextView
                mScore2++
                mScoreText2.text = mScore2.toString()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Check if the correct item was clicked
        if (item.itemId == R.id.night_mode) {
            // Get the night mode state of the app.
            val nightMode = AppCompatDelegate.getDefaultNightMode()
            // Set the theme mode for the restarted activity.
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            // Recreate the activity for the theme change to take effect.
            recreate()
        }

        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save the scores.
        outState.putInt(STATE_SCORE_1, mScore1)
        outState.putInt(STATE_SCORE_2, mScore2)
        super.onSaveInstanceState(outState)
    }




}