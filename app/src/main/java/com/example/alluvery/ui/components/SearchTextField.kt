package com.example.alluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SearchBar(searchText: String = ""){
    var text by remember{ mutableStateOf(searchText)}
    OutlinedTextField(
        value = text,
        onValueChange = { newValue ->
            text = newValue
        },
        Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(25),
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "icone de busca")
        },
        label = {
            Text(text = "Produto")
        },
        placeholder = {
            Text("O que você procura?")
        }

    )
    LazyColumn(
            Modifier
                .fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    contentPadding = PaddingValues(bottom = 16.dp)
    ){
        if(text.isBlank()) {
            for (section in sections) {
                val title = section.key
                val products = section.value
                item {
                    ProductsSection(
                        title = title,
                        products = products
                    )
                }
            }
    }
}