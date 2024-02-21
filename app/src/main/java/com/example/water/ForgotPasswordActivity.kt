package com.example.water
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.WindowInsetsController
import android.widget.ProgressBar
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var editTextemail: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        window.insetsController?.hide(WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE)
        editTextemail = findViewById(R.id.edittextforgotpasswordemail)
        auth = Firebase.auth
        progressBar = findViewById(R.id.progresssBar3)
    }
    fun forgotpasswordResetButtonPressed(view: View) {
        resetPassword()
    }
    private fun resetPassword() {
        val textemail: String = editTextemail.text.toString().trim()
        if (!Patterns.EMAIL_ADDRESS.matcher(textemail).matches()) {
            editTextemail.error = "Please Enter a Valid Email"
            editTextemail.requestFocus()
        }
        progressBar.visibility = View.GONE
        auth.signInWithEmailAndPassword(textemail, "dummyPassword")
            .addOnCompleteListener { signInTask ->
                if (signInTask.isSuccessful) {
                    // Email exists, proceed with password reset
                    auth.sendPasswordResetEmail(textemail).addOnCompleteListener { resetTask ->
                        if (resetTask.isSuccessful) {
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                "Please Check Your Email To Reset Password",
                                Toast.LENGTH_LONG
                            ).show()
                            val intent = Intent(this@ForgotPasswordActivity, SignInActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                "Failed To Reset Password: ${resetTask.exception?.message}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                } else {
                    // Email does not exist
                    Toast.makeText(
                        this@ForgotPasswordActivity,
                        "Email does not exist",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }
    }