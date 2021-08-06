package com.example.begoodproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_BeGoodProject)
        setContentView(R.layout.activity_main)


        btnSignUp.setOnClickListener{
            Intent(this, SignUp::class.java).also{
                startActivity(it)
            }
        }
        btnLogin.setOnClickListener{
            Intent(this,homepage::class.java).also {
                startActivity(it)
            }
        }
    }
}

