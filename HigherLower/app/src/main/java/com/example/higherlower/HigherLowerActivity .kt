package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class MainActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }



private fun initViews() {
    higherButton.setOnClickListener {
        rollDice()
        onHigherClick()
    }
    lowerButton.setOnClickListener {
        rollDice()
        onLowerClick()
    }
    equalButton.setOnClickListener {
        rollDice()
        onEqualClick()
    }
    updateUI()
}

private fun updateUI() {
    tvmidTxt.text = getString(R.string.midTxt, lastThrow)
    if (currentThrow == 1){
        diceImage.setImageResource(R.drawable.dice1)
    }
    if (currentThrow == 2){
        diceImage.setImageResource(R.drawable.dice2)
    }
    if (currentThrow == 3){
        diceImage.setImageResource(R.drawable.dice3)
    }
    if (currentThrow == 4){
        diceImage.setImageResource(R.drawable.dice4)
    }
    if (currentThrow == 5){
        diceImage.setImageResource(R.drawable.dice5)
    }
    if (currentThrow == 6){
        diceImage.setImageResource(R.drawable.dice6)
    }
}
    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick() {

        if (currentThrow >lastThrow){
            onAnswerCorrect()
        }
        else{
            onAnswerIncorrect()
        }

    }

    private fun onLowerClick() {

        if (currentThrow < lastThrow){
            onAnswerCorrect()
        }
        else{
            onAnswerIncorrect()
        }

    }

    private fun onEqualClick() {
        
        if (currentThrow == lastThrow){
            onAnswerCorrect()
            }
        else{
            onAnswerIncorrect()
        }

    }

    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct),
            Toast.LENGTH_LONG).show()

    }

    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect),
            Toast.LENGTH_LONG).show()

    }


}




