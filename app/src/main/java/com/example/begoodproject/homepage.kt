package com.example.begoodproject

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.home_page.*

class homepage : AppCompatActivity() {


    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_BeGoodProject)
        setContentView(R.layout.home_page)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> Toast.makeText(applicationContext,"Clicked Home", Toast.LENGTH_LONG).show()
                R.id.reedemPoints -> Toast.makeText(applicationContext,"Clicked reedemPoints", Toast.LENGTH_LONG).show()
                R.id.advice -> Toast.makeText(applicationContext,"Clicked advice", Toast.LENGTH_LONG).show()
                R.id.goToShop -> Toast.makeText(applicationContext,"Clicked goToShop", Toast.LENGTH_LONG).show()
                R.id.aboutUs -> Toast.makeText(applicationContext,"Clicked aboutUs", Toast.LENGTH_LONG).show()
                R.id.signOut -> Toast.makeText(applicationContext,"Clicked signOut", Toast.LENGTH_LONG).show()

            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}