package com.example.examen_android.data.remote

import com.example.examen_android.model.Productos
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Path

interface ProductoService {
    @GET("products/category/{category}")
    suspend fun getProductsByCategory(@Path("category") category: String): Response<List<Productos>>
}
