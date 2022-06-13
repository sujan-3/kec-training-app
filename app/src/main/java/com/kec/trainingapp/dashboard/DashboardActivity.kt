package com.kec.trainingapp.dashboard

import android.os.Bundle
import android.view.MenuItem
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationBarView
import com.kec.trainingapp.R
import com.kec.trainingapp.dashboard.fragment.AwayFragment
import com.kec.trainingapp.dashboard.fragment.HomeFragment
import com.kec.trainingapp.databinding.ActivityDashboardBinding
import java.lang.IllegalArgumentException

class DashboardActivity : AppCompatActivity() {

    lateinit var binding: ActivityDashboardBinding

    val homeFragment = HomeFragment()
    val awayFragment = AwayFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goToHome()

        binding.btmNav.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.nav_home -> goToHome()
                    R.id.nav_away -> goToAway()
                    else -> throw IllegalArgumentException()
                }

                return true
            }

        })

    }

    private fun goToAway() {
        supportFragmentManager.beginTransaction().replace(R.id.container, awayFragment).commit()
    }

    private fun goToHome() {
        supportFragmentManager.beginTransaction().replace(R.id.container, homeFragment).commit()

    }
}