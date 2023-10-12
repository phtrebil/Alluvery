package com.example.alluvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import br.com.alura.aluvery.ui.screens.HomeScreen
import com.example.alluvery.dao.ProductDao
import com.example.alluvery.model.Product
import com.example.alluvery.sampledata.sampleCandies
import com.example.alluvery.sampledata.sampleDrinks
import com.example.alluvery.sampledata.sampleProducts
import com.example.alluvery.ui.estates.HomeScreenUiState
import com.example.alluvery.ui.theme.AlluveryTheme

class MainActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(onFabClick = {
                startActivity(Intent(this, ProductFormActivity::class.java))
            }){

                val products = dao.products()
                val sections = mapOf(
                    "Todos os produtos" to products,
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
                    ) || product.descricao.contains(
                        text,
                        ignoreCase = true,
                    )
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
                        searchText = text,
                        searchedProducts = searchedProducts,
                        onSearchChange = {
                            text = it
                        }
                    )
                }

                HomeScreen(state = state)
            }

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun App(onFabClick: () -> Unit, content:@Composable ()-> Unit) {
        AlluveryTheme {
            Surface {
                Scaffold(floatingActionButton = {
                    FloatingActionButton(onClick = onFabClick) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    }
                }) { paddingValues ->
                    Box(Modifier.padding(paddingValues)) {
                        content()
                    }
                }
            }

        }
    }
}

