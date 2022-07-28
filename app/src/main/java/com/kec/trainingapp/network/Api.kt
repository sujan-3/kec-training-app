package com.kec.trainingapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Api {

    val apiService = getRetrofit().create(MyApiService::class.java)

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(getOkhttpClient())
            .baseUrl("https://fcf67f62-6fdb-4721-86d9-be64b54dc63b.mock.pstmn.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getOkhttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }
}