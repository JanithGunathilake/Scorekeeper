package com.example.scorekeeper

import android.R
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    // Member variables for holding the score.
    private var mScore1 = 0
    private var mScore2 = 0

    // Member variables for holding the score.
    private var mScoreText1: TextView? = null
    private var mScoreText2: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac)

        // Find the TextViews by ID.
        mScoreText1 = findViewById(R.id.score_1);
        mScoreText2 = findViewById(R.id.score_2);

    }

    /**
     * Method that handles the onClick of both the decrement buttons
     * @param view The button view that was clicked
     */
    fun decreaseScore(view: View) {
        // Get the ID of the button that was clicked.
        val viewID: Int = view.getId()
        when (viewID) {
            R.id.decreaseTeam1 -> {
                //Decrement the score and update the TextView
                mScore1--
                mScoreText1!!.text = mScore1.toString()
            }
            R.id.decreaseTeam2 -> {
                // Decrement the score and update the TextView
                mScore2--
                mScoreText2!!.text = mScore2.toString()
            }
        }
    }

    /**
     * Method that handles the onClick of both the increment buttons
     * @param view The button view that was clicked
     */
    fun increaseScore(view: View) {
        // Get the ID of the button that was clicked
        val viewID: Int = view.getId()
        when (viewID) {
            R.id.increaseTeam1 -> {
                // Increment the score and update the TextView
                mScore1++
                mScoreText1!!.text = mScore1.toString()
            }
            R.id.increaseTeam2 -> {
                // Increment the score and update the TextView
                mScore2++
                mScoreText2!!.text = mScore2.toString()
            }
        }
    }

}