package com.clintpauldev.zomatosampleapp.data.repositories

import androidx.lifecycle.LiveData
import com.clintpauldev.zomatosampleapp.data.local.ZomatoDao
import com.clintpauldev.zomatosampleapp.data.local.ZomatoUser
import com.clintpauldev.zomatosampleapp.data.remote.ZomatoApi
import com.clintpauldev.zomatosampleapp.data.remote.responses.LocationResponse
import com.clintpauldev.zomatosampleapp.other.Resource
import javax.inject.Inject

class DefaultZomatoRepository @Inject constructor(
    private val zomatoDao: ZomatoDao,
    private val zomatoApi: ZomatoApi
) : ZomatoRepository {
    override suspend fun insertUser(zomatoUser: ZomatoUser) {
        zomatoDao.insertUser(zomatoUser)
    }

    override suspend fun deleteUser(zomatoUser: ZomatoUser) {
        zomatoDao.deleteUser(zomatoUser)
    }

    override fun observeAllUsers(): LiveData<List<ZomatoUser>> {
        return zomatoDao.observeAllUsers()
    }

    override fun observeUser(username: String, password: String): LiveData<ZomatoUser> {
        return zomatoDao.observeUser(
            username, password
        )
    }

    override suspend fun searchForLocation(
        entityId: Int,
        entityType: String
    ): Resource<LocationResponse> {
        return try {
            val response = zomatoApi.searchForLocation(entityId, entityType)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("An unknown error occurred", null)
            } else {
                Resource.error("An unknown error occurred", null)
            }
        } catch (e: Exception) {
            Resource.error("Couldn't reach the server. Please check the internet connection", null)
        }
    }
}