package com.example.alluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstComposeble()
        }
    }
}

@Composable
fun MyFirstComposeble(){
    Column(Modifier.background(color = Color.White)) {
        Text(text = "Meu primeiro texto. ")
        Text(text = "Meu segundo texto.")
    }

}

@Preview
@Composable
fun MyFirstComposevlePreview(){
    MyFirstComposeble()
}
