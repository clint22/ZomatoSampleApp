package com.clintpauldev.zomatosampleapp.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.clintpauldev.zomatosampleapp.data.local.ZomatoUser
import com.clintpauldev.zomatosampleapp.data.remote.responses.Location
import com.clintpauldev.zomatosampleapp.data.remote.responses.LocationResponse
import com.clintpauldev.zomatosampleapp.data.remote.responses.Popularity
import com.clintpauldev.zomatosampleapp.data.repositories.ZomatoRepository
import com.clintpauldev.zomatosampleapp.other.Resource

class FakeZomatoRepository : ZomatoRepository {

    private val zomatoUsers = mutableListOf<ZomatoUser>()
    private val observableAllUser = MutableLiveData<List<ZomatoUser>>(zomatoUsers)
    private val observableUser = MutableLiveData<ZomatoUser>()
    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean) {
        shouldReturnNetworkError = value
    }

    private fun refreshLiveData() {
        observableAllUser.postValue(zomatoUsers)
        observableUser.postValue(getUser())
    }

    private fun getUser(): ZomatoUser? {
        return zomatoUsers[0]
    }


    override suspend fun insertUser(zomatoUser: ZomatoUser) {
        zomatoUsers.add(zomatoUser)
        refreshLiveData()
    }

    override suspend fun deleteUser(zomatoUser: ZomatoUser) {
        zomatoUsers.remove(zomatoUser)
        refreshLiveData()
    }

    override fun observeAllUsers(): LiveData<List<ZomatoUser>> {
        return observableAllUser
    }

    override fun observeUser(username: String, password: String): LiveData<ZomatoUser> {
        return observableUser
    }

    override suspend fun searchForLocation(
        entityId: Int,
        entityType: String
    ): Resource<LocationResponse> {
        return if (shouldReturnNetworkError) {
            Resource.error("Error", null)
        } else {
            Resource.success(
                LocationResponse(
                    link = "sample_link",
                    location = Location(
                        city_id = 9,
                        city_name = "Kaloor",
                        country_id = 1,
                        country_name = "India",
                        entity_id = 3,
                        latitude = "93.1",
                        longitude = "90.2",
                        title = "Kaloor",
                        entity_type = "subzone"
                    ),
                    nearby_restaurants = listOf(),
                    popularity = Popularity(
                        city = "Kochi",
                        nearby_res = listOf(),
                        nightlife_index = "2",
                        nightlife_res = "3",
                        popularity = "5",
                        popularity_res = "6",
                        subzone = "5",
                        subzone_id = 5,
                        top_cuisines = listOf()
                    )
                )
            )
        }
    }


}