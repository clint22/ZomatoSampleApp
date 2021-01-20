package com.clintpauldev.zomatosampleapp.other

object RegistrationUtils {


    fun registrationValidation(
        username: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (username.isEmpty() || password.isEmpty()) {
            return false
        }
        if (username.length > Constants.USERNAME_MAX_SIZE) {
            return false
        }
        if (password != confirmPassword) {
            return false
        }
        if (username.count { it.isDigit() } < Constants.USERNAME_MAX_DIGITS) {
            return false
        }
        return true
    }


}