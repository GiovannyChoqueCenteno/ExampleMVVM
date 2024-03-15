package com.example.ventasmovilcompose.store.presentation.product_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ventasmovilcompose.core.utils.Event
import com.example.ventasmovilcompose.core.utils.sendEvent
import com.example.ventasmovilcompose.store.domain.repository.ProductsRepository
import com.example.ventasmovilcompose.store.usecases.GetProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProducts: GetProducts
) : ViewModel() {
    private val _state = MutableStateFlow(ProductViewState())
    val state = _state.asStateFlow()

    init {
        getProductsVM()
    }

    fun getProductsVM() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            getProducts()
                .onRight { products ->
                    _state.update {
                        it.copy(isLoading = false, products = products)
                    }
                }
                .onLeft { error ->
                    _state.update {
                        it.copy(isLoading = false, error = error.error.message)
                    }
                    sendEvent(Event.Toast(error.error.message))
                }
        }
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            getProducts()
                .onRight { products ->
                    _state.update {
                        it.copy(isLoading = false, products = products)
                    }
                }
                .onLeft { error ->
                    _state.update {
                        it.copy(isLoading = false, error = error.error.message)
                    }
                    sendEvent(Event.Toast(error.error.message))
                }
        }
    }
}