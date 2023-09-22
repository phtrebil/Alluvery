package com.example.alluvery.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun LinkToPartnersSite(
    onConfirmButton: () -> Unit = {},
    onDismissButton: () -> Unit = {},
    setShowDialog: (Boolean) -> Unit = {}
) {
    AlertDialog(

        onDismissRequest = { setShowDialog(false) },
        confirmButton = {
            TextButton(onClick = {
                onConfirmButton()
                setShowDialog(false)
            }) {
                Text("ir")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onDismissButton()
                setShowDialog(false)
            }) {
                Text("Cancelar")
            }
        },
        title = { Text(text = "Você está saindo do Alluvery para acessar o site do parceiro", fontSize = 20.sp) },
        modifier = Modifier.fillMaxWidth()
    )

}