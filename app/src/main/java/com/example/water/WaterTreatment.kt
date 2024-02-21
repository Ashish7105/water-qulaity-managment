package com.example.water

import android.os.Bundle
import android.view.Window
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.water.DrawerBaseActivity
import com.example.water.R
import com.example.water.databinding.ActivitySalesBinding

class SalesActivity : DrawerBaseActivity() {
    private lateinit var activitySalesBinding: ActivitySalesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        activitySalesBinding = ActivitySalesBinding.inflate(layoutInflater)
        setContentView(activitySalesBinding.root)
        allocateActivityTitle("Water Treatment")
        window.insetsController?.hide(WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE)
    }
}