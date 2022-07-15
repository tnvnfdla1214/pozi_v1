package com.example.pozi_v1.domain.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pozi_v1.data.remote.model.Locations
import com.example.pozi_v1.data.remote.network.RetrofitInterface
import com.example.pozi_v1.data.repository.api.ServiceRepository
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceRepositoryImpl(
    private val api: RetrofitInterface,
    private val ioDispatcher: CoroutineDispatcher
) : ServiceRepository {
    override suspend fun getPhotoBoothList(): MutableLiveData<Locations> {
        val responseData: MutableLiveData<Locations> = MutableLiveData()
        api.getPhotoBoothList().enqueue(object : Callback<Locations> {
            override fun onResponse(
                call: Call<Locations>,
                response: Response<Locations>
            ) {
                if (response.isSuccessful) {
                    // code == 200
                    CoroutineScope(ioDispatcher).launch {
                        responseData.value = response.body()
                    }
                } else {
                    // code == 400
                }
            }

            override fun onFailure(call: Call<Locations>, t: Throwable) {
                //실패
            }
        })
        return responseData
    }
}