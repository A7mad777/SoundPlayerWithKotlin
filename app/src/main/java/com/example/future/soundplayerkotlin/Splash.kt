package com.example.future.soundplayerkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import java.time.Instant

class Splash : AppCompatActivity() {
    private var handler:Handler ?= null
    private val Splash_Delay: Long = 1200


    //Make Handling for Splash..
    var runnable:Runnable = Runnable {
        val intent = Intent(applicationContext,LoginActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = Handler()
        if (handler != null){
            handler!!.postDelayed(runnable,Splash_Delay)
        }
    }

    override fun onDestroy() {
        if (handler != null){
            handler!!.removeCallbacks(runnable)
        }
        super.onDestroy()
    }
}
