package com.clintpauldev.zomatosampleapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ZomatoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(zomatoUser: ZomatoUser)

    @Delete
    suspend fun deleteUser(zomatoUser: ZomatoUser)

    @Query("SELECT * from zomato_user")
    fun observeAllUsers(): LiveData<List<ZomatoUser>>

    @Query("SELECT * from zomato_user where username= :username AND password= :password")
    fun observeUser(username: String, password: String): LiveData<ZomatoUser>

}