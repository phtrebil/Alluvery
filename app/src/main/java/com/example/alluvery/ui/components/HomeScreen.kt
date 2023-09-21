package br.com.alura.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alluvery.model.Product
import com.example.alluvery.sampledata.sampleProducts
import com.example.alluvery.sampledata.sampleSections
import com.example.alluvery.sampledata.sampleShopSections
import com.example.alluvery.ui.components.CardProductItem
import com.example.alluvery.ui.components.ListaDeProdutos
import com.example.alluvery.ui.components.PartnersSection
import com.example.alluvery.ui.components.ScaffoldTopBar
import com.example.alluvery.ui.components.SearchBar
import com.example.alluvery.ui.theme.AlluveryTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    searchText: String = ""
) {
    Scaffold(topBar = { ScaffoldTopBar() }) {

        Column(Modifier.padding(it)) {


            var text by remember {
                mutableStateOf(searchText)
            }
            SearchBar(
                searchText = text,
                onSearchChange = {
                    text = it
                },
                Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
            )
            val searchedProducts = remember(text) {
                if (text.isNotBlank()) {
                    sampleProducts.filter { product ->
                        product.nome.contains(
                            text,
                            ignoreCase = true,
                        ) ||
                                product.descricao?.contains(
                                    text,
                                    ignoreCase = true,
                                ) ?: false
                    }
                } else emptyList()
            }
            LazyColumn(
                Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                if (text.isBlank()) {
                    for (section in sections) {
                        val title = section.key
                        val products = section.value
                        item {
                            ListaDeProdutos(titulo = title, products = products)
                        }
                    }
                    for (shopSections in sampleShopSections) {
                        val title = shopSections.key
                        val shop = shopSections.value
                        item {
                            PartnersSection(title = title, shop = shop)
                        }
                    }
                } else {
                    items(searchedProducts) { p ->
                        CardProductItem(
                            product = p,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                }
            }
        }

    }
}


@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AlluveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}

@Preview
@Composable
fun HomeScreenWithSearchTextPreview() {
    AlluveryTheme {
        Surface {
            HomeScreen(
                sampleSections,
                searchText = "a",
            )
        }
    }
}