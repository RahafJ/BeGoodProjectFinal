package com.example.begoodproject

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.sign_up.*

class SignUp : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_BeGoodProject)
        setContentView(R.layout.sign_up)
        auth = FirebaseAuth.getInstance()

        btnSignUpLast.setOnClickListener{
            signUpUser()
        }
}


    fun signUpUser(){
        if (editTextTextPersonName.text.toString().isEmpty()){
            editTextTextPersonName.error="Please Enter Your First Name"
            editTextTextPersonName.requestFocus()
            return
        }

        if (editTextTextPersonName2.text.toString().isEmpty()){
            editTextTextPersonName2.error="Please Enter Your Last Name"
            editTextTextPersonName2.requestFocus()
            return
        }
        if (!Patterns.PHONE.matcher(editTextPhone.text.toString()).matches()){
            editTextPhone.error="Please Enter Valid Email"
            editTextPhone.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(editTextTextEmailAddress2.text.toString()).matches()){
            editTextTextEmailAddress2.error="Please Enter Valid Email"
            editTextTextEmailAddress2.requestFocus()
            return
        }

        if (editTextTextPassword2.text.toString().isEmpty()){
            editTextTextPassword2.error="Please Enter password"
            editTextTextPassword2.requestFocus()
            return
        }


        auth.createUserWithEmailAndPassword(editTextTextEmailAddress2.text.toString(),
            editTextTextPassword2.text.toString()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    user!!.sendEmailVerification()
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                            }
                        }
                } else {
                    // If sign in fails, display a message to the user.
                  Toast.makeText(baseContext, "Sign Up failed. Try after some time",
                  Toast.LENGTH_SHORT).show()
                }
            }

    }// end sign up
}