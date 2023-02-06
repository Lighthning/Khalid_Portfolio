package com.example.assignment3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.isVisible

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"


class FragmentTwo : Fragment(), View.OnClickListener {

    private lateinit var ordermains: TextView
    private lateinit var ordersides: TextView
    private lateinit var orderbvrg: TextView
    private lateinit var ordermethod: TextView
    private lateinit var ordertotal: TextView
    private lateinit var dinein: RadioButton
    private lateinit var takeaway: RadioButton
    private lateinit var homedelivery: RadioButton
    private lateinit var clearform: Button
    private lateinit var radiogroup: RadioGroup
    private var totalprice = 0.00

    val arraydinemethod: Array<List?> = arrayOfNulls<List>(3)

    private var param1: Array<List?> = arrayOfNulls<List>(6)
    private var param2: Array<List?> = arrayOfNulls<List>(6)
    private var param3: Array<List?> = arrayOfNulls<List>(4)
    private var param4: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelableArray(ARG_PARAM1) as Array<List?>
            param2 = it.getParcelableArray(ARG_PARAM2) as Array<List?>
            param3 = it.getParcelableArray(ARG_PARAM3) as Array<List?>
            param4 = it.getInt(ARG_PARAM4)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_two, container, false)
        dinein = view.findViewById(R.id.radioButtondinein)
        takeaway = view.findViewById(R.id.radioButtontakeaway)
        homedelivery = view.findViewById(R.id.radioButtonhomedel)
        ordermains = view.findViewById(R.id.textViewOrderMains)
        ordersides = view.findViewById(R.id.textViewOrderSides)
        orderbvrg = view.findViewById(R.id.textViewOrderBevrages)
        ordermethod = view.findViewById(R.id.textViewOrderDining)
        ordertotal = view.findViewById(R.id.textViewtotalrm)
        clearform = view.findViewById(R.id.buttonclear)
        radiogroup = view.findViewById(R.id.stepfourradiogroup)

        dinein.setOnClickListener(this)
        takeaway.setOnClickListener(this)
        homedelivery.setOnClickListener(this)
        clearform.setOnClickListener{
            resetForm()
        }

        totalcalc()

        return  view
    }

    private fun resetForm() {
        radiogroup.clearCheck()
        ordermains.text = "-Mains: "
        ordersides.text = "-Sides: "
        orderbvrg.text = "-Beverage: "
        ordermethod.text = "-Dining Method: "
        ordertotal.text = ("Total: RM 0.00")
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: Array<List?>, param2: Array<List?>, param3: Array<List?>, param4: Int) =
            FragmentTwo().apply {
                arguments = Bundle().apply {
                    putParcelableArray(ARG_PARAM1, param1)
                    putParcelableArray(ARG_PARAM2, param2)
                    putParcelableArray(ARG_PARAM3, param3)
                    putInt(ARG_PARAM4, param4)
                }
            }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.radioButtondinein ->{
                if (dinein.isChecked){
                    arraydinemethod[0]= List(1, "Dine in", 0.00)
                    arraydinemethod[1]= null
                    arraydinemethod[2]= null
                    takeaway.isChecked = false
                    homedelivery.isChecked = false
                }
            }
            R.id.radioButtontakeaway ->{
                if(takeaway.isChecked){
                    arraydinemethod[1]= List(2, "Take Away", 1.50)
                    arraydinemethod[0] = null
                    arraydinemethod[2]= null
                    dinein.isChecked = false
                    homedelivery.isChecked = false
                }

            }
            R.id.radioButtonhomedel ->{
                if (homedelivery.isChecked){
                    arraydinemethod[2]= List(3, "Home Delivery", 4.00)
                    arraydinemethod[1] = null
                    arraydinemethod[0]= null
                    dinein.isChecked = false
                    takeaway.isChecked = false
                }
            }
        }
        totalcalc()
    }

    private fun totalcalc() {
        var mainstotal = 0.00
        var sidestotal = 0.00
        var bvgtotal = 0.00
        var dinetotal = 0.00

        param2?.forEach {
            var discount = 0.00
            if (param4!! >= 3 && it != null) {
                if (it.List.equals("Baked Beans")){
                    discount += 0.5
                } else if (it.List.equals("Hash Browns")){
                    discount += 0.4
                } else if (it.List.equals("Saute Vegetables")){
                    discount += 0.7
                } else if (it.List.equals("Salad")){
                    discount += 0.6
                }
            }else{
                discount = 0.00
            }
            sidestotal -= discount
        }

        for (a in param1!!) {
            if (a != null) {
                mainstotal = mainstotal + a.Prices
            }
            var txt = "-Main:"
            param1!!.forEach {
                if (it != null) {
                    txt += " ${it.List},"
                }
            }
            ordermains.text = txt
            ordermains.isVisible = true
        }

        for (a in param2!!){
            if (a != null) {
                sidestotal = sidestotal + a.Prices
            }
            var txt = "-Side:"
            param2!!.forEach {
                if (it != null) {
                    txt += " ${it.List},"
                }
            }
            ordersides.text = txt
            ordersides.isVisible = true
        }

        for (a in param3!!){
            if (a != null) {
                bvgtotal = bvgtotal + a.Prices

            }
            if (a != null) {
                orderbvrg.setText("-Beverage: ${a.List}")
                orderbvrg.isVisible = true
            }
        }


        for (a in arraydinemethod){
            if (a != null) {
                dinetotal = dinetotal + a.Prices

            }
            if (a != null) {
                ordermethod.setText("-Dining Method: ${a.List}")
                ordermethod.isVisible = true
            }
        }

        totalprice = mainstotal + sidestotal + bvgtotal + dinetotal

        if (totalprice >= 20.00){
            var bvrgdisc = bvgtotal * 00.10
            println(bvrgdisc)
            totalprice -= bvrgdisc
        }

        ordertotal.setText("Total: RM $totalprice")
    }
}