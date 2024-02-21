package com.example.water

import android.os.Bundle
import android.view.Window
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.water.DrawerBaseActivity
import com.example.water.R
import com.example.water.databinding.ActivityCustomerBinding

class CustomerActivity : DrawerBaseActivity() {
    private lateinit var activityCustomerBinding: ActivityCustomerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        activityCustomerBinding = ActivityCustomerBinding.inflate(layoutInflater)
        setContentView(activityCustomerBinding.root)
        allocateActivityTitle("User Profile")
        window.insetsController?.hide(WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE)
    }
}