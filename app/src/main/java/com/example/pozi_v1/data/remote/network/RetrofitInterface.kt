package com.example.pozi_v1.data.remote.network

import com.example.pozi_v1.data.remote.url.LocationsUrl
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {
    @GET(LocationsUrl.LOCATION_URL)
    suspend fun getPhotoBoothList(): Response<LocationRes>
}