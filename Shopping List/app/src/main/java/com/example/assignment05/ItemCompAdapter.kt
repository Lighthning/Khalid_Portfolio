package com.example.assignment05

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class ItemCompadapter(private val Items: ArrayList<items>):RecyclerView.Adapter<ItemCompadapter.ViewHolder>(){
    private lateinit var context: Context

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val img = itemView.findViewById<ImageView>(com.example.assignment05.R.id.imageViewUrgent)
        val itemname = itemView.findViewById<TextView>(com.example.assignment05.R.id.textViewitemname)
        val qty = itemView.findViewById<TextView>(com.example.assignment05.R.id.textViewqty)
        val size = itemView.findViewById<TextView>(com.example.assignment05.R.id.textViewsize)
        val date = itemView.findViewById<TextView>(com.example.assignment05.R.id.textViewDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.assignment05.R.layout.complayout,parent,false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val details= Items.get(position)

        holder.img.setImageResource(details.img)
        holder.itemname.text = details.name
        holder.qty.text = details.quantity
        holder.size.text = details.size
        holder.date.text = details.bought
    }

    override fun getItemCount(): Int {
        return Items.size
    }

}