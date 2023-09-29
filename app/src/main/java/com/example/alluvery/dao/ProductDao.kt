package com.example.alluvery.dao

import androidx.compose.runtime.mutableStateListOf
import com.example.alluvery.model.Product
import com.example.alluvery.sampledata.sampleProducts

class ProductDao {

    companion object{
        private val productList = mutableStateListOf<Product>(*sampleProducts.toTypedArray())
    }
    fun products() = productList.toList()
    fun save(product: Product) {
        productList.add(product)
    }
}