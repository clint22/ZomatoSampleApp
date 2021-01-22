package com.clintpauldev.zomatosampleapp.data.remote

import com.clintpauldev.zomatosampleapp.data.remote.responses.LocationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ZomatoApi {

    @GET("/location_details/")
    suspend fun searchForLocation(
        @Query("entity_id") entityId: Int,
        @Query("entity_type") entityType: String
    ): Response<LocationResponse>

}
