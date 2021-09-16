package com.example.gamecardexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GameWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_window)

        val buttonLoseWin = findViewById<Button>(R.id.lostWinBtn)
        buttonLoseWin.setOnClickListener {
            val intentThree = Intent(this, MainActivity::class.java)
            startActivity(intentThree)
        }
    }
}