package com.example.water

import android.os.Bundle
import android.view.Window
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.water.DrawerBaseActivity
import com.example.water.R
import com.example.water.databinding.ActivityOrderBinding

class OrderActivity : DrawerBaseActivity() {
    private lateinit var activityOrderBinding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        activityOrderBinding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(activityOrderBinding.root)
        allocateActivityTitle("Consult Us")
        window.insetsController?.hide(WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE)
    }
}