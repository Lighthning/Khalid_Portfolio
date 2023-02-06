package com.example.assignment04_task01

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class itemadapter(private val Items: ArrayList<Items>):RecyclerView.Adapter<itemadapter.ViewHolder>(){

    var onItemClick : ((Items) -> Unit)? = null
    private lateinit var context: Context

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imgitem = itemView.findViewById<ImageView>(R.id.imageViewitem)
        val txtName = itemView.findViewById<TextView>(R.id.textViewitem)
        val txtprocessor = itemView.findViewById<TextView>(R.id.textViewProcessor)
        val txtstorage = itemView.findViewById<TextView>(R.id.textViewStorage)
        val txtcamera = itemView.findViewById<TextView>(R.id.textViewCamera)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_layout,parent,false)
        context = parent.context
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val details= Items.get(position)
        val resources = context.resources
        val resourceID: Int = resources.getIdentifier(details.image, "drawable", context.packageName)

        holder.imgitem.setImageResource(resourceID)
        holder.txtName.setText(details.name)
        holder.txtprocessor.setText(details.processor)
        holder.txtstorage.setText(details.storage)
        holder.txtcamera.setText(details.camera)


        holder.itemView.setOnClickListener{
            onItemClick?.invoke(details)
        }

    }

    override fun getItemCount(): Int {
        return Items.size
    }

}