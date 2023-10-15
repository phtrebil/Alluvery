package com.example.alluvery.ui.screens

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alluvery.sampledata.sampleSections
import com.example.alluvery.sampledata.sampleShopSections
import com.example.alluvery.ui.components.CardProductItem
import com.example.alluvery.ui.components.ListaDeProdutos
import com.example.alluvery.ui.components.PartnersSection
import com.example.alluvery.ui.components.ScaffoldTopBar
import com.example.alluvery.ui.components.SearchBar
import com.example.alluvery.ui.estates.HomeScreenUiState
import com.example.alluvery.ui.theme.AlluveryTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState()
) {
    Scaffold(topBar = { ScaffoldTopBar() }) {

        Column(Modifier.padding(it)) {
            val sections = state.sections

            val text = state.searchText
            val searchedProducts = state.searchedProducts


            SearchBar(
                searchText = text,
                onSearchChange = state.onSearchChange,
                Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
            )

            LazyColumn(
                Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                if (state.isShowSections()) {
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
            HomeScreen(state = HomeScreenUiState(sections = sampleSections))
        }
    }
}

@Preview
@Composable
fun HomeScreenWithSearchTextPreview() {
    AlluveryTheme {
        Surface {
            HomeScreen(
                state = HomeScreenUiState(searchText = "a", sections = sampleSections),
            )
        }
    }
}