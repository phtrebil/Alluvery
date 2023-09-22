package com.example.alluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alluvery.model.Shop

@Composable
fun PartnersSection(
    title: String,
    shop: List<Shop>,
    modifier: Modifier = Modifier
) {
    Column() {
        val showDialog = remember { mutableStateOf(false) }

        if (showDialog.value)
            LinkToPartnersSite(setShowDialog = {
                showDialog.value = it
            })

        Section(
            title = {
                Text(
                    text = title,
                    Modifier.padding(
                        start = 16.dp,
                        end = 16.dp
                    ),
                    fontSize = 20.sp,
                    fontWeight = FontWeight(400),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            },
            content = {
                LazyRow(
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(shop) { s ->

                        Partner(shop = s, onItemClick = {
                            showDialog.value = true
                        })
                    }
                }
            },
            modifier = modifier
        )
    }
}



