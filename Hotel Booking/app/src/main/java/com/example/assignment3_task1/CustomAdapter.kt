package com.example.assignment3_task1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private var HotelDetails:ArrayList<Details>):RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    var onItemClick : ((Details) -> Unit)? = null

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imghotel = itemView.findViewById<ImageView>(R.id.heritage_image)
        val txtName = itemView.findViewById<TextView>(R.id.heritage_text)
//        val imgloc = itemView.findViewById<ImageView>(R.id.heritage_loc)
        val txtloc = itemView.findViewById<TextView>(R.id.heritage_loctext)
//        val imgrate = itemView.findViewById<TextView>(R.id.heritage_rate)
        val txtrate = itemView.findViewById<TextView>(R.id.heritage_ratetext)
        val txtprice = itemView.findViewById<TextView>(R.id.heritage_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val details= HotelDetails.get(position)
        if (details.name.equals("Heritage Apartment")){
            holder.imghotel.setImageResource(R.drawable.room1_icon)
        }else if (details.name.equals("Ameron Hotel")){
            holder.imghotel.setImageResource(R.drawable.room2_icon)
        }else if (details.name.equals("Dorsett Studio Apartment")){
            holder.imghotel.setImageResource(R.drawable.room3_icon)
        }else if (details.name.equals("Travelodge Harbourfront")){
            holder.imghotel.setImageResource(R.drawable.room4_icon)
        }
        else if (details.name.equals("Clover Apartment")){
            holder.imghotel.setImageResource(R.drawable.room5_icon)
        }else if (details.name.equals("Wonderloft Hostel")){
            holder.imghotel.setImageResource(R.drawable.room6_icon)
        }

        holder.txtName.setText(details.name)
        holder.txtloc.setText(details.area)
        holder.txtrate.setText(details.stars)

        val roomtypesarr = details.roomtypes.split(",").toTypedArray()
        val roomtypesselarr = roomtypesarr.last()
        val roompricearr =roomtypesselarr.split("-").toTypedArray()
        holder.txtprice.setText(roompricearr[1])


        holder.itemView.setOnClickListener{
            onItemClick?.invoke(details)
        }

    }
    override fun getItemCount(): Int {
        return HotelDetails.size
    }
}