package com.astro.paybills.data.model

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val anyDiscount: Boolean,
    val discount: Double,
    val taxPercentage: Double,
    val available: Boolean,
    val imageUrl: String,
    val category: String,
    var isSelected: Boolean = false
)
