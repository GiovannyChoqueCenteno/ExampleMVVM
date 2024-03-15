package com.example.ventasmovilcompose.store.presentation.product_screen

import com.example.ventasmovilcompose.store.domain.model.Product

data class ProductViewState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)