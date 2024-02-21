package com.example.water
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.appcompat.widget.Toolbar as AppCompatToolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.ActionBarDrawerToggle as AppCompatDrawerToggle


open class DrawerBaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout

    override fun setContentView(view: View) {
        drawerLayout = layoutInflater.inflate(R.layout.activity_drawer_base, null) as DrawerLayout
        val container: FrameLayout = drawerLayout.findViewById(R.id.activityContainer)
        container.addView(view)
        super.setContentView(drawerLayout)
        val toolbar: AppCompatToolbar = drawerLayout.findViewById(R.id.tool)
        setSupportActionBar(toolbar)
        val navigationView: NavigationView = drawerLayout.findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        val menu: Menu = navigationView.menu
        menu.add(Menu.NONE, R.id.nav_dashboard, Menu.NONE, "Dashboard")
        val dashboardItem = navigationView.menu.findItem(R.id.nav_dashboard)
        dashboardItem.setIcon(R.drawable.dashboard)
        val toggle = AppCompatDrawerToggle(this, drawerLayout, toolbar, R.string.menu_drawer_open,R.string.menu_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)
        Log.d("DrawerItemSelected", "Selected item: " + item.title)

        when (item.itemId) {
            R.id.nav_customers -> {
                startActivity(Intent(this, CustomerActivity::class.java))
                overridePendingTransition(0, 0)
                return true
            }
            R.id.nav_orders -> {
                startActivity(Intent(this, OrderActivity::class.java))
                overridePendingTransition(0, 0)
                return true
            }
            R.id.nav_sales -> {
                startActivity(Intent(this, SalesActivity::class.java))
                overridePendingTransition(0, 0)
                return true
            }
            R.id.nav_delivery -> {
                startActivity(Intent(this, DeliveryActivity::class.java))
                overridePendingTransition(0, 0)
                return true
            }
            R.id.nav_brands -> {
                startActivity(Intent(this, BrandsActivity::class.java))
                overridePendingTransition(0, 0)
                return true
            }
            R.id.nav_dashboard -> {
                startActivity(Intent(this, DashboardActivity::class.java))
                overridePendingTransition(0, 0)
                return true
            }
            else -> return false
        }
    }
    protected fun allocateActivityTitle(titleString: String) {
        supportActionBar?.title = titleString
    }
}