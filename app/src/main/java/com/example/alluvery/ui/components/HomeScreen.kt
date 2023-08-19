package com.example.alluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alluvery.model.Product
import com.example.alluvery.sampledata.sampleProducts
import com.example.alluvery.sampledata.sampleSections

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {
    Column {
        SearchBar()
        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {

            items(sampleProducts) { p ->
                CardProductItem(product = p)
            }

//            for (section in sections) {
//                val title = section.key
//                val products = section.value
//                item {
//                    ListaDeProdutos(
//                        title,
//                        products
//                    )
//                }
//
//            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ShowUi(){
    HomeScreen(sampleSections)
}

