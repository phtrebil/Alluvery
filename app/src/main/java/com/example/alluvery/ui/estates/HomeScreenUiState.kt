package com.example.alluvery.ui.estates

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.alluvery.model.Product
import com.example.alluvery.sampledata.sampleProducts

class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
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

    fun isShowSections():Boolean{
        return text.isBlank()
    }

}