package com.example.alluvery.ui.estates

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.alluvery.model.Product
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

}