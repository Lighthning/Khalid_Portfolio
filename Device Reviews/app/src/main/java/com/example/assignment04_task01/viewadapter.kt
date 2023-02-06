package com.example.assignment04_task01

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class viewadapter(appCompatActivity: AppCompatActivity, private val tabTitles:Array<String>, private val itemsArray: ArrayList<Items>): FragmentStateAdapter(appCompatActivity) {
    var HandPhonesList = ArrayList<Items>()
    var TabletsList = ArrayList<Items>()
    var Item = "Phone"

    override fun getItemCount(): Int = tabTitles.size

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 ->{
                for (item in itemsArray){
                    if (item.type == Item){
                        HandPhonesList.add(item)
                    }
                }
                var loadfragment = FragmentOne.newInstance(HandPhonesList)
                return loadfragment
            }
            else ->{
                for (item in itemsArray){
                    if (item.type != Item){
                        TabletsList.add(item)
                    }
                }
                var loadfragment = FragmentTwo.newInstance(TabletsList)
                return loadfragment
            }
        }

    }
}