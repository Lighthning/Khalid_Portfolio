package com.example.assignment05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity4 : AppCompatActivity() {
    private lateinit var listitems:ArrayList<items>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        var edititems = intent.getParcelableExtra<items>("Edit")
        if (edititems != null){
            val spinner = findViewById<Spinner>(R.id.spinnersizeupdate)
            var shoppingitem = findViewById<EditText>(R.id.editTextshoppingitemupdate)
            val details = findViewById<EditText>(R.id.editTextTextMultiLineupdate)
            val qtydown = findViewById<ImageView>(R.id.imageViewqtydownupdate)
            val qtycount = findViewById<TextView>(R.id.textViewqtycounterupdate)
            var counter = 0
            val qtyup = findViewById<ImageView>(R.id.imageViewqtyupupdate)
            val urgent = findViewById<CheckBox>(R.id.checkBoxurgentupdate)
            var img: Int? = null
            var selecteditem: String? = null
            var urgtxt: String? = null
            var addbutton = findViewById<TextView>(R.id.buttonaddupdate)
            var bought = "No"

            val spinnerlist = "Default,Small,Medium,Large"
            val spinnerarray = spinnerlist.split(",").toTypedArray()
            println(spinnerarray.toString())
            val spinneradapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerarray)
            spinner.adapter = spinneradapter
            val spinnertxt = edititems.size.substringAfterLast(": ")

            var pos = 0
            for (a in spinnerarray){
                if (spinnertxt == a){
                    spinner.setSelection(pos)
                }else{
                    pos++
                }
            }

            shoppingitem.setText(edititems.name)
            details.setText(edititems.detail)
            val qtycounting = edititems.quantity.substringAfterLast(": ")
            qtycount.setText(qtycounting)
            counter = qtycounting.toInt()
            if (edititems.img == R.drawable.urgent){
                urgent.isChecked = true
                img = R.drawable.urgent
            }else{
                urgent.isChecked = false
                img = R.drawable.buy
            }

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
                    TODO("Not yet implemented")
                }
            })

            val dbHelper = DBHelper(this)

            addbutton.setOnClickListener(){
                val countqty = qtycount.text

                edititems.img = img!!
                edititems.name = itemname.toString()
                edititems.detail = itemdetails.toString()
                edititems.quantity = "Qty: ${countqty.toString()}"
                edititems.size = "Size: ${selecteditem.toString()}"
                edititems.urgent = urgtxt.toString()

                dbHelper.updateitems(edititems)
                listitems = dbHelper.getallitems()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

    }
}