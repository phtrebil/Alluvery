package com.example.alluvery.model

import java.math.BigDecimal

data class Product(
    val nome: String,
    val preco: BigDecimal,
    val imagem: String? = null,
    val descricao: String = ""
)

