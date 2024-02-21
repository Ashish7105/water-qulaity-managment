package com.example.water

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.view.WindowInsetsController

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val textview = findViewById<TextView>(R.id.textSplashScreen)
        textview.animate().apply {
            translationX(1000f)
            duration = 1000
            startDelay=2500
            alpha(0f)
        }.start()
        val thread = Thread {
            try {
                Thread.sleep(4000)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                val intent = Intent(this@SplashActivity, WelcomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        thread.start()
    }
}