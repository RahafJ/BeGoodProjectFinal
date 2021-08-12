package com.example.begoodproject

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sign_up.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_BeGoodProject)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()


        btnSignUp.setOnClickListener{
            startActivity(Intent(this, SignUp::class.java))
            finish()
        }// end sign up button intent function

       btnLogin.setOnClickListener {
           doLogin();
       }

    }

    private fun doLogin() {
                if (!Patterns.EMAIL_ADDRESS.matcher(editTextTextEmailAddress.text.toString()).matches()){
                    editTextTextEmailAddress.error="Please Enter Valid Email"
                    editTextTextEmailAddress.requestFocus()
                return
            }

            if (editTextTextPassword.text.toString().isEmpty()){
                editTextTextPassword.error="Please Enter password"
                editTextTextPassword.requestFocus()
                return
            }// end email validation
        auth.signInWithEmailAndPassword(editTextTextEmailAddress.text.toString(), editTextTextPassword.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Toast.makeText(baseContext, "Log in failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }// end else authentication

            }// end sign in with email and password


        }// end do login function

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
        }// end on start function

    private fun updateUI(currentUser: FirebaseUser?) {
            if (currentUser !=null ){
                if(currentUser.isEmailVerified){
                    Toast.makeText(baseContext,"Hiiiiii",Toast.LENGTH_LONG).show()
                    startActivity( Intent(this,homepage::class.java))
                    finish()
                }else{
                    Toast.makeText(baseContext, "Please verify your email address .",
                        Toast.LENGTH_SHORT).show()
                }
            }
        else{
                Toast.makeText(baseContext, "Login failed.",
                    Toast.LENGTH_SHORT).show()
            }

    }
}


