package com.example.water

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowInsetsController
import android.view.WindowManager
import com.example.water.databinding.ActivityDeliveryBinding

class DeliveryActivity : AppCompatActivity() {

    private lateinit var activityDeliveryBinding: ActivityDeliveryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        activityDeliveryBinding = ActivityDeliveryBinding.inflate(layoutInflater)
        setContentView(activityDeliveryBinding.root)
        allocateActivityTitle("Delivery")
        window.insetsController?.hide(WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE)
    }

    private fun allocateActivityTitle(s: String) {

    }
}