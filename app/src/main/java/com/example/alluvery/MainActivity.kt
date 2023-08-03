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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alluvery.ui.theme.AlluveryTheme
import com.example.alluvery.ui.theme.Purple500
import com.example.alluvery.ui.theme.Teal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlluveryTheme {
                Surface {
                    ListaDeProdutos()
                }

            }

        }
    }
}

@Composable
fun PrimeiroProduto(description: String = "") {
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
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "fundo verde quadriculado",
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(BottomCenter)
                        .border(2.dp, Brush.verticalGradient(listOf(Teal, Purple500)), CircleShape)
                )
            }
            Spacer(Modifier.height(imageSize / 2))
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = LoremIpsum(50).values.first(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "R$ 14,99",
                    Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
            if (description.isNotBlank()) {
                Text(
                    text = description,
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
            Modifier.padding(top = 16.dp, start = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )

        Row(
            Modifier
                .padding(top = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PrimeiroProduto("Hot dog legal daora uhAiuHaiuhaiuHaiuhioudhasifuhmafuihmseiofuhwefuihesfuhwe fweopsf grgwergregj ergijergioe ")
            PrimeiroProduto(LoremIpsum(20).values.first())
            PrimeiroProduto(LoremIpsum(50).values.first())
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProductItemPreview() {
    ListaDeProdutos()
}
