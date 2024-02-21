package com.example.water

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.util.Patterns
import android.view.WindowInsetsController
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class SignInActivity : AppCompatActivity() {
    private lateinit var editTextuserName: EditText
    private lateinit var editTextpassword: EditText
    private lateinit var textViewForgotPassword: TextView
    private lateinit var textViewRegister: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        window.insetsController?.hide(WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE)
        editTextuserName = findViewById(R.id.txtsigninemailid)
        editTextpassword = findViewById(R.id.txtsigninpassword)
        textViewForgotPassword = findViewById(R.id.txtsigninforgotpassword)
        textViewRegister = findViewById(R.id.txtsigninregister)
        progressBar = findViewById(R.id.progressBar2)
        auth = Firebase.auth
    }

    fun txtSignInForgotPasswordClicked(view: View) {
        val intent = Intent(this@SignInActivity, ForgotPasswordActivity::class.java)
        startActivity(intent)
    }
    fun txtSignInRegisterClicked(view: View) {
        val intent = Intent(this@SignInActivity, SignupActivity::class.java)
        startActivity(intent)
    }
    fun buttonSignInScrSignInClicked(view: View) {
        val textuserName: String = editTextuserName.text.toString().trim()
        val textpassword: String = editTextpassword.text.toString().trim()
        if (!Patterns.EMAIL_ADDRESS.matcher(textuserName).matches()) {
            editTextuserName.error = "Please Enter a Valid Email"
            editTextuserName.requestFocus()
        }
        if (editTextpassword.text.length < 6) {
            editTextpassword.error = "Please Enter Password containing at least 6 characters"
            editTextpassword.requestFocus()
        }
        progressBar.visibility = View.VISIBLE
        auth.signInWithEmailAndPassword(textuserName, textpassword)
            .addOnCompleteListener { task: Task<AuthResult> ->
                if (task.isSuccessful) {
                    Toast.makeText(this@SignInActivity, "Sign In Successful", Toast.LENGTH_LONG).show()
                    progressBar.visibility = View.GONE
                    val intent = Intent(this@SignInActivity, DashboardActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@SignInActivity, "Sign In Failed", Toast.LENGTH_LONG).show()
                    progressBar.visibility = View.GONE
                }
            }
    }
}
