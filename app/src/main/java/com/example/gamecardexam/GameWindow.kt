package com.example.gamecardexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import java.util.Collections.addAll

class GameWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_window)

        lateinit var buttons: List<ImageButton>

        val buttonLoseWin = findViewById<Button>(R.id.lostWinBtn)
        buttonLoseWin.setOnClickListener {
            val intentThree = Intent(this, MainActivity::class.java)
            startActivity(intentThree)
        }

        val btnOne = findViewById<ImageButton>(R.id.imageButton1)
        val btnTwo = findViewById<ImageButton>(R.id.imageButton2)
        val btnThree = findViewById<ImageButton>(R.id.imageButton3)
        val btnFour = findViewById<ImageButton>(R.id.imageButton4)
        val btnFive = findViewById<ImageButton>(R.id.imageButton5)
        val btnSix = findViewById<ImageButton>(R.id.imageButton6)
        val btnSeven = findViewById<ImageButton>(R.id.imageButton7)
        val btnEight = findViewById<ImageButton>(R.id.imageButton8)
        val btnNine = findViewById<ImageButton>(R.id.imageButton9)
        val btnTen = findViewById<ImageButton>(R.id.imageButton10)
        val btnEleven = findViewById<ImageButton>(R.id.imageButton11)
        val btnTwelve = findViewById<ImageButton>(R.id.imageButton12)

        val cards = mutableListOf(R.drawable.ic_reddit,R.drawable.ic_bug, R.drawable.ic_smiley,
            R.drawable.ic_point, R.drawable.ic_gps, R.drawable.ic_moon)
        cards.addAll(cards) //Duplicates the images for later pairing.
        cards.shuffle() //Shuffle works for mutableListOf. Tried random but didn't work.


        buttons = listOf(btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight,
        btnNine, btnTen, btnEleven, btnTwelve)
        // A list of variables that are each button on the game

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                Log.d("!!!","Button works")
                button.setImageResource(cards[index])
        }

            }
        }
    }