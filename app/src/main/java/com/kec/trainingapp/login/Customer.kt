package com.kec.trainingapp.login

data class Customer(val id: Long, val name: String) {
    constructor(name: String) : this(0, name)

}
