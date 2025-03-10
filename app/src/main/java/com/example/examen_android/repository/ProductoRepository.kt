package com.example.examen_android.repository

import androidx.lifecycle.LiveData
import com.example.examen_android.data.remote.ProductoApiService
import com.example.examen_android.model.Productos

class ProductoRepository (private val apiService: ProductoApiService) {

    suspend fun obtenerProductos(
        private val apiService: ProductoApiService

    ) {

        suspend fun obtenerElectronics(): List<Productos>? {
            val response = apiService.getEletronics()
            return if (response.isSuccessful) response.body()?.results else null
        }

        suspend fun obtenerJewelry(): List<Productos>? {
            val response = apiService.getJewelery()
            return if (response.isSuccessful) response.body()?.results else null
        }

        suspend fun obtenerMen(): List<Productos>? {
            val response = apiService.getmen()
            return if (response.isSuccessful) response.body()?.results else null
        }

        suspend fun obtenerWomen(): List<Productos>? {
            val response = apiService.getWomen()
            return if (response.isSuccessful) response.body()?.results else null
        }
        suspend fun obtenerDetalle(): List<Productos>? {
            val response = apiService.getDetalle()
            return if (response.isSuccessful) response.body()?.results else null
        }

    }
}