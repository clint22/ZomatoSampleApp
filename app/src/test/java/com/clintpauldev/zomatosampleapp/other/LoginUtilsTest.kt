package com.clintpauldev.zomatosampleapp.other

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LoginUtilsTest {

    @Test
    fun `username empty returns false`() {
        val result = LoginUtils.loginValidation(username = "", password = "abcdef")
        assertThat(result).isFalse()
    }

    @Test
    fun `password empty returns false`() {
        val result = LoginUtils.loginValidation(username = "username", password = "")
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and password returns true`() {
        val result = LoginUtils.loginValidation(username = "username", password = "abcdef")
        assertThat(result).isTrue()
    }

}