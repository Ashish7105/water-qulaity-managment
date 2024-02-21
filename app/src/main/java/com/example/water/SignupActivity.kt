package com.example.water
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ProgressBar
import android.view.View
import android.view.WindowInsetsController
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.android.gms.tasks.Task
class SignupActivity : AppCompatActivity() {
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        window.insetsController?.hide(WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE)
        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber)
        progressBar = findViewById(R.id.progressBar)
        auth = Firebase.auth
    }
    fun onButtonSignUpClicked(view: View) {
        val txtUsername: String = editTextUsername.text.toString().trim()
        val txtPassword: String = editTextPassword.text.toString().trim()
        val txtEmail: String = editTextEmail.text.toString().trim()
        val txtPhoneNumber: String = editTextPhoneNumber.text.toString().trim()
        if (txtUsername.isEmpty()) {
            editTextUsername.error = "Please Enter Username"
            editTextUsername.requestFocus()
        } else if (txtPassword.isEmpty()) {
            editTextPassword.error = "Please Enter Password containing at least 6 characters"
            editTextPassword.requestFocus()
        } else if (txtEmail.isEmpty()) {
            editTextEmail.error = "Please Enter Email"
            editTextEmail.requestFocus()
        } else if (txtPhoneNumber.isEmpty()) {
            editTextPhoneNumber.error = "Please Enter Phone Number"
            editTextPhoneNumber.requestFocus()
        } else {
            progressBar.visibility = View.VISIBLE
            auth.createUserWithEmailAndPassword(txtEmail, txtPassword)
                .addOnCompleteListener { task: Task<AuthResult> ->
                    if (task.isSuccessful) {
                        val user = User(txtUsername, txtPassword, txtEmail, txtPhoneNumber)
                        FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().currentUser!!.uid)
                            .setValue(user)
                            .addOnCompleteListener { innerTask: Task<Void> ->
                                if (innerTask.isSuccessful) {
                                    Toast.makeText(this@SignupActivity, "User Registered Successfully", Toast.LENGTH_LONG).show()
                                    progressBar.visibility = View.GONE
                                } else {
                                    Toast.makeText(this@SignupActivity, "User Failed To Register", Toast.LENGTH_LONG).show()
                                    progressBar.visibility = View.GONE
                                }
                            }
                    } else {
                        Toast.makeText(this@SignupActivity, "User Failed To Register", Toast.LENGTH_LONG).show()
                        progressBar.visibility = View.GONE
                    }
                }
        }
    }
}
