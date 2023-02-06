package com.example.assignment05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Fragment_Completed : Fragment() {
    private var param1 = ArrayList<items>()
    private var comparray = ArrayList<items>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view =  inflater.inflate(R.layout.fragment__completed, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerviewcompleted)
        val dbHelper = context?.let { DBHelper(it) }
        param1 = dbHelper!!.getallitems()
        for (a in param1){
            if (a.bought != "No"){
                comparray.add(a)
            }
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
        val itemadapter = ItemCompadapter(comparray)
        recyclerView.adapter = itemadapter
        return view
    }
}