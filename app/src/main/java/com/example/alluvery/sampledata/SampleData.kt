package com.example.alluvery.sampledata

import com.example.alluvery.R
import com.example.alluvery.model.Product
import java.math.BigDecimal

val sampleCandies = listOf(
    Product(
        "Chocolate",
         BigDecimal("3.99"),
        "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg",
    ),
    Product(
        "Sorvete",
        BigDecimal("5.99"),
        "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg",
    ),
    Product(
        "Bolo",
        BigDecimal("11.99"),
        "https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg",
    )
)

val sampleDrinks = listOf(
    Product(
        "Cerveja",
        BigDecimal("5.99"),
        "https://images.pexels.com/photos/1552630/pexels-photo-1552630.jpeg",
    ),
    Product(
        "Refrigerante",
        BigDecimal("4.99"),
        "https://images.pexels.com/photos/2775860/pexels-photo-2775860.jpeg"
    ),
    Product(
        "Suco",
        BigDecimal("7.99"),
        "https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg"
    ),
    Product(
        "Água",
        BigDecimal("2.99"),
        "https://images.pexels.com/photos/327090/pexels-photo-327090.jpeg"
    )
)

val sampleProducts: List<Product> = listOf(

    Product(
        "Hamburguer",
        BigDecimal("12.99"),
        "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
    ),
    Product(
        "Pizza",
        BigDecimal("19.99"),
        "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg"
    ),
    Product(
        "Batata frita",
        BigDecimal("7.99"),
        "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg"
), *sampleDrinks.toTypedArray(), *sampleCandies.toTypedArray()
)

val sampleSections = mapOf(
    "Promoções" to sampleProducts,
    "Doces" to sampleCandies,
    "Bebidas" to sampleDrinks
)