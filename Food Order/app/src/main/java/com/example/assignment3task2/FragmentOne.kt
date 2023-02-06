package com.example.assignment3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class FragmentOne : Fragment(), View.OnClickListener {
    private lateinit var next:onButtonClick
    private lateinit var scrambledeggs: CheckBox
    private lateinit var omellete: CheckBox
    private lateinit var pancake: CheckBox
    private lateinit var sausages: CheckBox
    private lateinit var beefbacon: CheckBox
    private lateinit var ham: CheckBox
    private lateinit var bakedbeans: CheckBox
    private lateinit var tomatoes: CheckBox
    private lateinit var hashbrowns: CheckBox
    private lateinit var sautevegetables: CheckBox
    private lateinit var toast: CheckBox
    private lateinit var salad: CheckBox
    private lateinit var coffee: RadioButton
    private lateinit var tea: RadioButton
    private lateinit var juice: RadioButton
    private lateinit var milk: RadioButton
    private lateinit var radioGroup: RadioGroup
    private var count = 0

    val arrayMainsList:Array<com.example.assignment3task2.List?> = arrayOfNulls<com.example.assignment3task2.List>(6)
    val arraySidesList:Array<com.example.assignment3task2.List?> = arrayOfNulls<com.example.assignment3task2.List>(6)
    val arrayBvrgsList:Array<com.example.assignment3task2.List?> = arrayOfNulls<com.example.assignment3task2.List>(4)

    interface onButtonClick{
        fun passData(Mains: Array<List?>, Sides: Array<List?>, Bevrages: Array<List?>, count: Int)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_one, container, false)
        val btnext = view.findViewById<Button>(R.id.buttonnext)
        scrambledeggs = view.findViewById(R.id.checkBox1)
        omellete = view.findViewById(R.id.checkBox2)
        pancake = view.findViewById(R.id.checkBox3)
        sausages = view.findViewById(R.id.checkBox4)
        beefbacon = view.findViewById(R.id.checkBox5)
        ham = view.findViewById(R.id.checkBox6)
        bakedbeans = view.findViewById(R.id.checkBoxBakedBeans)
        tomatoes = view.findViewById(R.id.checkBoxTomatoes)
        hashbrowns = view.findViewById(R.id.checkBoxhashBrowns)
        sautevegetables = view.findViewById(R.id.checkBoxSaute)
        toast = view.findViewById(R.id.checkBoxToast)
        salad = view.findViewById(R.id.checkBoxSalad)
        coffee = view.findViewById(R.id.radioButtonCoffee)
        tea = view.findViewById(R.id.radioButtonTea)
        juice = view.findViewById(R.id.radioButtonJuice)
        milk = view.findViewById(R.id.radioButtonMilk)
        radioGroup = view.findViewById(R.id.radiogroup)

        scrambledeggs.setOnClickListener(this)
        omellete.setOnClickListener(this)
        pancake.setOnClickListener(this)
        sausages.setOnClickListener(this)
        beefbacon.setOnClickListener(this)
        ham.setOnClickListener(this)
        bakedbeans.setOnClickListener(this)
        tomatoes.setOnClickListener(this)
        hashbrowns.setOnClickListener(this)
        sautevegetables.setOnClickListener(this)
        toast.setOnClickListener(this)
        salad.setOnClickListener(this)
        coffee.setOnClickListener(this)
        tea.setOnClickListener(this)
        juice.setOnClickListener(this)
        milk.setOnClickListener(this)
        radioGroup.setOnClickListener(this)

        btnext.setOnClickListener(){
            buttonClickMethod(view)
        }
        next = activity as onButtonClick

        return view
    }

    private fun buttonClickMethod(view: View?) {
        next.passData(arrayMainsList, arraySidesList, arrayBvrgsList, count)
    }

    override fun onClick(view: View?) {
        when(view?.id){
        R.id.checkBox1 ->{
            if (scrambledeggs.isChecked) {
                arrayMainsList[0]= List(1, "Scrambled Eggs", 5.00)
                count++
            }else{
                arrayMainsList[0]= null
                count--
            }
        }
        R.id.checkBox2 ->{
            if (omellete.isChecked){
                arrayMainsList[1]= List(2, "Omellete", 5.00)
                count++
            }
            else{
                arrayMainsList[1]= null
                count--
            }
        }
        R.id.checkBox3 ->{
            if (pancake.isChecked){
                arrayMainsList[2]= List(3, "Pancake", 4.00)
                count++
            }else{
                count--
                arrayMainsList[2]= null
            }
        }
        R.id.checkBox4 ->{
            if (sausages.isChecked){
                arrayMainsList[3]= List(4, "Sausages", 6.00)
                count++
            }else{
                arrayMainsList[3]= null
                count--
            }
        }
        R.id.checkBox5 ->{
            if (beefbacon.isChecked){
                arrayMainsList[4]= List(5, "Beef Bacon", 6.50)
                count++
            }else{
                arrayMainsList[4]= null
                count--
            }
        }
        R.id.checkBox6 ->{
            if (ham.isChecked){
                arrayMainsList[5]= List(6, "Ham", 6.00)
                count++
            }else{
                arrayMainsList[5]= null
                count--
            }
        }
        R.id.checkBoxBakedBeans ->{
            if (bakedbeans.isChecked){
                arraySidesList[0]= List(1, "Baked Beans", 2.50)
            }else{
                arraySidesList[0] = null
            }
        }
        R.id.checkBoxTomatoes ->{
            if (tomatoes.isChecked){
                arraySidesList[1]= List(2, "Tomatoes", 1.50)
            }else{
                arraySidesList[1] = null
            }
        }
        R.id.checkBoxhashBrowns ->{
            if (hashbrowns.isChecked){
                arraySidesList[2]= List(3, "Hash Browns", 2.00)
            }else{
                arraySidesList[2] = null
            }
        }
        R.id.checkBoxSaute ->{
            if (sautevegetables.isChecked){
                arraySidesList[3]= List(4, "Saute Vegetables", 3.50)
            }else{
                arraySidesList[3] = null
            }
        }
        R.id.checkBoxToast ->{
            if (toast.isChecked){
                arraySidesList[4]= List(5, "Toast", 2.00)
            }else{
                arraySidesList[4] = null
            }
        }
        R.id.checkBoxSalad ->{
            if (salad.isChecked){
                arraySidesList[5]= List(6, "Salad", 3.00)
            }else{
                arraySidesList[5] = null
            }
        }
        R.id.radioButtonCoffee ->{
            if (coffee.isChecked){
                arrayBvrgsList[0]= List(1, "Coffee", 4.00)
                arrayBvrgsList[3]= null
                arrayBvrgsList[2]= null
                arrayBvrgsList[1]= null
                tea.isChecked = false
                juice.isChecked = false
                milk.isChecked = false
            }
        }
        R.id.radioButtonTea ->{
            if(tea.isChecked){
                arrayBvrgsList[1]= List(2, "Tea", 4.00)
                arrayBvrgsList[0] = null
                arrayBvrgsList[3]= null
                arrayBvrgsList[2]= null
                coffee.isChecked = false
                juice.isChecked = false
                milk.isChecked = false
            }

        }
        R.id.radioButtonJuice ->{
            if (juice.isChecked){
                arrayBvrgsList[2]= List(3, "Juice", 5.50)
                arrayBvrgsList[0] = null
                arrayBvrgsList[3]= null
                arrayBvrgsList[1]= null
                coffee.isChecked = false
                tea.isChecked = false
                milk.isChecked = false

            }
        }
        R.id.radioButtonMilk ->{
            if (milk.isChecked){
                arrayBvrgsList[3]= List(4, "Milk", 5.00)
                arrayBvrgsList[0] = null
                arrayBvrgsList[1]= null
                arrayBvrgsList[2]= null
                coffee.isChecked = false
                tea.isChecked = false
                juice.isChecked = false
            }
        }
    }
        sidesvalidation()
    }

    private fun sidesvalidation() {
        if (arrayMainsList.size > 1){
            bakedbeans.isEnabled = true
            tomatoes.isEnabled = true
            hashbrowns.isEnabled = true
            sautevegetables.isEnabled = true
            toast.isEnabled = true
            salad.isEnabled = true
        }else{
            bakedbeans.isEnabled = false
            tomatoes.isEnabled = false
            hashbrowns.isEnabled = false
            sautevegetables.isEnabled = false
            toast.isEnabled = false
            salad.isEnabled = false
        }
    }
}