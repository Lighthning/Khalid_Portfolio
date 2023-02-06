package com.example.assignment05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val display = intent.getParcelableExtra<items>("display")
        if (display != null){
            val itemname = findViewById<TextView>(R.id.textViewdisplayitem)
            val itemdetails = findViewById<TextView>(R.id.textViewdisplaydetail)
            val qty = findViewById<TextView>(R.id.textViewdisplayqty)
            val size = findViewById<TextView>(R.id.textViewdisplaysize)
            val urgimg = findViewById<ImageView>(R.id.imageViewdisplayurg)
            val editimg = findViewById<ImageView>(R.id.imageViewEditbtn)

            val qtyfinal = display.quantity.substringAfterLast(":")
            val sizefinal = display.size.substringAfterLast(":")

            itemname.text = display.name
            itemdetails.text = display.detail
            qty.text = qtyfinal
            size.text = sizefinal
            if (display.img == R.drawable.urgent){
                urgimg.setImageResource(R.drawable.checked)
            }else{
                urgimg.setImageResource(R.drawable.unchecked)
            }
            editimg.setOnClickListener(){
                val intent = Intent(this, MainActivity4::class.java)
                intent.putExtra("Edit", display)
                startActivity(intent)
            }
        }
    }
}