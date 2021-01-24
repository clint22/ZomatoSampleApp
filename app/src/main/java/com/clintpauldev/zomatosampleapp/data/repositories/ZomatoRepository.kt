package com.clintpauldev.zomatosampleapp.data.repositories

import androidx.lifecycle.LiveData
import com.clintpauldev.zomatosampleapp.data.local.ZomatoUser
import com.clintpauldev.zomatosampleapp.data.remote.responses.LocationResponse
import com.clintpauldev.zomatosampleapp.other.Resource

interface ZomatoRepository {

    suspend fun insertUser(zomatoUser: ZomatoUser)

    suspend fun deleteUser(zomatoUser: ZomatoUser)

    fun observeAllUsers(): LiveData<List<ZomatoUser>>

    fun observeUser(username: String, password: String): LiveData<ZomatoUser>

    suspend fun searchForLocation(entityId: Int, entityType: String): Resource<LocationResponse>
}