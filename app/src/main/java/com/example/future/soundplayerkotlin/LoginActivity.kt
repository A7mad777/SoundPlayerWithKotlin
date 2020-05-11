package com.example.future.soundplayerkotlin

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.future.soundplayerkotlin.R.id.textView2
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var typeface : Typeface ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        typeface = Typeface.createFromAsset(assets,"Billabong.ttf")
        textView2.typeface = typeface

        supportFragmentManager.beginTransaction().replace(R.id.container,LoginFragment()).commit()
    }
    fun setRegisterFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.container,Register()).commit()
    }
    fun setLoginFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.container,LoginFragment()).commit()
    }
}
