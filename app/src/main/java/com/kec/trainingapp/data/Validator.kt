package com.kec.trainingapp.data

class Validator {

    fun validateUsername(username: String?): Boolean {
        if (username == null) {
            throw NullPointerException()
        }

        if (username.length < 8)
            return false

        return true
    }
}