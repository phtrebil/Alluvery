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
import com.example.alluvery.sampledata.sampleSections
import com.example.alluvery.ui.theme.AlluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(onFabClick = {
                startActivity(Intent(this, ProductFormActivity::class.java))
            })

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun App(onFabClick: () -> Unit) {
        AlluveryTheme {
            Surface {
                Scaffold(floatingActionButton = {
                    FloatingActionButton(onClick = onFabClick) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    }
                }) { paddingValues ->
                    Box(Modifier.padding(paddingValues)) {
                        HomeScreen(sampleSections)
                    }
                }
            }

        }
    }
}

