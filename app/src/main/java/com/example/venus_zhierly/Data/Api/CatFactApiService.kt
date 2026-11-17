package com.example.venus_zhierly.Data.Api

import com.example.venus_zhierly.Data.Model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}