package com.example.venus_zhierly.Data.Api

import com.example.venus_zhierly.Data.Model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}