package com.example.swipequiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_place.view.*

class QuestionAdapter(private val questionList: List<Questions>, val clickListener: (Questions) -> Unit) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(question: Questions, clickListener: (Questions) -> Unit ){
            itemView.tvQuestions.text = question.question
            itemView.setOnClickListener { clickListener(question)}
        }



    }
    override fun getItemCount(): Int {
        return questionList.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false)
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(questionList[position], clickListener)
    }
}