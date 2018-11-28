package com.relieve.android.network

import com.relieve.android.network.data.ApiResponse
import com.relieve.android.network.data.Device
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface CamarService {

    @POST("device")
    fun postNewDevice(@Body device: Device): Observable<ApiResponse<Device>>

    companion object {
        fun create(): CamarService {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://35.240.181.2/")
                    .build()

            return retrofit.create(CamarService::class.java)
        }
    }
}