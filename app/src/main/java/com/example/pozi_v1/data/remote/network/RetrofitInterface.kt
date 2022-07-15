package com.example.pozi_v1.data.remote.network

import com.example.pozi_v1.data.remote.model.Locations
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("/v3/0ec238c7-aea5-4b6e-b832-426acf16b3d8")
    fun getPhotoBoothList(): Call<Locations>
}