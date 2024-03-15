package com.example.ventasmovilcompose.store.domain.model

data class NetworkError(
    val error: ApiError,
    val t: Throwable? = null
)


enum class ApiError(val message: String) {
    Networkerror("Network Error"),
    UnknownResponse("Unknow Response"),
    UnknownError("Unknown Error")
}