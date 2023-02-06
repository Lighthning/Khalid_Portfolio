package com.example.assignment04_task01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), FragmentOne.OnClick {
    var itemsarray = ArrayList<Items>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        populateArrays()

        val tabTitles = arrayOf("Handphones", "Tablets")
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)

        viewPager.adapter = viewadapter(this, tabTitles, itemsarray)
        TabLayoutMediator(tabLayout, viewPager){
                tab, position->tab.text = tabTitles[position]
        }.attach()
    }

    private fun populateArrays() {
        var i = 0
        val items = application.assets.open("task1_data.txt").bufferedReader().use {
            while (i<10){
                var model = it.readLine()
                println(model)
                var url = it.readLine().substringAfterLast("Url:")
                var processor = it.readLine().substringAfterLast(":")
                val storage = it.readLine().substringAfterLast(":")
                val camera = it.readLine().substringAfterLast(":")
                val imgres = it.readLine().substringAfterLast(":")

                var modeltype = model.split(":").toTypedArray()
                var type = modeltype[0]
                var name = modeltype[1]

                var res = imgres.split(".").toTypedArray()
                var img = res[0]

                itemsarray.add(Items(type, img, name ,url, processor, storage, camera))
                println(itemsarray)
                i++
            }
        }
    }

    override fun ClickItem(url: String) {
        val WebFragment = FragmentWebView.newInstance(url)
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.root_layout,WebFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}