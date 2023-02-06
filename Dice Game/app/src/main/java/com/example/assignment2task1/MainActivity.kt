package com.example.assignment2task1

import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var pone:TextView
    private lateinit var ponescore:TextView
    private var ponefinal = 0
    private lateinit var ponedice1:ImageView
    private lateinit var ponenumthrown:TextView
    private lateinit var ptwo:TextView
    private lateinit var ptwoscore:TextView
    private var ptwofinal = 0
    private lateinit var ptwodice1:ImageView
    private lateinit var ptwonumthrown:TextView
    private  var playerone=0
    private  var playertwo=0

    private var dices = arrayListOf<Int>(R.drawable.dice_one, R.drawable.dice_two, R.drawable.dice_three, R.drawable.dice_four, R.drawable.dice_five, R.drawable.dice_six)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI(){
        Toast.makeText(this, "working", Toast.LENGTH_LONG).show()

        pone = findViewById(R.id.pone)
        ponescore = findViewById(R.id.ponescore)
        ponedice1 = findViewById(R.id.ponedice1)
        ponenumthrown = findViewById(R.id.ponenumthrown)
        ptwo = findViewById(R.id.ptwo)
        ptwoscore = findViewById(R.id.ptwoscore)
        ptwodice1 = findViewById(R.id.ptwodice1)
        ptwonumthrown = findViewById(R.id.ptwonumthrown)
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)




        // Checks the orientation of the screen
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE){
            playerone= (1..6).random()
            playeronedice()

        }else if(newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            playertwo = (1..6).random()
            playertwodice()
        }
    }

    private fun playeronedice(){

        ponedice1.setImageResource(dices[playerone-1])
        pone.setTextColor(Color.RED)
        ptwo.setTextColor(Color.BLACK)
        ponenumthrown.setText("$playerone")
    }
    private fun playertwodice(){
        ptwodice1.setImageResource(dices[playertwo-1])
        ptwo.setTextColor(Color.RED)
        pone.setTextColor(Color.BLACK)
        ptwonumthrown.setText("$playertwo")
        finalscore()
    }

    private fun finalscore(){
        if (playerone > playertwo ){
            ponefinal = ponefinal.plus(playerone)
        }
        else if(playertwo > playerone){
            ptwofinal = ptwofinal.plus(playertwo)
        }
        else{
            ponefinal = ponefinal.plus(playerone)
            ptwofinal = ptwofinal.plus(playertwo)
        }

        ponescore.text = "$ponefinal"
        ptwoscore.text = "$ptwofinal"
    }
}



private fun ImageView.setImageResource(let: Drawable?) {

}

private operator fun Any.plusAssign(playerone: Int) {

}

