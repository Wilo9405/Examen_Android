package com.example.examen_android.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
        private const val BASE_URL = "https://fakestoreapi.com/"

        val api: ProductoService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProductoService::class.java)
        }
    }
