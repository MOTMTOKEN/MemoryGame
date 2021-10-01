package com.example.gamecardexam

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import android.view.animation.RotateAnimation
import android.view.animation.AccelerateDecelerateInterpolator

import android.animation.ObjectAnimator
import android.media.MediaPlayer


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var myLayout = findViewById<ConstraintLayout>(R.id.Background_id)
        val animDrawable = myLayout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(2500)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val logo = findViewById<ImageView>(R.id.mainLogo)


        val animation = ObjectAnimator.ofFloat(logo, "rotationY", 0.0f,360f)
        animation.duration = 10000
        animation.repeatCount = ObjectAnimator.INFINITE
        animation.interpolator = AccelerateDecelerateInterpolator()
        animation.start()


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

    override fun onResume() {
        super.onResume()
    }

    companion object{
        var mp: MediaPlayer? = null
    }
}