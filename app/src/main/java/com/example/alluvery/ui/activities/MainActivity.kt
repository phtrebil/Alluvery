package com.example.alluvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import br.com.alura.aluvery.ui.screens.HomeScreen
import com.example.alluvery.sampledata.sampleSections
import com.example.alluvery.ui.theme.AlluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlluveryTheme {
                Surface {
                    HomeScreen(sampleSections)
                }

            }

        }
    }
}

