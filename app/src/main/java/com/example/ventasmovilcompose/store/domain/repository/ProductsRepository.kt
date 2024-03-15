package com.example.ventasmovilcompose.store.domain.repository

import arrow.core.Either
import com.example.ventasmovilcompose.store.domain.model.NetworkError
import com.example.ventasmovilcompose.store.domain.model.Product

interface ProductsRepository {
    suspend fun getProducts() : Either<NetworkError, List<Product>>
}