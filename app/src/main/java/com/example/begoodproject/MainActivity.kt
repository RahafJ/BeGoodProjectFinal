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
//            finish()
        }// end sign up button intent function

        btnLogin.setOnClickListener{
            doLogin()

        }// end log in button intent function


    }

    private fun doLogin() {
                if (!Patterns.EMAIL_ADDRESS.matcher(editTextTextEmailAddress2.text.toString()).matches()){
                editTextTextEmailAddress2.error="Please Enter Valid Email"
                editTextTextEmailAddress2.requestFocus()
                return
            }

            if (editTextTextPassword2.text.toString().isEmpty()){
                editTextTextPassword2.error="Please Enter password"
                editTextTextPassword2.requestFocus()
                return
            }// end email validation

            auth.signInWithEmailAndPassword(editTextTextEmailAddress2.toString(),
                editTextTextPassword2.toString()
            )
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information

                        val user = auth.currentUser
                        Toast.makeText(baseContext, "Authentication donr --- 100%.",
                            Toast.LENGTH_LONG).show()

                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }
                }
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
                    Log.d(TAG, "Successfully signed in with email link!")
                    startActivity( Intent(this,homepage::class.java))

                }else{
                    Log.e(TAG, "Error signing in with email link")
//                    Toast.makeText(baseContext, "Please verify your email address .",
//                        Toast.LENGTH_SHORT).show()
                }
            }
        else{
                Toast.makeText(baseContext, "Login failed.",
                    Toast.LENGTH_SHORT).show()
            }

    }
}


