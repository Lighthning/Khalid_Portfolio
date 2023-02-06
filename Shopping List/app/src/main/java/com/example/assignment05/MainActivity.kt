package com.example.assignment05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var bottomnav:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, Fragment_Home()).commit()
        supportFragmentManager.beginTransaction().addToBackStack(null)

        bottomnav = findViewById(R.id.bottom_nav) as BottomNavigationView
        bottomnav.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.urgentlist ->{
                    supportFragmentManager.beginTransaction().replace(R.id.container, Fragment_Urgent()).commit()
                    supportFragmentManager.beginTransaction().addToBackStack(null)
                    return@setOnNavigationItemReselectedListener
                }
                R.id.home ->{
                    supportFragmentManager.beginTransaction().replace(R.id.container, Fragment_Home()).commit()
                    supportFragmentManager.beginTransaction().addToBackStack(null)
                    return@setOnNavigationItemReselectedListener
                }
                R.id.completedlist ->{
                    supportFragmentManager.beginTransaction().replace(R.id.container, Fragment_Completed()).commit()
                    supportFragmentManager.beginTransaction().addToBackStack(null)
                    return@setOnNavigationItemReselectedListener
                }
            }
        }
        val actionbtn = findViewById<View>(R.id.floatingActionButton)
        actionbtn.setOnClickListener(){
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}