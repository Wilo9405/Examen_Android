package com.example.examen_android.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen_android.model.Productos
import com.example.examen_android.repository.ProductoRepository
import kotlinx.coroutines.launch

class ProductoViewModel (private val repository: ProductoRepository) : ViewModel() {

    private val _productos = MutableLiveData<List<Productos>>()
    val productos : LiveData<List<Productos>> = _productos


    fun cargarProdcutos(){
        viewModelScope.launch{
            val producto = repository.obtenerProductos()
            if (producto!=null){
                _productos.value = producto ?: emptyList()
            } else {
                println("Error al cargar los productos")
            }
        }
    }
}