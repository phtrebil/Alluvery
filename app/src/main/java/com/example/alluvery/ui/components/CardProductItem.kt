package com.example.alluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.alluvery.R
import com.example.alluvery.extensions.toBrazilianCurrency
import com.example.alluvery.model.Product
import com.example.alluvery.sampledata.sampleProducts
import java.math.BigDecimal


@Composable
fun CardProductItem(
    product: Product,
    elevation: Dp = 4.dp,
    modifier: Modifier = Modifier,
    expanded: Boolean = false
) {
    var expandedState by remember {
        mutableStateOf(expanded)
    }
    Card(
        modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable {
                expandedState = !expandedState
            }
    ) {
        Column() {
            AsyncImage(
                model = product.imagem,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp)

            ) {
                Text(
                    text = product.nome,
                    color = Color.White
                )
                Text(
                    text = product.preco.toBrazilianCurrency(),
                    color = Color.White
                )
            }

            if(product.descricao != ""){
                Text(
                    text = product.descricao,
                    Modifier
                        .padding(16.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
            }
        }
    }
    

}


@Preview
@Composable
private fun CardProductItemPreview() {

    CardProductItem(
        product = Product(
            "Bombom",
            BigDecimal("1,99"),
            "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg",
            LoremIpsum(50).values.first()),
    )

}


