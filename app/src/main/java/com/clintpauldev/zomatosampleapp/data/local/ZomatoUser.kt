package com.clintpauldev.zomatosampleapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "zomato_user")
data class ZomatoUser(
    val username: String,
    val password: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)