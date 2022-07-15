package com.example.pozi_v1.data.repository.api

import com.example.pozi_v1.data.remote.network.LocationRes
import com.example.pozi_v1.data.remote.network.Resource

interface ServiceRepository {
    suspend fun getPhotoBoothList(): Resource<LocationRes>
}