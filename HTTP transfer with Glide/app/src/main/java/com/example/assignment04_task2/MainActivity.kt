package com.example.assignment04_task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var allitems= ArrayList<Images>()
    private var animals= ArrayList<Images>()
    private var plants= ArrayList<Images>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        populateArray()

        val spinner: Spinner = findViewById(R.id.spinner)

        val filterlist = "All,Animals,Plants"
        val filterarray = filterlist.split(",").toTypedArray()
        val spinneradapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, filterarray)
        spinner.adapter = spinneradapter

        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        for (a in allitems){
            if (a.type == "Animals"){
                animals.add(a)
            }else if (a.type == "Plants"){
                plants.add(a)
            }
        }

        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val selecteditem = p0?.getItemAtPosition(p2).toString()

                if(selecteditem == "Animals"){
                    val adapter = CustomAdapter(animals, ::onitemclicked)
                    recyclerView.adapter=adapter
                }else if(selecteditem == "Plants"){
                    val adapter = CustomAdapter(plants, ::onitemclicked)
                    recyclerView.adapter=adapter
                }else{
                    val adapter = CustomAdapter(allitems, ::onitemclicked)
                    recyclerView.adapter=adapter
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        })

    }

    private fun onitemclicked(images: Images){
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("Images", images)
        startActivity(intent)
    }

    private fun populateArray() {
        allitems.add(Images("http://172.24.160.1/Task%202%20Images/koala_thumb.jpg", "http://172.24.160.1/Task%202%20Images/koala.jpg", "Koala", "Animals"))
        allitems.add(Images("http://172.24.160.1/Task%202%20Images/orchid_thumb.jpg", "http://172.24.160.1/Task%202%20Images/orchid.jpg", "Orchid", "Plants"))
        allitems.add(Images("http://172.24.160.1/Task%202%20Images/pitcher_thumb.jpg", "http://172.24.160.1/Task%202%20Images/pitcher.jpg", "Pitcher", "Plants"))
        allitems.add(Images("http://172.24.160.1/Task%202%20Images/quokka_thumb.jpg", "http://172.24.160.1/Task%202%20Images/quokka.jpg", "Quokka", "Animals"))
        allitems.add(Images("http://172.24.160.1/Task%202%20Images/rabbit_thumb.jpg", "http://172.24.160.1/Task%202%20Images/rabbit.jpg", "Rabbit", "Animals"))
        allitems.add(Images("http://172.24.160.1/Task%202%20Images/rafflesia_thumb.jpg", "http://172.24.160.1/Task%202%20Images/rafflesia.jpg", "Rafflesia", "Plants"))
        allitems.add(Images("http://172.24.160.1/Task%202%20Images/seal_thumb.jpg", "http://172.24.160.1/Task%202%20Images/seal.jpg", "Seal", "Animals"))
        allitems.add(Images("http://172.24.160.1/Task%202%20Images/sloth_thumb.jpg", "http://172.24.160.1/Task%202%20Images/sloth.jpg", "Sloth", "Animals"))
        allitems.add(Images("http://172.24.160.1/Task%202%20Images/succulent_thumb.PNG", "http://172.24.160.1/Task%202%20Images/succulent.PNG", "Succulent", "Plants"))
        allitems.add(Images("http://172.24.160.1/Task%202%20Images/titan_arum_thumb.jpg", "http://172.24.160.1/Task%202%20Images/titan_arum.jpg", "Titan Arum", "Plants"))
    }
}