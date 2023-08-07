package com.example.alluvery.sampledata

import com.example.alluvery.R
import com.example.alluvery.model.Product
import java.math.BigDecimal

val sampleProduct = listOf(
    Product(
        nome = "Hamburguer",
        preco = BigDecimal(25.90),
        imagem = R.drawable.burger,
        descricao = "Um suculento hambúrguer de fraldinha de 150g, acompanhado de bacon crocante, queijo derretido e uma refrescante salada. A combinação perfeita de sabor e textura em um único hambúrguer!"
    ),
    Product(
        "Batata-frita",
        BigDecimal(9.90),
        R.drawable.fries,
        "Irresistivelmente crocante por fora, macia por dentro. Nossas batatas fritas são um prazer sensorial em cada mordida. Experimente o equilíbrio perfeito de sabor e textura neste delicioso petisco! "
    ),
    Product(
        "Pizza Napolitana",
        BigDecimal(34.90),
        R.drawable.pizza,
        "Autêntica e apaixonante! Massa leve, macia e aerada, combinada com molho de tomate fresco e cremosa muçarela. Toques finais de manjericão e azeite de oliva. Uma experiência única da tradição italiana em cada mordida. Buon appetito!"
    )

)