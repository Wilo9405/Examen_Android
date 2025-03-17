package com.example.examen_android.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.examen_android.model.Productos
import com.example.examen_android.repository.ProductoRepository
import kotlinx.coroutines.launch

class ProductoViewModel(application: Application, private val repository: ProductoRepository) : AndroidViewModel(application) {
    private val _products = MutableLiveData<List<Productos>>()
    val products: LiveData<List<Productos>> get() = _products

    fun fetchProducts(category: String) {
        viewModelScope.launch {
            try {
                val productList = repository.fetchProductsByCategory(category)
                _products.postValue(productList ?: emptyList())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
