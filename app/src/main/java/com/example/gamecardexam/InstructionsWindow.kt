package com.example.gamecardexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class InstructionsWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions_window)

        val buttonSecond = findViewById<Button>(R.id.returnBtn)

        buttonSecond.setOnClickListener {
            val intentTwo = Intent(this, MainActivity::class.java)
            startActivity(intentTwo)
        }

    }
}