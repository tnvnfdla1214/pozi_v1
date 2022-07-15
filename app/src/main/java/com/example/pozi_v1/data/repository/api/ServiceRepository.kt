package com.example.pozi_v1.data.repository.api

import androidx.lifecycle.MutableLiveData
import com.example.pozi_v1.data.remote.model.Locations

interface ServiceRepository {
    suspend fun getPhotoBoothList(): List<Locations>
}