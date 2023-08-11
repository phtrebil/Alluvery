package com.example.alluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alluvery.model.Product
import com.example.alluvery.sampledata.sampleProducts

@Composable
fun ListaDeProdutos(titulo: String, products: List<Product>) {
    Column(Modifier.padding(bottom = 8.dp)) {
        Text(
            text = titulo,
            Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )

        LazyRow(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            for (p in products) {
                item {
                    PrimeiroProduto(product = p)
                }

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MostraDisplayListaDeProdutos() {
    ListaDeProdutos("Promoções", products = sampleProducts)
}

