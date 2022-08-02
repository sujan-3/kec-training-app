package com.kec.trainingapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val message = MutableLiveData<String>()

    fun sendMessage(msg: String) {
        Log.d("MSG calling from vm", "calling from add fragment")

        message.value = msg
    }

    fun getM(): MutableLiveData<String> {
        return message
    }
}