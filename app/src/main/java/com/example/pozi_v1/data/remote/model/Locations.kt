package com.example.pozi_v1.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class Locations(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("address")
    @Expose
    val address: String,
    @SerializedName("lat")
    @Expose
    val lat: Double,
    @SerializedName("lng")
    @Expose
    val lng: Double,
    @SerializedName("name")
    @Expose
    val name: String
)
