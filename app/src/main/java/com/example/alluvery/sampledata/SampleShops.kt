package com.example.alluvery.sampledata

import com.example.alluvery.model.Shop

val sampleShops: List<Shop> = listOf(
    Shop(
        name = "Carrinho SuperMercado",
        logo = "https://images.pexels.com/photos/264547/pexels-photo-264547.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    ),
    Shop(
        name = "Padaria",
        logo = "https://images.pexels.com/photos/1855214/pexels-photo-1855214.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    ),
    Shop(
        name = "Floricultura",
        logo = "https://images.pexels.com/photos/2111192/pexels-photo-2111192.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    ),
    Shop(
        name = "Loja de Roupas",
        logo = "https://images.pexels.com/photos/102129/pexels-photo-102129.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    ),
    Shop(
        name = "Hotéis",
        logo = "https://images.pexels.com/photos/237272/pexels-photo-237272.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    ),
)
val sampleShopSections = mapOf(
    "Lojas Parceiras" to sampleShops
)