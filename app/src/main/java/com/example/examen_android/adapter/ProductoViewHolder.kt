package com.example.examen_android.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_android.databinding.ItemProductoBinding
import com.example.examen_android.model.Productos
import com.squareup.picasso.Picasso

class ProductoViewHolder(private val binding: ItemProductoBinding, private val onClick: (Productos) -> Unit) : RecyclerView.ViewHolder(binding.root) {
    fun bind(product: Productos) {
        binding.tvProducto.text = product.title
        Picasso.get().load(product.image).into(binding.ivImgProducto)
        itemView.setOnClickListener { onClick(product) }
    }
}