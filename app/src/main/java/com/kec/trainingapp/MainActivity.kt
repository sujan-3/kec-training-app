package com.kec.trainingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kec.trainingapp.databinding.ActivityMainDupBinding
import com.kec.trainingapp.login.dashboard.AddFragment
import com.kec.trainingapp.login.dashboard.ListFragment


class MainActivity: AppCompatActivity() {

    lateinit var binding: ActivityMainDupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainDupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(navListener)

        // as soon as the application opens the first
        // fragment should be shown to the user
        // in this case it is algorithm fragment

        // as soon as the application opens the first
        // fragment should be shown to the user
        // in this case it is algorithm fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, AddFragment()).commit()

    }

    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item -> // By using switch we can easily get
            // the selected fragment
            // by using there id.
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_add -> selectedFragment = AddFragment()
                R.id.nav_list -> selectedFragment = ListFragment()
            }
            // It will help to replace the
            // one fragment to other.
            if (selectedFragment != null) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, selectedFragment)
                    .commit()
            }
            true
        }
}