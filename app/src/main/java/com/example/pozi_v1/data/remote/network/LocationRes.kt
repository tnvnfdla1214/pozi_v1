package com.example.pozi_v1.data.remote.network

import com.example.pozi_v1.data.remote.model.Locations
import com.google.gson.annotations.SerializedName

class LocationRes {
    @SerializedName("items")
    val locations: List<Locations> = listOf()
}