package com.example.alluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MyFirstComposeble(){
    Row(
        Modifier
            .padding(16.dp)
            .fillMaxWidth()){
        Column(
            Modifier
                .padding(8.dp)
                .background(color = Color.White)
                .padding(10.dp, 24.dp)) {
            Text(text = "Meu primeiro texto. ")
            Text(text = "Meu segundo texto.")
        }
        Column(Modifier.background(color = Color.White)) {
            Text(text = "Meu terceiro texto. ")
            Text(text = "Meu Quarto texto.")
        }
    }

}

@Composable
fun MyFirstComposevlePreview(){
    MyFirstComposeble()
}

@Preview(showBackground = true)
@Composable fun BoxComposabler(){

        Row( Modifier
            .fillMaxWidth()
            .height(150.dp)) {
            Box(Modifier.fillMaxHeight().width(100.dp)
                .background(Color.Blue))
            Column(Modifier.fillMaxWidth()) {
                Text(text = "Testo 1",
                    Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFededed))
                        .padding(16.dp))
                Text(text = "Testo 2",
                    Modifier.padding(16.dp)
                )
            }
        }


}