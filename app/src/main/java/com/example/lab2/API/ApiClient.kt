package com.example.lab2.API

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val client = OkHttpClient.Builder()
        .addInterceptor{chain ->
            val request = chain.request()
                val newRequest = request.newBuilder()
                    .addHeader("X-Api-Key", "PWU1nmitwheMfx/InU7Lhg==MDYAlBjfLtJYasiU")
                .build()
            chain.proceed(newRequest)
        }
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.api-ninjas.com/").client(client)
        .addConverterFactory(GsonConverterFactory.create()).build()
    val instance: HistoricalService? = retrofit.create(HistoricalService::class.java)
}