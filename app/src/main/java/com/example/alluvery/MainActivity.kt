package com.example.alluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.alluvery.sampledata.sampleSections
import com.example.alluvery.ui.components.HomeScreen
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

@Preview
@Composable
fun ShowUi(){
    HomeScreen(sampleSections)
}
