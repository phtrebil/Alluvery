package com.example.alluvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.alluvery.ui.theme.AlluveryTheme

class ProductFormActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlluveryTheme() {
                Text(text = "Formulário de produto")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductFormScreen() {
    Column {
        Text(text = "Criando o produto")

        var url by remember {
            mutableStateOf("")
        }

        TextField(value = url, onValueChange = {
            url = it
        })

        var name by remember {
            mutableStateOf("")
        }

        TextField(value = name, onValueChange = {
            name = it
        })

        var description by remember {
            mutableStateOf("")
        }

        TextField(value = description, onValueChange = {
            description = it
        })

        var price by remember {
            mutableStateOf("")
        }

        TextField(value = price, onValueChange = {
            price = it
        })
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Salvar")
        }
    }
}

@Preview
@Composable
fun ProductFormScreenPreview() {
    AlluveryTheme {
        Surface {
            ProductFormScreen()
        }
    }

}