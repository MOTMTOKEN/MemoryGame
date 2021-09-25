package com.example.gamecardexam

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myLayout = findViewById<ConstraintLayout>(R.id.Background_id)
        val animDrawable = myLayout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(2500)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val buttonOne = findViewById<Button>(R.id.instBtn)
        val buttonPlay = findViewById<Button>(R.id.playBtn)

        buttonPlay.setOnClickListener {
            val intentClick = Intent(this,GameWindow::class.java)
            startActivity(intentClick)
        }
        buttonOne.setOnClickListener {
            val intent = Intent(this, InstructionsWindow::class.java)
            startActivity(intent)
        }
    }
}