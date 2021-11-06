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
import androidx.room.Room
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    private lateinit var db : AppDataBase

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

        db = Room.databaseBuilder(applicationContext,
            AppDataBase::class.java,
            "retry_attempts"
        ).fallbackToDestructiveMigration()
            .build()

        val item1 = Item(0, 10)
        //val item2 = Item(0, 20)
        //val item3 = Item(0, 30)

        //saveTries(item1)

        GlobalScope.launch {
            val itemsList = loadItem().await()
        }






    }

    fun saveTries(item : Item){

        GlobalScope.launch(Dispatchers.IO) {
            db.itemDao().insert(item)
        }
    }

    fun loadItem() : Deferred<List<Item>> =
        GlobalScope.async(Dispatchers.IO) {
        db.itemDao().get()
    }



    override fun onResume() {
        super.onResume()
    }

    companion object{
        var mp: MediaPlayer? = null
    }
}