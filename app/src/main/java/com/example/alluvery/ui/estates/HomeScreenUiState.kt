package com.example.alluvery.ui.estates

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.alluvery.model.Product
import com.example.alluvery.sampledata.sampleCandies
import com.example.alluvery.sampledata.sampleDrinks
import com.example.alluvery.sampledata.sampleProducts

class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchedProducts: List<Product> = emptyList(),
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {}
) {

    var text by mutableStateOf(searchText)
        private set


    fun isShowSections():Boolean{
        return text.isBlank()
    }

    @Composable
    fun HomeScreen(products: List<Product>) {
        val sections = mapOf(
            "Todos produtos" to products,
            "Promoções" to sampleDrinks + sampleCandies,
            "Doces" to sampleCandies,
            "Bebidas" to sampleDrinks
        )
        var text by remember {
            mutableStateOf("")
        }

        fun containsInNameOrDescrioption() = { product: Product ->
            product.nome.contains(
                text,
                ignoreCase = true,
            ) || product.descricao?.contains(
                text,
                ignoreCase = true,
            ) ?: false
        }

        val searchedProducts = remember(text, products) {
            if (text.isNotBlank()) {
                sampleProducts.filter(containsInNameOrDescrioption()) +
                        products.filter(containsInNameOrDescrioption())
            } else emptyList()
        }

        val state = remember(products, text) {
            HomeScreenUiState(
                sections = sections,
                searchedProducts = searchedProducts,
                searchText = text,
                onSearchChange = {
                    text = it
                }
            )
        }
        com.example.alluvery.ui.screens.HomeScreen(state)
    }


}