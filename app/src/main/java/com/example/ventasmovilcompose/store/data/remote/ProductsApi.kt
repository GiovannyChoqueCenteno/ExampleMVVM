package com.example.ventasmovilcompose.store.data.remote

import com.example.ventasmovilcompose.store.domain.model.Product
import retrofit2.http.GET

interface ProductsApi {
    @GET("products")
    suspend fun getProducts() : List<Product>
}