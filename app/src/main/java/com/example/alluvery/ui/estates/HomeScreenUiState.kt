package com.example.alluvery.ui.estates

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.alluvery.model.Product
import com.example.alluvery.sampledata.sampleProducts

class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    private val products: List<Product> = emptyList(),
    searchText: String = ""
) {

    var text by mutableStateOf(searchText)
        private set

    val onSearchChange: (String) -> Unit = {searchedText ->
        text = searchedText

    }


    val searchedProducts
        get() =
            if (text.isNotBlank()) {
                sampleProducts.filter(filterProductByNameOrDescription()) + products.filter(filterProductByNameOrDescription())
            } else emptyList()

    private fun filterProductByNameOrDescription() = { product: Product ->
        product.nome.contains(
            text,
            ignoreCase = true,
        ) ||
                product.descricao?.contains(
                    text,
                    ignoreCase = true,
                ) ?: false
    }

    fun isShowSections():Boolean{
        return text.isBlank()
    }

}