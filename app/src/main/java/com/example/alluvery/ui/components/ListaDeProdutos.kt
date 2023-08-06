package com.example.alluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alluvery.R
import com.example.alluvery.model.Product
import java.math.BigDecimal

@Composable
fun ListaDeProdutos() {
    Column() {
        Text(
            text = "Promoção",
            Modifier.padding(start = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )

        Row(
            Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PrimeiroProduto(
                Product(
                    nome = "Hamburguer",
                    preco = BigDecimal(25.90),
                    imagem = R.drawable.burger,
                    descricao = "Um suculento hambúrguer de fraldinha de 150g, acompanhado de bacon crocante, queijo derretido e uma refrescante salada. A combinação perfeita de sabor e textura em um único hambúrguer!"
                )
            )
            PrimeiroProduto(
                Product(
                    "Batata-frita",
                    BigDecimal(9.90),
                    R.drawable.fries,
                    "Irresistivelmente crocante por fora, macia por dentro. Nossas batatas fritas são um prazer sensorial em cada mordida. Experimente o equilíbrio perfeito de sabor e textura neste delicioso petisco! "
                )
            )
            PrimeiroProduto(
                Product(
                    "Pizza Napolitana",
                    BigDecimal(34.90),
                    R.drawable.pizza,
                    "Autêntica e apaixonante! Massa leve, macia e aerada, combinada com molho de tomate fresco e cremosa muçarela. Toques finais de manjericão e azeite de oliva. Uma experiência única da tradição italiana em cada mordida. Buon appetito!"
                )
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MostraDisplayListaDeProdutos(){
   ListaDeProdutos()
}