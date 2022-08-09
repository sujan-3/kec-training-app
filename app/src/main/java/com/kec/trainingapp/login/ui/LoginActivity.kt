package com.kec.trainingapp.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kec.trainingapp.data.Validator
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

        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val name = sharedPref.getString("uname", "")
        if(!name.isNullOrEmpty()){
            binding?.usernameEt?.setText(name)
        }

        viewmodel = ViewModelProvider(this)
            .get(LoginViewModel::class.java)

        binding!!.loginBtn?.setOnClickListener {
            val username = binding!!.usernameEt?.text.toString().trim()

            if(Validator().validateUsername(username)){

            }

            /*if (username.isNotEmpty()) {
                val sharedPref = getPreferences(Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("uname", username)
                editor.apply()
            }


            val goToDashboardIntent =
                Intent(
                    this@LoginActivity,
                    DashboardActivity::class.java
                )

            startActivity(goToDashboardIntent)
            finish()*/
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