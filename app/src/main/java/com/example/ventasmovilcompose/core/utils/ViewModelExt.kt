package com.example.ventasmovilcompose.core.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


fun ViewModel.sendEvent(event: Event) {
    viewModelScope.launch {
        EventBus.sendEvents(event)
    }
}