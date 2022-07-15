package com.example.pozi_v1.domain.repository

import android.util.Log
import com.example.pozi_v1.data.remote.network.LocationRes
import com.example.pozi_v1.data.remote.network.RetrofitInterface
import com.example.pozi_v1.data.remote.network.Resource
import com.example.pozi_v1.data.repository.api.ServiceRepository
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceRepositoryImpl(
    private val api: RetrofitInterface,
    private val ioDispatcher: CoroutineDispatcher
) : ServiceRepository {

    override suspend fun getPhotoBoothList(): Resource<LocationRes> = withContext(ioDispatcher) {
        try {
            Log.d("임민규","try")
            val response = api.getPhotoBoothList()
            Log.d("임민규","123123"+response.body().toString())
            when {
                response.isSuccessful -> {
                    Resource.success(response.body()!!)
                }
                else -> {
                    Resource.error(null, "오류")
                }
            }
        } catch (e: Exception) {
            Log.d("임민규","catch")
            Log.d("임민규",e.toString())
            Resource.error(null, "서버와 연결오류")
        }
    }

}