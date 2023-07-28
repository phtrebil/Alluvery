package com.example.alluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alluvery.ui.theme.AlluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlluveryTheme{
                Surface{

                }
                
            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable fun PrimeiroProduto(){
    Column() {
        Box(modifier = Modifier.height(50.dp).width(50.dp)
            .background(color = Color.Cyan))
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "fundo verde quadriculado")
        Text(text = "testo 1")
        Text(text = "testo 2")
    }
}
