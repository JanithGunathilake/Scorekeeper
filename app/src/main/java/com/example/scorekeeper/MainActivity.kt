package com.example.scorekeeper

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    // Member variables for holding the score.
    private var mScore1: Int = 0
    private var mScore2: Int = 0


    // Member variables for holding the score.
    private lateinit var mScoreText1: TextView
    private lateinit var mScoreText2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the TextViews by ID.
        mScoreText1 = findViewById(R.id.score_1) as TextView
        mScoreText2 = findViewById(R.id.score_2) as TextView


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


}