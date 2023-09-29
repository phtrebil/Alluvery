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
import androidx.compose.ui.Modifier
import br.com.alura.aluvery.ui.screens.HomeScreen
import com.example.alluvery.dao.ProductDao
import com.example.alluvery.sampledata.sampleCandies
import com.example.alluvery.sampledata.sampleDrinks
import com.example.alluvery.ui.theme.AlluveryTheme

class MainActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(onFabClick = {
                startActivity(Intent(this, ProductFormActivity::class.java))
            }){
                val sections = mapOf(
                    "Todos os produtos" to dao.products(),
                    "Promoções" to sampleDrinks + sampleCandies,
                    "Doces" to sampleCandies,
                    "Bebidas" to sampleDrinks
                    
                )
                HomeScreen(sections = sections)
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

