package com.example.alluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alluvery.model.Product
import com.example.alluvery.sampledata.sampleProducts


@Composable
fun ShowAllProducts(products: List<Product>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp),
    contentPadding = PaddingValues(16.dp)
    ) {
        item(span = {
            GridItemSpan(maxLineSpan)
        }) {
            Text(text = "Todos produtos", fontSize = 32.sp)
        }
        items(products) { p ->
            PrimeiroProduto(product = p)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DisplayAllProductsScreen(){
    ShowAllProducts(products = sampleProducts)
}

