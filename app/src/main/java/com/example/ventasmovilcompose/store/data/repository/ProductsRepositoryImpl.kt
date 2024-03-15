package com.example.ventasmovilcompose.store.data.repository

import arrow.core.Either
import com.example.ventasmovilcompose.store.data.mapper.toNetworkError
import com.example.ventasmovilcompose.store.data.remote.ProductsApi
import com.example.ventasmovilcompose.store.domain.model.NetworkError
import com.example.ventasmovilcompose.store.domain.model.Product
import com.example.ventasmovilcompose.store.domain.repository.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val api: ProductsApi
) : ProductsRepository {
    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
        return withContext(Dispatchers.IO) {
            Either.catch {
                api.getProducts()
            }.mapLeft { it.toNetworkError() }
        }
    }
}