package com.example.wordle

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

//the game layout is inspired by this video https://www.geeksforgeeks.org/videos/how-to-build-wordle-application-in-android/

class MainActivity : AppCompatActivity() {
    private val wordList = WordList()  //read-only property of WordList class
    private var letterArray: Array<String>? = Array(5) {""} //string array that stores each letter of generated word
    private var countCheckPressed = 0 //value that counts times when button "Check" is pressed
    private var getRandomWord = "" //randomly generated word from randomWord() function
    private val txt1IDs = listOf(R.id.et11, R.id.et12, R.id.et13, R.id.et14, R.id.et15) //six read-only lists that contain EditText field ID for each input letter
    private val txt2IDs = listOf(R.id.et21, R.id.et22, R.id.et23, R.id.et24, R.id.et25)
    private val txt3IDs = listOf(R.id.et31, R.id.et32, R.id.et33, R.id.et34, R.id.et35)
    private val txt4IDs = listOf(R.id.et41, R.id.et42, R.id.et43, R.id.et44, R.id.et45)
    private val txt5IDs = listOf(R.id.et51, R.id.et52, R.id.et53, R.id.et54, R.id.et55)
    private val txt6IDs = listOf(R.id.et61, R.id.et62, R.id.et63, R.id.et64, R.id.et65)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWordForGame() //new word gets generated

        for (id in txt1IDs) { //first word's letter boxes are being enabled
            val editText = findViewById<EditText>(id)
            editText.isEnabled = true
        }

        val buttonCheck = findViewById<Button>(R.id.button_check)
        buttonCheck.setOnClickListener {  //button listener is added to the "Check" button
            checkButtonClick()
        }

