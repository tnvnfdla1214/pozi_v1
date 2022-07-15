package com.example.pozi_v1.data.remote.network

import com.example.pozi_v1.data.remote.model.Locations
import com.example.pozi_v1.data.remote.url.LocationsUrl
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET(LocationsUrl.LOCATION_URL)
    fun getPhotoBoothList(): Call<LocationRes>
}