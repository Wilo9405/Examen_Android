package com.example.examen_android.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductoApiService {
    @GET("https://fakestoreapi.com/products/category/electronics")
    suspend fun getEletronics(
    ): Response<RetrofitClient>

    @GET("https://fakestoreapi.com/products/category/jewelery")
    suspend fun getJewelery(

    ): Response<RetrofitClient>

    @GET("https://fakestoreapi.com/products/category/men's%20clothing")
    suspend fun getmen(

    ): Response<RetrofitClient>

    @GET("https://fakestoreapi.com/products/category/women's%20clothing")
    suspend fun getWomen(

    ): Response<RetrofitClient>

    @GET("https://fakestoreapi.com/products/7")
    suspend fun getDetalle(

    ): Response<RetrofitClient>

}