package com.example.rockpaperscissors


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.item_stats.view.*


class StatAdapter(private val stats: List<Stats>) : RecyclerView.Adapter<StatAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(stat: Stats) {
            itemView.tvWinLose.text = stat.winnaar

            if(stat.userHand == "rock"){
                itemView.ivCompHand.setImageResource(R.drawable.rock)
            }
            if(stat.userHand == "paper"){
                itemView.ivCompHand.setImageResource(R.drawable.paper)
            }
            if(stat.userHand == "scissors"){
                itemView.ivCompHand.setImageResource(R.drawable.scissors)
            }
            if(stat.computerHand == "rock"){
                itemView.ivCompHand.setImageResource(R.drawable.rock)
            }
            if(stat.computerHand == "paper"){
                itemView.ivCompHand.setImageResource(R.drawable.paper)
            }
            if(stat.computerHand == "scissors"){
                itemView.ivCompHand.setImageResource(R.drawable.scissors)
            }

        }
    }

    /**
     * Creates and returns a ViewHolder object, inflating the layout called item_reminder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_stats, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return stats.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(stats[position])
    }

}
