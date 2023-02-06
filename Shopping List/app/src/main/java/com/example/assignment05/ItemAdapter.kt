package com.example.assignment05

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*


class itemadapter(private val Items: ArrayList<items>):RecyclerView.Adapter<itemadapter.ViewHolder>(){

    var onItemClick : ((items) -> Unit)? = null
    var onItemLongClick : ((items) -> Unit)? = null
    private lateinit var context: Context

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val img = itemView.findViewById<ImageView>(com.example.assignment05.R.id.imageViewUrgent)
        val itemname = itemView.findViewById<TextView>(com.example.assignment05.R.id.textViewitemname)
        val qty = itemView.findViewById<TextView>(com.example.assignment05.R.id.textViewqty)
        val size = itemView.findViewById<TextView>(com.example.assignment05.R.id.textViewsize)
        val switch = itemView.findViewById<Switch>(com.example.assignment05.R.id.switchbought)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.assignment05.R.layout.homelayout,parent,false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val details= Items.get(position)

        holder.img.setImageResource(details.img)
        holder.itemname.text = details.name
        holder.qty.text = details.quantity
        holder.size.text = details.size

        val dbHelper = DBHelper(context)

        holder.switch.setOnClickListener(){
            if (holder.switch.isChecked){
                val activity = it.context as AppCompatActivity
                val calendar: Calendar = Calendar.getInstance()
                val formattime = SimpleDateFormat("dd MMM yyyy")
                val time: String = formattime.format(calendar.getTime())
                println("Time: $time")
                details.bought = time
                println("Bought: ${details.bought}")
                details.img = com.example.assignment05.R.drawable.bought
                dbHelper.updateitems(details)

                val fragment= activity.supportFragmentManager.beginTransaction()
                fragment.replace(com.example.assignment05.R.id.container, Fragment_Home()).commit()
                fragment.addToBackStack(null)
            }
        }

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(details)
        }

        holder.itemView.setOnLongClickListener{
            onItemLongClick?.invoke(details)
            return@setOnLongClickListener true
        }

    }

    override fun getItemCount(): Int {
        return Items.size
    }

}