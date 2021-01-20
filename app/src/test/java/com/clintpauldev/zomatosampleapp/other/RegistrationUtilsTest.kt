package com.clintpauldev.zomatosampleapp.other

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilsTest {

    @Test
    fun `empty username returns false`() {

        val result = RegistrationUtils.registrationValidation(username = "", password = "1234", "1234")
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {

        val result = RegistrationUtils.registrationValidation(username = "abcd1234", password = "", "")
        assertThat(result).isFalse()
    }

    @Test
    fun `username length greater than max username length returns false`() {
        val result = RegistrationUtils.registrationValidation(
            username = "abcdefghijklmno",
            password = "1234",
            "1234"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `confirm password not correct as password returns false`() {
        val result =
            RegistrationUtils.registrationValidation(username = "abcdef", password = "zomatoTest", "zoma")
        assertThat(result).isFalse()
    }

    @Test
    fun `username contains less than 2 digits returns false`() {
        val result =
            RegistrationUtils.registrationValidation(username = "abcdef1", password = "zomatoTest", "zoma")
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password valid returns true`() {
        val result = RegistrationUtils.registrationValidation(
            username = "Peter12",
            password = "zomatoTest",
            confirmPassword = "zomatoTest"
        )
        assertThat(result).isTrue()
    }

}