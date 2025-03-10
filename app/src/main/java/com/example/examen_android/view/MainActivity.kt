package com.example.examen_android.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen_android.R
import com.example.examen_android.viewModel.ProductoViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var  viewModel: ProductoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarProducto()
        binding.rvProducto.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        cargarProducto()
    }

    private fun cargarProducto() {
        when (listaActiva) {
            "cartelera" -> {
                viewModel.cargarProdcutos(1) { peliculas ->
                    handleEmptyView(productos.toMutableList())
                    adapter.updateData(productos)
                }
                this.setTitle("")
            }

    }
}