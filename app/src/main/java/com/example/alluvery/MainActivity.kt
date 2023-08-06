package com.example.alluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.alluvery.ui.components.HomeScreen
import com.example.alluvery.ui.theme.AlluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlluveryTheme {
                Surface {
                    HomeScreen()
                }

            }

        }
    }
}

