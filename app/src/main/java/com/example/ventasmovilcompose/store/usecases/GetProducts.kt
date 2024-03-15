package com.example.ventasmovilcompose.store.usecases

import arrow.core.Either
import com.example.ventasmovilcompose.store.domain.model.NetworkError
import com.example.ventasmovilcompose.store.domain.model.Product
import com.example.ventasmovilcompose.store.domain.repository.ProductsRepository
import javax.inject.Inject

class GetProducts @Inject constructor(
    private val repository: ProductsRepository
) {
    suspend operator fun invoke(): Either<NetworkError, List<Product>> {
        return repository.getProducts()
    }
}