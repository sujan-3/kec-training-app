package com.kec.trainingapp.login.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kec.trainingapp.databinding.ActivityMainBinding
import com.kec.trainingapp.login.dashboard.DashboardActivity
import com.kec.trainingapp.login.vm.LoginViewModel

class LoginActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    lateinit var viewmodel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        viewmodel = ViewModelProvider(this)
            .get(LoginViewModel::class.java)

        binding!!.loginBtn?.setOnClickListener {
            val goToDashboardIntent =
                Intent(this@LoginActivity,
                DashboardActivity::class.java)

            startActivity(goToDashboardIntent)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}