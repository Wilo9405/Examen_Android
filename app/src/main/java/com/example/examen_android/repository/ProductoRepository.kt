package com.example.examen_android.repository


import com.example.examen_android.data.remote.ProductoService
import com.example.examen_android.model.Productos

class ProductoRepository (private val apiService: ProductoService) {

    suspend fun fetchProductsByCategory(category: String): List<Productos>? {
        val response = apiService.getProductsByCategory(category)
        return if (response.isSuccessful) response.body() else null
    }
}