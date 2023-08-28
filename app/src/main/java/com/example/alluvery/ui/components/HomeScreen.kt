package com.example.alluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alluvery.model.Product
import com.example.alluvery.sampledata.sampleProducts
import com.example.alluvery.sampledata.sampleSections
import com.example.alluvery.ui.theme.AlluveryTheme

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    searchText: String = ""
) {
    Column {
        SearchBar(searchText)
        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(sampleProducts) { p ->
                CardProductItem(
                    product = p,
                )
            }
        }
    }
}


