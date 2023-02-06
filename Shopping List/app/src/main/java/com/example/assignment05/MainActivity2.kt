package com.example.assignment05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var listitems:ArrayList<items>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val spinner = findViewById<Spinner>(R.id.spinnersize)
        val shoppingitem = findViewById<EditText>(R.id.editTextshoppingitem)
        val details = findViewById<EditText>(R.id.editTextTextMultiLine)
        val qtydown = findViewById<ImageView>(R.id.imageViewqtydown)
        val qtycount = findViewById<TextView>(R.id.textViewqtycounter)
        var counter = 0
        val qtyup = findViewById<ImageView>(R.id.imageViewqtyup)
        val urgent = findViewById<CheckBox>(R.id.checkBoxurgent)
        var img: Int? = null
        var selecteditem: String? = null
        var urgtxt: String? = null
        var addbutton = findViewById<TextView>(R.id.buttonadd)
        var bought = "No"

        val spinnerlist = "Default,Small,Medium,Large"
        val spinnerarray = spinnerlist.split(",").toTypedArray()
        val spinneradapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerarray)
        spinner.adapter = spinneradapter

        val itemname = shoppingitem.text
        val itemdetails = details.text

        qtydown.setOnClickListener {
            counter --
            qtycount.setText(counter.toString())
        }
        qtyup.setOnClickListener(){
            counter ++
            qtycount.setText(counter.toString())
        }
        urgtxt = "No"
        img = R.drawable.buy
        urgent.setOnClickListener(){
            if (urgent.isChecked){
               img = R.drawable.urgent
                urgtxt = "Yes"
            }else{
                img = R.drawable.buy
                urgtxt = "No"
            }
        }

        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selecteditem = p0?.getItemAtPosition(p2).toString()

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        })

        val dbHelper = DBHelper(this)

        addbutton.setOnClickListener(){
            if (shoppingitem.text.toString().isEmpty()){
                shoppingitem.setError("Please enter the item to be purchased")
            }else{
                val countqty = qtycount.text
                dbHelper.insertItem(items(img, itemname.toString(), itemdetails.toString(), "Qty: ${countqty.toString()}", "Size: ${selecteditem.toString()}",urgtxt.toString(),bought))

                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }

    }
}