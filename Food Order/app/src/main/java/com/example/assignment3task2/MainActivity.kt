package com.example.assignment3task2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), FragmentOne.onButtonClick{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragmentone = FragmentOne()
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.add(R.id.root_layout, fragmentone).commit()
    }

    override fun passData(
        Mains: Array<List?>,
        Sides: Array<List?>,
        Bevrages: Array<List?>,
        count: Int,
    ) {
        val fragmenttwo = FragmentTwo.newInstance(Mains, Sides, Bevrages, count)
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.root_layout,fragmenttwo)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}