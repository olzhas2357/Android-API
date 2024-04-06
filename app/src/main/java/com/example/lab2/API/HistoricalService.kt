package com.example.lab2.API

import com.example.lab2.model.Historical
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HistoricalService {
    @GET("v1/historicalfigures")
    fun fetchHistoricalList(@Query("name") name: String): Call<List<Historical>>
}