package com.example.examen_android.adapter

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_android.R
import com.example.examen_android.databinding.ItemProductoBinding
import com.example.examen_android.model.Productos

class ProductoAdapter (private var products: List<Productos>, private val onClick: (Productos) -> Unit) :
    RecyclerView.Adapter<ProductoViewHolder>() {

    fun updateData(newProducts: List<Productos>) {
        products = newProducts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val binding = ItemProductoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductoViewHolder(binding, onClick)
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        holder.bind(products[position])
    }
}