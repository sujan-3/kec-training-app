package com.kec.trainingapp

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kec.trainingapp.databinding.ActivityMainDupBinding
import com.kec.trainingapp.login.dashboard.AddFragment
import com.kec.trainingapp.login.dashboard.ListFragment


class MainActivity : AppCompatActivity() {

    private lateinit var activeFragment: Fragment
    lateinit var binding: ActivityMainDupBinding

    private val viewModel: MainViewModel by viewModels()

    private val TAG = "MainActivity"

    lateinit var addFragment: AddFragment
    lateinit var listFragment: ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainDupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragment = AddFragment()
        listFragment = ListFragment()

        binding.bottomNavigation.setOnNavigationItemSelectedListener(navListener)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, listFragment).hide(listFragment).commit()

        // as soon as the application opens the first
        // fragment should be shown to the user
        // in this case it is algorithm fragment

        // as soon as the application opens the first
        // fragment should be shown to the user
        // in this case it is algorithm fragment
        supportFragmentManager.beginTransaction()
            .add(R.id.container, addFragment).commit()
        activeFragment = addFragment

        viewModel.getM().observe(this, Observer {
            Log.d(TAG, "MSG called in activity " + it)
        })

    }

    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item -> // By using switch we can easily get
            // the selected fragment
            // by using there id.
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_add ->{
                    supportFragmentManager
                        .beginTransaction()
                        .hide(activeFragment)
                        .show(addFragment)
                        .commit()

                    activeFragment = addFragment
                }
                R.id.nav_list -> {
                    supportFragmentManager
                        .beginTransaction()
                        .hide(activeFragment)
                        .show(listFragment)
                        .commit()

                    activeFragment = listFragment
                }
            }
            // It will help to replace the
            // one fragment to other.
            true
        }
}