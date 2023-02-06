package com.example.assignment3_task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        var order = intent.getParcelableExtra<OrderDetails>("order")

        if (order!=null){
            var hotelimg: ImageView = findViewById(R.id.imageVieworderbg)
            var hotelname: TextView = findViewById(R.id.textViewaptname)
            var roomtype: TextView = findViewById(R.id.textViewroomtype)
            var checkin: TextView = findViewById(R.id.textViewcheckindate)
            var checkout: TextView = findViewById(R.id.textViewcheckoutdate)
            var totalamt: TextView = findViewById(R.id.textViewtotalorder)

            hotelimg.setImageResource(order.image)
            hotelname.text = order.hotelname
            roomtype.text = "Room Type: ${order.roomtype}"
            checkin.text = "Check-In Date: ${order.checkindate}"
            checkout.text = "Check-Out Date: ${order.checkoutdate}"
            totalamt.text = "Total Amount: RM ${order.totalamt}"
        }
    }
}