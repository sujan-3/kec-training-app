package com.kec.trainingapp.login.vm

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    companion object {
        val EMPTY_USERNAME = "Username is empty"
        val INVALID_USERNAME = "Username does not match"
    }

    fun checkValidation(username: String): String {
        // Validation logic
        if (username.isEmpty()) {
            Log.d("LoginActivity", "username is empty")

            return EMPTY_USERNAME
        }
        if (!username.contentEquals("a", true)) {
            Log.d("LoginActivity", "username is empty")

            return INVALID_USERNAME;
        }

        return ""
    }
}