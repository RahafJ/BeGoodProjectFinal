package com.example.begoodproject
//package com.androiddevs.firebasefirestor


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.begoodproject.databinding.SignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.sign_up.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class SignUp : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth
    private lateinit var database:  DatabaseReference
     private lateinit var fStore : FirebaseFirestore
    private lateinit var userid : String
    private lateinit var binding: SignUpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Theme_BeGoodProject)
        setContentView(R.layout.sign_up)
        auth = FirebaseAuth.getInstance()

        btnSignUpLast.setOnClickListener{
            signUpUser()
            val firstname = editTextTextPersonName.text.toString();
            val lastName = editTextTextPersonName2.text.toString();
            val Email = editTextTextEmailAddress2.text.toString();
            val phoneNumber = editTextPhone.text.toString();
        }
}// end on create finction


    private fun saveUsers(users: users) = CoroutineScope(Dispatchers.IO).launch {
        try {

        }catch (e:Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(this@SignUp,e.message,Toast.LENGTH_LONG).show()
            }
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
                                val firstname = editTextTextPersonName.text.toString();
                                val lastName = editTextTextPersonName2.text.toString();
                                val Email = editTextTextEmailAddress2.text.toString();
                                val phoneNumber = editTextPhone.text.toString();
                                saveFirestore(firstname,lastName,Email,phoneNumber)

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

fun saveFirestore(firstname : String, lastname: String, Email: String,phoneNumber: String ){
    val db = FirebaseFirestore.getInstance()
    val user : MutableMap<String, Any> = HashMap()
    user["firstname"] = firstname
    user["lastname"]=lastname
    user["Email"]=Email
    user["phoneNumber"]=phoneNumber
    db.collection("Users").add(user)
        .addOnSuccessListener {
            Toast.makeText(this,"Added Succesfully ",Toast.LENGTH_LONG).show()
            userid = auth.currentUser!!.uid
        }
        .addOnFailureListener{
            Toast.makeText(this,"Added Baddddly ",Toast.LENGTH_LONG).show()
        }
}
}