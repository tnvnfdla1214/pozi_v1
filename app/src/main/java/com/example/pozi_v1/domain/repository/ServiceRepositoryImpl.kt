package com.example.pozi_v1.domain.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pozi_v1.data.remote.model.Locations
import com.example.pozi_v1.data.remote.network.LocationRes
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
    override suspend fun getPhotoBoothList(): List<Locations> {
        var responseData: List<Locations> = listOf()
        api.also {
            api.getPhotoBoothList().enqueue(object : Callback<LocationRes> {
                override fun onResponse(
                    call: Call<LocationRes>,
                    response: Response<LocationRes>
                ) {
                    if (response.isSuccessful) {
                        // code == 200

                        //Log.d("임민규",response.body()!!.locations.toString()) //두번 불리는 이유
                        responseData = response.body()!!.locations

//                        response.body()?.let { data ->
//                            Log.d("민규",data.toString().get(0).toString())
//                            responseData = data.locations
//                        }
//                        CoroutineScope(ioDispatcher).launch {
//                            //Log.d("임민규",response.body()!!.locations.toString()) //두번 불리는 이유
//                            response.body()?.let { dto ->
//                               //responseData.add(dto)
//                            }
//                        }
                    } else {
                        // code == 400
                    }
                }

                override fun onFailure(call: Call<LocationRes>, t: Throwable) {
                    //실패
                }
            })
        }

        return responseData
    }
}