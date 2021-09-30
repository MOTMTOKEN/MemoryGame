package com.example.gamecardexam

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.gamecardexam.R.drawable.*
import kotlinx.android.synthetic.main.activity_game_window.*

class GameWindow : AppCompatActivity() {
    private lateinit var buttons: List<ImageButton>
    // en lista av Imagebutton
    private lateinit var cards: List<CardMemory>
    // en lista av klassen CardMemory
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

        refreshButton.setOnClickListener {
            val t = Intent(this, GameWindow::class.java)
            startActivity(t)
            finish()
        }

        val images = mutableListOf(bug, gps, moon, point, reddit, smiley)
        images.addAll(images)
        images.shuffle()

        buttons = listOf(imageButton1, imageButton2, imageButton3, imageButton4, imageButton5,
            imageButton6, imageButton7, imageButton8, imageButton9, imageButton10,
            imageButton11, imageButton12)

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
            Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show()
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
            Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show()
            cards[position1].isMatched = true
            cards[position2].isMatched = true

        }
    }
}