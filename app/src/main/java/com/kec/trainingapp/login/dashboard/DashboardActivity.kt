package com.kec.trainingapp.login.dashboard

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.kec.trainingapp.R
import com.kec.trainingapp.databinding.ActivityDashboardBinding
import com.kec.trainingapp.login.Customer

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

    //    playingWithLists()

      //  playingWithMap()

        playingWithCustomerCollection();
    }

    private fun playingWithCustomerCollection() {
        val customers = mutableListOf<Customer>();
        customers.add(Customer(1, "Pratik"))
        customers.add(Customer(2, "Pratik2"))
        customers.add(Customer(3, "Pratik3"))
        customers.add(Customer(4, "Pratik4"))
        customers.add(Customer(5, "Pratik5"))

        Log.d("COLLECTION", "customers: " + customers)

        customers.removeAt(3)

        Log.d("COLLECTION", "customers: " + customers)
    }

    private fun playingWithMap() {
        val mutableMap = mutableMapOf<Int, String>()
        mutableMap.put(1, "Thi sis one")

        Log.d("COLLECTION", "mutableMap: " + mutableMap)
    }

    private fun playingWithLists()  {
        var mutableList = mutableListOf<Int>(1, 3, 5)

        Log.d("COLLECTION", "mutableList: " + mutableList)
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