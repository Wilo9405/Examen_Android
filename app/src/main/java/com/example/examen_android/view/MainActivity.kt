package com.example.examen_android.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examen_android.R
import com.example.examen_android.adapter.ProductoAdapter
import com.example.examen_android.data.remote.RetrofitInstance
import com.example.examen_android.databinding.ActivityMainBinding
import com.example.examen_android.repository.ProductoRepository
import com.example.examen_android.viewModel.FactoryViewModel
import com.example.examen_android.viewModel.ProductoViewModel

class MainActivity : AppCompatActivity() {private lateinit var binding: ActivityMainBinding
    private val viewModel: ProductoViewModel by viewModels {
        FactoryViewModel(ProductoRepository(RetrofitInstance.api))
    }
    private lateinit var adapter: ProductoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setupRecyclerView()
        observeViewModel()

        // ✅ Obtener la categoría desde DetalleProducto o por defecto "electronics"
        val category = intent.getStringExtra("CATEGORY") ?: "electronics"
        updateToolbarTitle(category) // ✅ Cambia el título de la Toolbar según la categoría
        viewModel.fetchProducts(category)
    }

    private fun setupRecyclerView() {
        adapter = ProductoAdapter(emptyList()) { product ->
            val intent = Intent(this, DetalleProducto::class.java).apply {
                putExtra("PRODUCT", product)
            }
            startActivity(intent)
        }
        binding.rvProducto.layoutManager = LinearLayoutManager(this)
        binding.rvProducto.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.products.observe(this) { products ->
            adapter.updateData(products)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val category = when (item.itemId) {
            R.id.menu_electronics -> "electronics"
            R.id.menu_jewelery -> "jewelery"
            R.id.menu_men -> "men's clothing"
            R.id.menu_women -> "women's clothing"
            else -> return super.onOptionsItemSelected(item)
        }

        updateToolbarTitle(category) // ✅ Actualizar el título de la Toolbar cuando cambia la categoría
        viewModel.fetchProducts(category)
        return true
    }

    // ✅ Función para cambiar el título de la Toolbar según la categoría seleccionada
    private fun updateToolbarTitle(category: String) {
        val categoryTitle = when (category) {
            "electronics" -> "Electrónica"
            "jewelery" -> "Joyería"
            "men's clothing" -> "Ropa Hombre"
            "women's clothing" -> "Ropa Mujer"
            else -> "Productos"
        }
        supportActionBar?.title = categoryTitle
    }
}
