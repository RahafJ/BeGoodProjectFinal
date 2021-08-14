package com.example.begoodproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.viewbinding.ViewBinding
import com.example.begoodproject.databinding.ActivityAboutUsBinding.inflate
import com.example.begoodproject.databinding.ActivityAdviceBinding.inflate
import com.example.begoodproject.databinding.ActivityMainBinding.inflate
import com.example.begoodproject.databinding.ActivitySplashBinding.inflate
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference


class userProfile : AppCompatActivity() {

    private lateinit var binding: userProfile
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding= userProfile.inflate(layoutInflater)
        setContentView(R.layout.activity_user_profile)



    }
}