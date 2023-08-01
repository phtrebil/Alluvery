package com.example.alluvery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alluvery.R
import com.example.alluvery.ui.theme.Purple500
import com.example.alluvery.ui.theme.Teal


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

        Row(
            Modifier
                .fillMaxWidth()
                .height(150.dp)) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .width(100.dp)
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
@Preview(showBackground = true)
@Composable fun NovaVersaoProduto(){
    Surface(Modifier.padding(8.dp), shape = RoundedCornerShape(15.dp), shadowElevation = 8.dp){
        Row(
            Modifier
                .heightIn(150.dp, 200.dp)
                .fillMaxWidth()){
            val imageSize = 100.dp
            Box(modifier =
            Modifier
                .fillMaxHeight()
                .background(Brush.verticalGradient(colors = listOf(Teal, Purple500)))){
                Image(painter = painterResource(id =  R.drawable.ic_launcher_background),
                    contentDescription = "imagem do produto", Modifier
                        .size(imageSize)
                        .offset(x = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.CenterEnd)
                        .border(2.dp, Brush.verticalGradient(listOf(Teal, Purple500)), CircleShape)
                )
            }
            Spacer(modifier = Modifier.width(imageSize/2))

            Box(modifier = Modifier.padding(16.dp).fillMaxHeight().padding(16.dp).align(CenterVertically)){

                Text(text = LoremIpsum(150).values.first(),
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    lineHeight = 20.sp
                )
            }

        }
    }

}
