package com.kec.trainingapp.login.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kec.trainingapp.databinding.ActivityMainBinding
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
            // Get username
            val username = binding!!.usernameEt?.text.toString().trim()

            val validationMsg = viewmodel.checkValidation(username)

            if (validationMsg.contentEquals(LoginViewModel.EMPTY_USERNAME)) {
                binding!!.usernameEt?.setError(LoginViewModel.EMPTY_USERNAME)
            } else if (validationMsg.contentEquals(LoginViewModel.INVALID_USERNAME)) {
                binding!!.usernameEt?.setError(LoginViewModel.INVALID_USERNAME)

            } else {
                // Good to login

            }

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