package com.astro.paybills.utils

import android.content.Context
import com.astro.paybills.data.model.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Constants {

    fun getData(context: Context): List<Product> {
        val jsonString = context.assets.open("food_products.json")
            .bufferedReader().use { it.readText() }
        val gson = Gson()
        val productListType = object : TypeToken<List<Product>>() {}.type
        val products: List<Product> = gson.fromJson(jsonString, productListType)
        return products
    }

}