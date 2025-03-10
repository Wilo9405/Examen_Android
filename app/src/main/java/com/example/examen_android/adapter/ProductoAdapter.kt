package com.example.examen_android.adapter

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_android.R
import com.example.examen_android.model.Productos

class ProductoAdapter (private var producto: MutableList<Productos>,
                       private val onClickListener:(Productos) -> Unit): RecyclerView.Adapter<ProductoViewHolder>() {

    fun updateData(newProcuto: List<Productos>) {
        var tamanho = producto.size
        producto.clear()
        notifyItemRangeRemoved(0,tamanho)
        producto.addAll(newProcuto)
        tamanho = producto.size
        notifyItemRangeInserted(0,tamanho)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    override fun getItemCount()= producto.size

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        holder.bind(producto[position], onClickListener)
    }
}