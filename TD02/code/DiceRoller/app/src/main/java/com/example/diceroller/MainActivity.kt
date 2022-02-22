package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var rollDiceButton: Button = findViewById(R.id.roll_the_dice_button)
        rollDiceButton.setOnClickListener { rollDice() }
        lateinit var diceImage : ImageView
        diceImage = findViewById(R.id.dice_image)
        diceImage.setOnClickListener { rollDice() }
        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { countUp() }
    }

    private fun rollDice() {
        val randomInt = (1..6).random()

        val diceImage : ImageView = findViewById(R.id.dice_image)
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }

    private fun countUp() {
//        val resultInt: TextView = findViewById(R.id.result_text)
//        resultInt.setText("${resultInt.text.toString().toInt() + 1}")

//        val resultText: TextView = findViewById(R.id.result_text)
//
//        // If text is the default "Hello World!" set that text to 1.
//        if (resultText.text == "Hello World!") {
//            resultText.text = "1"
//        } else {
//            // Otherwise, increment the number up to 6.
//            // The text value in resultText.text is an instance of the CharSequence class;
//            // it needs to be converted to a String object before it can be converted to an int.
//            var resultInt = resultText.text.toString().toInt()
//
//            if (resultInt < 6) {
//                resultInt++
//                resultText.text = resultInt.toString()
//            }
//        }
    }
}