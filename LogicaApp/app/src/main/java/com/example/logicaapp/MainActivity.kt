package com.example.logicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        confBut.setOnClickListener {
            checkAnswer()
        }

    }
    private fun checkAnswer(){
        val answer1 = ansEen.text.toString()
        val answer2 = ansTwee.text.toString()
        val answer3 = ansDrie.text.toString()
        val answer4 = ansVier.text.toString()
        var ansGoed = 0

        if (answer1 == "T"){
            ansGoed += 1
        }
        if (answer2=="F"){
            ansGoed += 1
        }
        if (answer3=="F"){
            ansGoed += 1
        }
        if (answer4=="F"){
            ansGoed += 1
        }
            Toast.makeText(this, getString(R.string.incorrect, ansGoed),
                Toast.LENGTH_LONG).show()
    }
}
