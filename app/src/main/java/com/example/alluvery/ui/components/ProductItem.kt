package com.example.alluvery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alluvery.R
import com.example.alluvery.extensions.toBrazilianCurrency
import com.example.alluvery.model.Product
import com.example.alluvery.ui.theme.Purple500
import com.example.alluvery.ui.theme.Teal
import java.math.BigDecimal


@Composable
fun PrimeiroProduto(product: Product) {
    Surface(shape = RoundedCornerShape(15.dp), shadowElevation = 8.dp) {
        Column(
            Modifier
                .heightIn(250.dp, 260.dp)
                .width(200.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .fillMaxWidth()
                    .background(brush = Brush.horizontalGradient(colors = listOf(Purple500, Teal)))
            ) {
                Image(
                    painter = painterResource(id = product.imagem),
                    contentDescription = "fundo verde quadriculado",
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter)
                        .border(2.dp, Brush.verticalGradient(listOf(Teal, Purple500)), CircleShape),
                    contentScale = ContentScale.Crop

                )
            }
            Spacer(Modifier.height(imageSize / 2))
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = product.nome,
                    Modifier.padding(start = 8.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.preco.toBrazilianCurrency(),
                    Modifier.padding(8.dp, top = 12.dp, bottom = 19.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500)
                )
            }
            if (product.descricao.isNotBlank()) {
                Text(
                    text = product.descricao,
                    Modifier
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Purple500,
                                    Teal
                                )
                            )
                        )
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 16.dp,
                            top = 8.dp
                        ),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MostraDisplay(){
    PrimeiroProduto(product = Product(
        nome = LoremIpsum(10).values.first(),
        preco = BigDecimal(10.90),
        imagem = R.drawable.burger,
        descricao = ""
    ))
}