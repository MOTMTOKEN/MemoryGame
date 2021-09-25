package com.example.gamecardexam

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.gamecardexam.R.drawable.*

class GameWindow : AppCompatActivity() {
    private lateinit var buttons: List<ImageButton>
    private lateinit var cards: List<CardMemory>
    private var indexOfSingleSelectedCard : Int?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_window)

        var myLayout = findViewById<ConstraintLayout>(R.id.Background_id)
        val animDrawable = myLayout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(2500)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

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

        val images = mutableListOf(bug, gps, moon, point, reddit, smiley)
        images.addAll(images)
        images.shuffle()

        buttons = listOf(btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnTen,
            btnEleven,
            btnTwelve
        )

        cards = buttons.indices.map { index ->
            CardMemory(images[index], isFaceUp = false, isMatched = false)
        }

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                updateModels(index)
                updateViews()
            }

        }
    }

    private fun updateViews() {
        cards.forEachIndexed{ index, card ->
            val button = buttons[index]
            if (card.isMatched) {
                button.alpha = 0.1f
            }
        if (card.isFaceUp){
        button.setImageResource(card.identifier)
        } else {
            button.setImageResource(android)
        }
      }
    }

    private fun updateModels(position: Int) {
        val card = cards[position]
        if (card.isMatched) {
            return
        }
        if (indexOfSingleSelectedCard == null) {
            restoreCards()
            indexOfSingleSelectedCard = position
        } else {
            checkForMatch(indexOfSingleSelectedCard!!, position)
            indexOfSingleSelectedCard = null
        }
        card.isFaceUp = !card.isFaceUp
    }

    private fun restoreCards() {
        for (card in cards) {
            if (!card.isMatched) {
                card.isFaceUp = false
            }
        }
    }

    private fun checkForMatch(position1: Int, position2: Int) {
        if (cards[position1].identifier == cards[position2].identifier) {
            cards[position1].isMatched = true
            cards[position2].isMatched = true
        }
    }
}