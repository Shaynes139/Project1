package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val wordToGuess = FourLetterWordList.getRandomFourLetterWord()
    private var guessedCorrectly = false
    var guessCount = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val Guess1 = findViewById<TextView>(R.id.Guess1)
        val Guess1Check = findViewById<TextView>(R.id.Guess1Check)
        val Guess2 = findViewById<TextView>(R.id.Guess2)
        val Guess2Check = findViewById<TextView>(R.id.Guess2Check)
        val Guess3 = findViewById<TextView>(R.id.Guess3)
        val Guess3Check = findViewById<TextView>(R.id.Guess3Check)
        val userInput = findViewById<EditText>(R.id.userInput)

        val  Answer = findViewById<TextView>(R.id.Answer)

        button.setOnClickListener {
            guessCount++
            val userGuess = userInput.text.toString()

            if (guessCount == 1){
                Guess1.text = userGuess
                Guess1Check.text = checkGuess(userGuess)
            }
            else if (guessCount == 2){
                Guess2.text = userGuess
                Guess2Check.text = checkGuess(userGuess)
            }
            else if (guessCount == 3){
                Guess3.text = userGuess
                Guess3Check.text = checkGuess(userGuess)
                if (userGuess == wordToGuess){
                    guessedCorrectly = true


                }
            }
            userInput.text.clear()
            if (guessCount ==3 && !guessedCorrectly){
                Answer.text = wordToGuess
            }
        }
    }
    private fun checkGuess(guess: String): String {
    var result = ""
    for (i in 0..3) {
        if (guess[i] == wordToGuess[i]) {
            result += "O"
        } else if (guess[i] in wordToGuess) {
            result += "+"
        } else {
            result += "X"
        }
    }
    return result
}
}