package com.example.examen_android.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen_android.R
import com.example.examen_android.data.remote.RetrofitInstance
import com.example.examen_android.databinding.ActivityDetalleProductoBinding
import com.example.examen_android.model.Productos
import com.example.examen_android.repository.ProductoRepository
import com.example.examen_android.viewModel.FactoryViewModel
import com.example.examen_android.viewModel.ProductoViewModel
import com.squareup.picasso.Picasso

class DetalleProducto : AppCompatActivity() {
    private lateinit var binding: ActivityDetalleProductoBinding

    private var product: Productos? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar la Toolbar
        setSupportActionBar(binding.toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Agrega botón de regreso

        // Obtener el producto desde el intent
        product = intent.getParcelableExtra("PRODUCT")
        product?.let { updateUI(it) }
    }

    private fun updateUI(product: Productos) {
        supportActionBar?.title = product.title // Cambia el título de la Toolbar
        Picasso.get().load(product.image).into(binding.ivProductImage)
        binding.tvProductName.text = product.title
        binding.tvProductPrice.text = "${product.price}€"
        binding.tvProductDescription.text = product.description
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu) // Usa el mismo menú de MainActivity
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

        // Volver a MainActivity enviando la categoría seleccionada
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("CATEGORY", category)
        }
        startActivity(intent)
        finish() // Cierra la pantalla de detalle

        return true
    }
}