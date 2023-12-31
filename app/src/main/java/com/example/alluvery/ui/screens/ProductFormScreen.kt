package com.example.alluvery.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.alluvery.R
import com.example.alluvery.model.Product
import com.example.alluvery.ui.estates.ProductFormScreenUiState
import java.math.BigDecimal
import java.text.DecimalFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductFormScreen(
    onButtonClick: (Product) -> Unit = {}
) {
    var url by remember {
        mutableStateOf("")
    }

    var name by remember {
        mutableStateOf("")
    }

    var price by remember {
        mutableStateOf("")
    }

    var isPriceError by remember {
        mutableStateOf(false)
    }

    var description by remember {
        mutableStateOf("")
    }


    Column(
        Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Criando o produto", Modifier.fillMaxWidth(), fontSize = 28.sp)

        //campo imagem

        if (url.isNotBlank()) {
            AsyncImage(
                model = url, contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                error = painterResource(id = R.drawable.ic_launcher_background)
            )


        }

        TextField(value = url, onValueChange = {
            url = it
        }, Modifier.fillMaxWidth(), label = { Text(text = "Url da Imagem") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        //campo do nome

        TextField(value = name, onValueChange = {
            name = it
        }, Modifier.fillMaxWidth(), label = { Text(text = "Nome") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            )
        )

        //campo do preço


        Column {
            TextField(
                value = price,
                onValueChange = {
                    isPriceError = try {
                        price = DecimalFormat("#.00").format(BigDecimal(it))
                        false
                    } catch (e: IllegalArgumentException) {
                        it.isNotEmpty()
                    }
                },
                Modifier.fillMaxWidth(),
                isError = isPriceError,
                label = {
                    Text(text = "Preço")
                },
                keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Decimal,
                    imeAction = ImeAction.Next,
                ),
            )
            if (isPriceError) {
                Text(
                    text = "Preço deve ser um número decimal",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }

        //campo da descrição


        TextField(
            value = description, onValueChange = {
                description = it
            },
            Modifier
                .fillMaxWidth()
                .heightIn(100.dp),
            label = { Text(text = "Descrição") },
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
        )

        //botão

        Button(
            onClick = {
                val preco = try {
                    BigDecimal(price)
                } catch (e: NumberFormatException) {
                    BigDecimal.ZERO
                }

                val product = Product(
                    nome = name,
                    imagem = url,
                    preco = preco,
                    descricao = description
                )
                Log.i("ProductForm", "ProductFormMessage: $product")
                onButtonClick(product)

            }, Modifier.fillMaxWidth()
        ) {
            Text(text = "Salvar")
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ProductFormScreen(
        state: ProductFormScreenUiState = ProductFormScreenUiState(),
        onSaveClick: () -> Unit = {}
    ) {
        val url = state.url
        val name = state.name
        val price = state.price
        val description = state.description
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Spacer(modifier = Modifier)
            Text(
                text = "Criando o produto",
                Modifier.fillMaxWidth(),
                fontSize = 28.sp,
            )
            if (state.isShowPreview) {
                AsyncImage(
                    model = url, contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
                    error = painterResource(id = R.drawable.ic_launcher_background)
                )
            }
            TextField(
                value = url,
                onValueChange = state.onUrlChange,
                Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Url da imagem")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Uri,
                    imeAction = ImeAction.Next
                )
            )
            TextField(
                value = name,
                onValueChange = state.onNameChange,
                Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Nome")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words
                )
            )

            TextField(
                value = price,
                onValueChange = state.onPriceChange,
                Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Preço")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal,
                    imeAction = ImeAction.Next
                )
            )
            TextField(
                value = description,
                onValueChange = state.onDescriptionChange,
                Modifier
                    .fillMaxWidth()
                    .heightIn(min = 100.dp),
                label = {
                    Text(text = "Descrição")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    capitalization = KeyboardCapitalization.Sentences
                )
            )
            Button(
                onClick = onSaveClick,
                Modifier.fillMaxWidth(),
            ) {
                Text(text = "Salvar")
            }
            Spacer(modifier = Modifier)
        }
    }
}