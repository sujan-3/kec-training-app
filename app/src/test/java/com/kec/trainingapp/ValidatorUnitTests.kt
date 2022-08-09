package com.kec.trainingapp

import com.kec.trainingapp.data.Validator
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.security.spec.InvalidParameterSpecException
import kotlin.NullPointerException

class ValidatorUnitTests {

    lateinit var validator: Validator

    @Before
    fun setup(){
        validator = Validator()
    }

    @Test(expected = NullPointerException::class)
    fun whenValidated_withNullString_shouldThrowNullPointerException() {
        val username = null

        validator.validateUsername(username)
    }

    @Test
    fun whenValidated_withLessThan7Chars_shouldReturnFalse() {
        val username = "abcdefg"

        Assert.assertFalse(validator.validateUsername(username))
    }
}