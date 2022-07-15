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
    override suspend fun getPhotoBoothList(): List<Locations> {
        var responseData = mutableListOf<Locations>()
        api.also {
            api.getPhotoBoothList().enqueue(object : Callback<Locations> {
                override fun onResponse(
                    call: Call<Locations>,
                    response: Response<Locations>
                ) {
                    if (response.isSuccessful) {
                        // code == 200
                        response.body()?.let { dto ->
                            //Log.d("민규1", dto.address)
                            //responseData.add(dto)
                            Log.d("민규1", dto.toString())
                        }

                        CoroutineScope(ioDispatcher).launch {

                            response.body()?.let { dto ->
                                //Log.d("민규1", dto.address)
                                responseData.add(dto)
                                Log.d("민규1", dto.toString())
                            }
                        }
                    } else {
                        // code == 400
                    }
                }

                override fun onFailure(call: Call<Locations>, t: Throwable) {
                    //실패
                }
            })
        }
        return responseData.toList()
    }
}