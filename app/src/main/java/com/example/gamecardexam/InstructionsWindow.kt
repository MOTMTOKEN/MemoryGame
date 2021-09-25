package com.example.gamecardexam

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class InstructionsWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions_window)

        var myLayout = findViewById<ConstraintLayout>(R.id.Background_id)
        val animDrawable = myLayout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(2500)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val buttonSecond = findViewById<Button>(R.id.returnBtn)

        buttonSecond.setOnClickListener {
            val intentTwo = Intent(this, MainActivity::class.java)
            startActivity(intentTwo)
        }

    }
}