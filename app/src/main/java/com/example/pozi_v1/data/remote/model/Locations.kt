package com.example.pozi_v1.data.remote.model

import java.util.*

data class Locations(
    val id: Int,
    val address: String,
    val lat: Double,
    val lng: Double,
    val name: String
)
