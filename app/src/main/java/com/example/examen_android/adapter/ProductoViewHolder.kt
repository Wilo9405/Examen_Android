package com.example.examen_android.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_android.model.Productos
import com.squareup.picasso.Picasso

class ProductoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemProductoBinding.bind(view)

    fun bind(producto: Productos, onClickListener: (Productos) -> Unit) {
        binding.tvImgProducto.text = producto.title
        Picasso.get().load("https://image.tmdb.org/t/p/w500${producto.image}")
            .into(binding.ivPosterPeli)

        itemView.setOnClickListener {
            onClickListener(producto)
        }
    }
}