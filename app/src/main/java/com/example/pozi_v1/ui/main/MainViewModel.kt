package com.example.pozi_v1.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pozi_v1.data.remote.model.Locations
import com.example.pozi_v1.data.remote.network.LocationRes
import com.example.pozi_v1.data.remote.network.Resource
import com.example.pozi_v1.data.repository.api.ServiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val serviceRepository: ServiceRepository) :
    ViewModel() {

    private val _photoBoothList: MutableLiveData<Resource<LocationRes>> =
        MutableLiveData()
    val photoBoothList: LiveData<Resource<LocationRes>> get() = _photoBoothList

    fun getCenterList() {
        CoroutineScope(Dispatchers.IO).launch {
            _photoBoothList.postValue(serviceRepository.getPhotoBoothList())
        }
    }

//    fun getCenterList() = viewModelScope.launch {
//        _photoBoothList.postValue(serviceRepository.getPhotoBoothList())
//    }
}