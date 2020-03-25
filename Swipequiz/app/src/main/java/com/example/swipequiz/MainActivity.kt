package com.example.swipequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_place.*

class MainActivity : AppCompatActivity() {
    private val questionsList = arrayListOf<Questions>()
    private val questionAdapter = QuestionAdapter(questionsList, {question : Questions -> questionClicked(question)})
    var posAns1 = 0
    var posAns2 = 1
    var posAns3 = 2
    var posAns4 = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        rvQuestions.adapter = questionAdapter

    }

    fun initViews() {
        for (i in Questions.QUESTIONS_CLASS.indices) {
            rvQuestions.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)

            questionsList.add(
                Questions(
                    Questions.QUESTIONS_CLASS[i]
                )
            )
        }
        createItemTouchHelper().attachToRecyclerView(rvQuestions)

    }

    private fun questionClicked(question : Questions){
        if (question.question == "A val and var are the same." || question.question ==  "In kotlin, when replaces the switch operator in java."){
            Toast.makeText(this, "Deze vraag is incorrect", Toast.LENGTH_LONG).show()
        }
        if (question.question == "Mobile applications grants 12 ETCs." || question.question ==  "A unit in kotlin corresponds to a void in java."){
            Toast.makeText(this, "Deze vraag is correct", Toast.LENGTH_LONG).show()
        }

    }
    private fun createItemTouchHelper(): ItemTouchHelper {

        // Callback which is used to create the ItemTouch helper. Only enables left swipe.
        // Use ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) to also enable right swipe.
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            // Enables or Disables the ability to move items up and down.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition


                    if (direction == ItemTouchHelper.LEFT) {
                        if (position == posAns1 || position == posAns4) {
                            questionsList.removeAt(position)

                            if (position == posAns1){
                                posAns1 = 10
                                posAns2 = posAns2 - 1
                                posAns3 = posAns3 - 1
                                posAns4 = posAns4 -1
                            }
                            if (position == posAns4){
                                posAns4 = 10
                            }
                            questionAdapter.notifyDataSetChanged()
                        }
                        if(position == posAns2 || position == posAns3){
                            questionAdapter.notifyDataSetChanged()
                        }

                    }
                if (direction == ItemTouchHelper.RIGHT) {
                    if (position == posAns2 || position == posAns3) {
                        questionsList.removeAt(position)

                        if (position == posAns2){
                            posAns2 = 10
                            posAns3 = posAns3 - 1
                            posAns4 = posAns4 - 1
                        }
                        if (position == posAns3){
                            posAns3 = 10
                            posAns4 = posAns4 - 1
                        }
                        questionAdapter.notifyDataSetChanged()
                    }
                    if(position == posAns1 || position == posAns4){
                        questionAdapter.notifyDataSetChanged()
                    }
                    }
            }




        }

        return ItemTouchHelper(callback)
    }


}
