package com.example.alluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alluvery.extensions.toBrazilianCurrency
import com.example.alluvery.model.Product
import com.example.alluvery.ui.theme.AlluveryTheme
import com.example.alluvery.ui.theme.Purple500
import com.example.alluvery.ui.theme.Teal
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlluveryTheme {
                Surface {
                    App()
                }

            }

        }
    }
}

@Composable
fun App() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ListaDeProdutos()
        ListaDeProdutos()
        ListaDeProdutos()
    }
}

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
                        .align(BottomCenter)
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

@Composable
fun ListaDeProdutos() {
    Column() {
        Text(
            text = "Promoção",
            Modifier.padding(start = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )

        Row(
            Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PrimeiroProduto(
                Product(
                    nome = "Hamburguer",
                    preco = BigDecimal(25.90),
                    imagem = R.drawable.burger,
                    descricao = "Um suculento hambúrguer de fraldinha de 150g, acompanhado de bacon crocante, queijo derretido e uma refrescante salada. A combinação perfeita de sabor e textura em um único hambúrguer!"
                )
            )
            PrimeiroProduto(
                Product(
                    "Batata-frita",
                    BigDecimal(9.90),
                    R.drawable.fries,
                    "Irresistivelmente crocante por fora, macia por dentro. Nossas batatas fritas são um prazer sensorial em cada mordida. Experimente o equilíbrio perfeito de sabor e textura neste delicioso petisco! "
                )
            )
            PrimeiroProduto(
                Product(
                    "Pizza Napolitana",
                    BigDecimal(34.90),
                    R.drawable.pizza,
                    "Autêntica e apaixonante! Massa leve, macia e aerada, combinada com molho de tomate fresco e cremosa muçarela. Toques finais de manjericão e azeite de oliva. Uma experiência única da tradição italiana em cada mordida. Buon appetito!"
                )
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProductItemPreview() {
    App()
}
