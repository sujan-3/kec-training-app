package com.kec.trainingapp.network

import com.kec.trainingapp.data.MyItem
import retrofit2.http.GET

interface MyApiService {

    @GET("api/items")
    fun getItems(): retrofit2.Call<List<MyItem>>
}