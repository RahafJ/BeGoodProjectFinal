package com.example.begoodproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.sign_up.*

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_BeGoodProject)
        setContentView(R.layout.sign_up)
        btnSignUpLast.setOnClickListener{
            Intent(this, homepage::class.java).also{
                startActivity(it)
        }


    }
}}