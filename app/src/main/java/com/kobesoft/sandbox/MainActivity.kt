/**
 * @author Lenny Ramos
 */

package com.kobesoft.sandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var rollButton: Button
    private lateinit var countUpButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    /**
     * Creates a toast on roll dice button click
     */
    private fun rollDice() {
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()

        resultText.text = randomNumber().toString()
    }

    /**
     * Gets a number between 1-6
     */
    private fun randomNumber(): Int {
        return Random().nextInt(6) + 1
    }


    /**
     * adds 1 to the current roll if less than 6 and
     * has at least rolled once
     */
    private fun countUp() {
        when (val number: Int? = resultText.text.toString().toIntOrNull()) {
            null -> resultText.text = "1"
            6 -> Toast.makeText(this, "already the max roll", Toast.LENGTH_SHORT).show()
            else -> resultText.text = (number + 1).toString()
        }
    }

    /**
     * Initialize the views refs
     */
    private fun initialize() {
        rollButton = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        countUpButton = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { countUp() }

        resultText = findViewById(R.id.dice_roll_result)
    }
}
