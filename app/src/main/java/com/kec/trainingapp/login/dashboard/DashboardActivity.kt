package com.kec.trainingapp.login.dashboard

import android.app.Activity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.kec.trainingapp.R
import com.kec.trainingapp.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showAddFragment()

        binding.btmNav.setOnNavigationItemSelectedListener(object : NavigationView.OnNavigationItemSelectedListener,
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                if(item.itemId == R.id.nav_add){
                    showAddFragment()
                }else if(item.itemId == R.id.nav_list){
                    showListFragment()
                }

                return true
            }
        })
    }

    private fun showListFragment() {
        val listFragment = ListFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, listFragment).commit()

    }

    private fun showAddFragment() {
        val addFragment = AddFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, addFragment).commit()
    }
}