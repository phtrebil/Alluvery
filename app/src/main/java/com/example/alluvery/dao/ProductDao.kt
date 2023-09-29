package com.example.alluvery.dao

import com.example.alluvery.sampledata.sampleProducts

class ProductDao {

    companion object{
        private val productList = sampleProducts.toMutableList()
    }
    fun products() = productList.toList()
}