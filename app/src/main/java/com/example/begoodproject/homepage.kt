package com.example.begoodproject

import android.content.Intent
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


        btnAddBill.setOnClickListener{
            Intent(this, BillsLayout::class.java).also{
                startActivity(it)
            }
        }

        btnShopUsingPoints.setOnClickListener {
//            Toast.makeText(baseContext,"YoU CLICKED ",Toast.LENGTH_LONG).show()
            Intent(this, ShopActivity::class.java).also{ intent ->
                startActivity(intent)
            }
        }

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){

                R.id.user ->  Intent(this, userProfile::class.java).also{ intent ->
                    startActivity(intent) }

                R.id.home ->  Intent(this, homepage::class.java).also{ intent ->
                startActivity(intent) }

                R.id.reedemPoints -> Toast.makeText(applicationContext,"Clicked reedemPoints", Toast.LENGTH_LONG).show()

                R.id.advice -> Intent(this, adviceActivity::class.java).also{ intent ->
                    startActivity(intent)
                }

                R.id.goToShop -> Intent(this, ShopActivity::class.java).also{ intent ->
                    startActivity(intent)
                }
//                    Toast.makeText(applicationContext,"Clicked goToShop", Toast.LENGTH_LONG).show()
//                R.id.aboutUs -> Toast.makeText(applicationContext,"Clicked aboutUs", Toast.LENGTH_LONG).show()

                R.id.aboutUs -> Intent(this, aboutUs::class.java).also{ intent ->
                    startActivity(intent)
                }
                R.id.signOut -> Intent(this, MainActivity::class.java).also{ intent ->
                    startActivity(intent)
                }

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