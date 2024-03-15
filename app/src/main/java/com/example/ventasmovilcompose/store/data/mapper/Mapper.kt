package com.example.ventasmovilcompose.store.data.mapper

import com.example.ventasmovilcompose.store.domain.model.ApiError
import com.example.ventasmovilcompose.store.domain.model.NetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toNetworkError(): NetworkError {
    val error = when (this) {
        is IOException -> ApiError.Networkerror
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(error, t = this)
}