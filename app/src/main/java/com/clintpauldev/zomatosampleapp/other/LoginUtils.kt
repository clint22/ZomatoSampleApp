package com.clintpauldev.zomatosampleapp.other

object LoginUtils {

    fun loginValidation(
        username: String,
        password: String
    ): Boolean {
        if (username.isEmpty() || password.isEmpty()) {
            return false
        }
        return true
    }


}