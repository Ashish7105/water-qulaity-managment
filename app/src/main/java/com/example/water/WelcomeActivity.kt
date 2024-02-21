package com.example.water

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsetsController
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database


class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        window.insetsController?.hide(WindowInsetsController.BEHAVIOR_DEFAULT)
        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("Sanket Jha");
        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(String::class.java)
                Log.d("WATER_DELIVERY_APP","Value is: " + value);
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }
    fun onButtonSignUpClicked(view: View) {
        val intent = Intent(this@WelcomeActivity, SignupActivity::class.java)
        startActivity(intent)
    }
    fun onButtonSignInClicked(view: View) {
        val intent = Intent(this@WelcomeActivity, SignInActivity::class.java)
        startActivity(intent)
    }
}