        val buttonNewGame = findViewById<Button>(R.id.button_newgame)
        buttonNewGame.setOnClickListener {  //button listener is added to the "New Game" button
            newGameButtonClick()
        }
    }

    private fun checkButtonClick() {
        check()
    }

    private fun newGameButtonClick() {
        resetGame()
    }

    private fun check(){ //each letter is checked - if letter is in its right place, the box turns green, if it's in the word, but not the right place, box turns yellow
        countCheckPressed++ //value "countCheckPressed" counts the times, when button "Check" is being pressed, to check the correct line of letters
        var greenCount = 0 //value "greenCount" counts how many letters in word are in the right place
        if (countCheckPressed == 1) {
            for ((index, id) in txt1IDs.withIndex()) { //in this 'for' the loop iterates through each letter in the correct line and makes any changes if necessary
                val editText = findViewById<EditText>(id)
                val editTextString = editText.text.toString().lowercase()
                val letterFromArray = letterArray?.getOrNull(index)

                if (editTextString == letterFromArray) { //in this 'if' the boxes are getting their color, if letter meets any of the criteria
                    editText.setBackgroundColor(Color.GREEN)
                    greenCount++
                } else if (letterArray?.contains(editTextString)==true) {
                    editText.setBackgroundColor(Color.YELLOW)
                }

                editText.isEnabled = false //all letter boxes in first line are disabled, because the word has been checked already
            }
            for (id in txt2IDs) { //all letter boxes in second line are enabled, because it's the next line, where user will input letters
                val editText = findViewById<EditText>(id)
                editText.isEnabled = true
            }
        } else if (countCheckPressed == 2) { //next five 'if' repeat the same thing, but with corresponding lines
            for ((index, id) in txt2IDs.withIndex()) {
                val editText = findViewById<EditText>(id)
                val editTextString = editText.text.toString().lowercase()
                val letterFromArray = letterArray?.getOrNull(index)

                if (editTextString == letterFromArray) {
                    editText.setBackgroundColor(Color.GREEN)
                    greenCount++
                } else if (letterArray?.contains(editTextString)==true) {
                    editText.setBackgroundColor(Color.YELLOW)
                }

                editText.isEnabled = false
            }
            for (id in txt3IDs) {
                val editText = findViewById<EditText>(id)
                editText.isEnabled = true
            }
        } else if (countCheckPressed == 3) {
            for ((index, id) in txt3IDs.withIndex()) {
                val editText = findViewById<EditText>(id)
                val editTextString = editText.text.toString().lowercase()
                val letterFromArray = letterArray?.getOrNull(index)

                if (editTextString == letterFromArray) {
                    editText.setBackgroundColor(Color.GREEN)
                    greenCount++
                } else if (letterArray?.contains(editTextString)==true) {
                    editText.setBackgroundColor(Color.YELLOW)
                }

                editText.isEnabled = false
            }
            for (id in txt4IDs) {
                val editText = findViewById<EditText>(id)
                editText.isEnabled = true
            }
        } else if (countCheckPressed == 4) {
            for ((index, id) in txt4IDs.withIndex()) {
                val editText = findViewById<EditText>(id)
                val editTextString = editText.text.toString().lowercase()
                val letterFromArray = letterArray?.getOrNull(index)

                if (editTextString == letterFromArray) {
                    editText.setBackgroundColor(Color.GREEN)
                    greenCount++
                } else if (letterArray?.contains(editTextString)==true) {
                    editText.setBackgroundColor(Color.YELLOW)
                }

                editText.isEnabled = false
            }
            for (id in txt5IDs) {
                val editText = findViewById<EditText>(id)
                editText.isEnabled = true
            }
        } else if (countCheckPressed == 5) {
            for ((index, id) in txt5IDs.withIndex()) {
                val editText = findViewById<EditText>(id)
                val editTextString = editText.text.toString().lowercase()
                val letterFromArray = letterArray?.getOrNull(index)

                if (editTextString == letterFromArray) {
                    editText.setBackgroundColor(Color.GREEN)
                    greenCount++
                } else if (letterArray?.contains(editTextString)==true) {
                    editText.setBackgroundColor(Color.YELLOW)
                }

                editText.isEnabled = false
            }
            for (id in txt6IDs) {
                val editText = findViewById<EditText>(id)
                editText.isEnabled = true
            }
        } else if (countCheckPressed == 6) {
            for ((index, id) in txt6IDs.withIndex()) {
                val editText = findViewById<EditText>(id)
                val editTextString = editText.text.toString().lowercase()
                val letterFromArray = letterArray?.getOrNull(index)

                if (editTextString == letterFromArray) {
                    editText.setBackgroundColor(Color.GREEN)
                    greenCount++
                } else if (letterArray?.contains(editTextString)==true) {
                    editText.setBackgroundColor(Color.YELLOW)
                }

                editText.isEnabled = false
            }
            if (greenCount != 5) { //in case, at the end of the game, user hasn't been able to guess the word, game outputs message "You lost!" and the correct answer
                val textYouWinLose = findViewById<TextView>(R.id.youWinLose)
                "You lost! The word was $getRandomWord".also { textYouWinLose.text = it }
            }
        }
        if (greenCount == 5) { //if, at any point in the game, user has been able to guess the word, game outputs message "You guessed the word!"
            val textYouWinLose = findViewById<TextView>(R.id.youWinLose)
            "You guessed the word!".also { textYouWinLose.text = it }

            val txtIDs = txt1IDs + txt2IDs + txt3IDs + txt4IDs + txt5IDs + txt6IDs

            for (id in txtIDs) { //all of the fields will get disabled after user has guessed the word
                val editText = findViewById<EditText>(id)
                editText.isEnabled = false
            }
        }
    }

    private fun resetGame () { //function that resets all game fields to the very first game state, when it's being created
        val txtIDs = txt1IDs + txt2IDs + txt3IDs + txt4IDs + txt5IDs + txt6IDs

        for (txtID in txtIDs) { //in this 'for' all letters are removed from EditText boxes, the background is set white again and first line of boxes are enabled
            val editText = findViewById<EditText>(txtID)
            editText.text.clear()
            editText.setBackgroundColor(Color.WHITE)
            if (txtID in txt1IDs) {
                editText.isEnabled = true
            }
        }
        countCheckPressed = 0 //counter value for button "Check" is reset to 0

        val textYouWinLose = findViewById<TextView>(R.id.youWinLose)
        textYouWinLose.text = "" //text is removed from the win or lose announcement

        getWordForGame() //new word gets generated
    }

    private fun getWordForGame () { //a word gets generated and then separated into letters and those letters are then stored into an array
        getRandomWord = wordList.randomWord()

        val letters = getRandomWord.toCharArray()
        for (i in letters.indices) {
            letterArray!![i] = letters[i].toString()
        }
    }
}