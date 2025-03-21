package com.example.examen_android.model

import android.media.Image
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Productos (
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("price") val price: Double,
    @SerializedName("description") val description:String,
    @SerializedName("category") val category:String,
    @SerializedName("image") val image:String,

) : Parcelable