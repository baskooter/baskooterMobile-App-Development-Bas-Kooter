package com.example.rockpaperscissors

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var statRepository: StatRepository
    var hand = "Rock"
    var computerHand = "Paper"
    var randInt: Int = 1
    var win: Int = 0
    var lose: Int = 0
    var draw: Int = 0
    var winnaar: String = "x"
    var id: Long = 0
    private val mainScope = CoroutineScope(Dispatchers.Main)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        statRepository = StatRepository(this)


        rockButton.setOnClickListener{
            hand = "rock"
            handUserImage.setImageResource(R.drawable.rock)
            computerPick()




        }
        paperButton.setOnClickListener{
            hand = "paper"
            handUserImage.setImageResource(R.drawable.paper)
            computerPick()
        }
        scissorsButton.setOnClickListener{
            hand = "scissors"
            handUserImage.setImageResource(R.drawable.scissors)
            computerPick()
        }

        CoroutineScope(Dispatchers.Main).launch {
            statRepository.getAllStat()
        }
        initViews()

    }

    fun initViews(){
        getStatistics()
    }

    fun computerPick(){
        randInt = (1..3).random()
        updateUI()
    }

    fun updateUI() {

        if (randInt == 1) {
            handComputerImage.setImageResource(R.drawable.rock)
            computerHand = "rock"
        }
        if (randInt == 2) {
            handComputerImage.setImageResource(R.drawable.paper)
            computerHand = "paper"
        }
        if (randInt == 3) {
            handComputerImage.setImageResource(R.drawable.scissors)
            computerHand = "scissors"
        }
        if (hand == "paper") {
            if (computerHand == "paper") {
                tvWinner.text = "Draw!"
                draw += 1
                winnaar = "Draw!"
            }
            if (computerHand == "scissors") {
                tvWinner.text = "You lose!"
                lose += 1
                winnaar = "Computer wins!"
            }
            if (computerHand == "rock") {
                tvWinner.text = "You win!"
                win += 1
                winnaar = "Player wins!"
            }
        }
        if (hand == "rock") {
            if (computerHand == "rock") {
                tvWinner.text = "Draw!"
                draw += 1
                winnaar = "Draw!"
            }
            if (computerHand == "paper") {
                tvWinner.text = "You lose!"
                lose += 1
                winnaar = "Computer wins!"
            }
            if (computerHand == "scissors") {
                tvWinner.text = "You win!"
                win += 1
                winnaar = "Player wins!"
            }
        }
        if (hand == "scissors") {
            if (computerHand == "scissors") {
                tvWinner.text = "Draw!"
                draw += 1
                winnaar = "Draw!"
            }
            if (computerHand == "rock") {
                tvWinner.text = "You lose!"
                lose += 1
                winnaar = "Computer wins!"
            }
            if (computerHand == "paper") {
                tvWinner.text = "You win!"
                win += 1
                winnaar = "Player wins!"
            }
        }

        CoroutineScope(Dispatchers.Main).launch {

            val stat = Stats(
                winnaar = winnaar,
                userHand = hand,
                computerHand = computerHand
            )
            withContext(Dispatchers.IO) {
                statRepository.insertStat(stat)
            }
        }
        getStatistics()
    }
    private fun getStatistics() {

        CoroutineScope(Dispatchers.Main).launch {
                statRepository.getAllStat()
            }

        mainScope.launch {
            val countWin = withContext(Dispatchers.IO) {
                statRepository.countPlayerWin()
            }
            val countDraw = withContext(Dispatchers.IO) {
                statRepository.countDraw()
            }
            val countLose = withContext(Dispatchers.IO) {
                statRepository.countComputerWin()
            }

            tvStats.text = getString(R.string.statistics, countWin, countLose, countDraw)
        }
    }

            override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_show_history -> {
                openHistory()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun openHistory(){
        val intent = Intent(this, HistoryActivity::class.java)

        startActivity(intent)
    }



}

