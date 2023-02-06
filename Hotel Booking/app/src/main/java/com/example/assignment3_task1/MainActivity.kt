package com.example.assignment3_task1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var hotelList= ArrayList<Details>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateHotelList()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CustomAdapter(hotelList)
        recyclerView.adapter=adapter

        adapter.onItemClick = {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("Hotel", it)
            startActivity(intent)
        }
    }

    private fun populateHotelList(){
        hotelList.add(Details(R.drawable.room1,"Heritage Apartment", "Old Town Road", "5 Stars", "RM 500","Room size: 28 meter", "10 mins to City Center", " •Housekeeping •Toiletries •Wi-Fi •Mini Bar ","Executive -RM 1200, Deluxe -RM 700, Superior -RM 500"))
        hotelList.add(Details(R.drawable.room2,"Ameron Hotel", "Shenton Way, Down Town", "3 Stars", "RM 300" ,"Room size: 25 meter","25 mins to Subway", " •Housekeeping •Toiletries •Wi-Fi •Refrigerator ","Deluxe -RM 500, Superior -RM 415, Single -RM 300" ))
        hotelList.add(Details(R.drawable.room3,"Dorsett Studio Apartment", "City Center", "4 Stars", "RM 415", "Room size: 28 meter", "5 mins to Bus Station", " •Kitchenette •Toiletries •Wi-Fi •Refrigerator ","Premier -RM 900, Deluxe -RM 600, Superior -RM 415"))
        hotelList.add(Details(R.drawable.room4,"Travelodge Harbourfront", "Harbourfront", "3 Stars", "RM 400", "Room size: 20 meter", "1.5km to City Center", " •Breakfast •Toiletries •Wi-Fi •Refrigerator ","Family Room -RM 600, Deluxe -RM 400"))
        hotelList.add(Details(R.drawable.room5,"Clover Apartment", "East-West Coast", "2 Stars", "RM 200", "Room size: 19 meter", "10km to City Center", " •Toiletries •Wi-Fi •Drinking Water ","Deluxe -RM 450, Superior -RM 370, Single -RM 200"))
        hotelList.add(Details(R.drawable.room6,"Wonderloft Hostel", "China Town", "3 Stars", "RM 160", "Room size: 30 meter", "220 meters to public transportation", " •Wi-Fi •Shower •Laundry ","Premium Room -RM 350, Dormitory Room -RM 160"))
    }
}