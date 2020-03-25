package com.example.studentportal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*


class PortalAdapter(private val portals: List<UserPortal>, val clickListener: (UserPortal) -> Unit) : RecyclerView.Adapter<PortalAdapter.ViewHolder>()  {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(portal: UserPortal, clickListener: (UserPortal) -> Unit ) {
            itemView.tvTitle.text = portal.title
            itemView.tvUrl.text = portal .url
            itemView.setOnClickListener { clickListener(portal)}
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return portals.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(portals[position], clickListener)
    }

}
