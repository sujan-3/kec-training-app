package com.kec.trainingapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {

    val apiService = getRetrofit().create(MyApiService::class.java)

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fcf67f62-6fdb-4721-86d9-be64b54dc63b.mock.pstmn.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}