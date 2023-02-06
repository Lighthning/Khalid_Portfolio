package com.example.assignment3_task1

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*


 class DetailedActivity : AppCompatActivity(), View.OnClickListener{
     private lateinit var orderItem:OrderDetails
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val hotel = intent.getParcelableExtra<Details>("Hotel")
        if (hotel !=null){
            val imgbg : ImageView = findViewById(R.id.imageViewbg)
            val txtsize: TextView = findViewById(R.id.textViewsize)
            val txtdistance: TextView = findViewById(R.id.textViewdistance)
            val txtfacilities: TextView = findViewById(R.id.textViewfacilitieslist)
            val roomtypespinner: Spinner = findViewById(R.id.spinner)
            val price: TextView = findViewById(R.id.textViewTotalRM)
            val orderbutton: Button = findViewById(R.id.buttonbook)
            var Checkinbutton: TextView? = null
            var Checkindate: TextView? = null
            var Checkoutbutton: TextView? = null
            var Checkoutdate: TextView? = null
            var cal = Calendar.getInstance()
            var checkindateupdated = false
            var checkoutdateupdated = false
            orderbutton.isEnabled = false

            imgbg.setImageResource(hotel.image)
            txtsize.text = hotel.size
            txtdistance.text = hotel.distance
            txtfacilities.text = hotel.facilities

            // get the references from layout file
            Checkindate = findViewById(R.id.CheckinDate)
            Checkinbutton = findViewById(R.id.CheckinDate)

            Checkoutdate = findViewById(R.id.CheckoutDate)
            Checkoutbutton = findViewById(R.id.CheckoutDate)

            Checkindate!!.text = "--/--/----"
            Checkoutdate!!.text = "--/--/----"

            // create an OnDateSetListener
            val dateSetListener1 = object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                       dayOfMonth: Int) {
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, monthOfYear)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    checkindateupdated = true
                    updateDateInView1()
                }

                private fun updateDateInView1() {
                    val myFormat = "dd/MM/yyyy" // mention the format you need
                    val sdf = SimpleDateFormat(myFormat, Locale.US)
                    Checkindate!!.text = sdf.format(cal.getTime())
                }

            }

            val dateSetListener2 = object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                       dayOfMonth: Int) {
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, monthOfYear)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    checkoutdateupdated = true
                    updateDateInView2()

                }

                private fun updateDateInView2() {
                    val myFormat = "dd/MM/yyyy" // mention the format you need
                    val sdf = SimpleDateFormat(myFormat, Locale.US)
                    Checkoutdate!!.text = sdf.format(cal.getTime())

                    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH)
                    val datestart = LocalDate.parse(Checkindate!!.text.toString(), formatter);
                    val dateend = LocalDate.parse(Checkoutdate!!.text.toString(), formatter);
                    if (dateend.isBefore(datestart)){
                        Checkoutdate.setTextColor(Color.parseColor("#ff0000"))
                        Checkoutdate.text = "Invalid Date"
                        checkoutdateupdated = false
                    }
                    else{
                        Checkoutdate.setTextColor(Color.parseColor("#000000"))
                        checkoutdateupdated = true
                    }
                }

            }

            // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
            Checkinbutton!!.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View){
                    val datepicker = DatePickerDialog(this@DetailedActivity,
                        dateSetListener1,
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH))
                    datepicker.datePicker.minDate = Calendar.getInstance().timeInMillis
                    datepicker.show()
                }
            })

            Checkoutbutton!!.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View) {
                    val datepicker = DatePickerDialog(this@DetailedActivity,
                        dateSetListener2,
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH))
                    datepicker.datePicker.minDate = Calendar.getInstance().timeInMillis
                    datepicker.show()
                }
            })

            val roomtypesarr = hotel.roomtypes.split(",").toTypedArray()
            val arrayadapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,roomtypesarr)
            roomtypespinner.adapter = arrayadapter

            roomtypespinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val selecteditem = p0?.getItemAtPosition(p2).toString()

                    val roompricearr =selecteditem.split("-").toTypedArray()
                    val roomprice = roompricearr[1]

                    if (checkindateupdated == true && checkoutdateupdated == true){
                        orderbutton.isEnabled = true

                        val start = Checkindate!!.text.toString()
                        val end = Checkoutdate!!.text.toString()

                        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH)
                        var startdate = LocalDate.parse(start, formatter);
                        var enddate = LocalDate.parse(end, formatter);

                        val days = ChronoUnit.DAYS.between(startdate,enddate).toString()
                        val calprice =roomprice.split(" ").toTypedArray()
                        val calculatedprice = calprice[1].toInt() * days.toInt()

                        price.text = "RM $calculatedprice"
                        orderItem= OrderDetails(hotel.image, hotel.name, selecteditem, Checkindate.text.toString(),Checkoutdate.text.toString(),calculatedprice.toString())
                    }
                    else{
                        orderbutton.isEnabled = false
                        price.text = "RM 0"
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
                })

            orderbutton.setOnClickListener(this)
        }

    }
     override fun onClick(p0: View?) {
         val intent = Intent(this, OrderActivity::class.java)
         intent.putExtra("order", orderItem)
         startActivity(intent)
     }
 }




