package com.kec.trainingapp.network

import android.telecom.Call
import com.kec.trainingapp.data.MyItem
import okhttp3.ResponseBody
import retrofit2.http.*

interface MyApiService {

    @GET("api/items")
    fun getItems(): retrofit2.Call<List<MyItem>>

    @GET("api/items")
    fun getSortedItems(
        @Query("sort") sortType: String,
        @Query("size") size: Int
    ): retrofit2.Call<List<MyItem>>

    @GET("api/user/{id}/items")
    fun getData(
        @Path("id") id: String
    ): retrofit2.Call<List<MyItem>>

    @POST("api/save")
    fun save(
        @Body myItem: MyItem
    ): retrofit2.Call<ResponseBody>
}