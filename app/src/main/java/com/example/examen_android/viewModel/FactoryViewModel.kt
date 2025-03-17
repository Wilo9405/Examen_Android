package com.example.examen_android.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.examen_android.repository.ProductoRepository

class FactoryViewModel (private val repository: ProductoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductoViewModel::class.java)) {
            return ProductoViewModel(Application(), repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}