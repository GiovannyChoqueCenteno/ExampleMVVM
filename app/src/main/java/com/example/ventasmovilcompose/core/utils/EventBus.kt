package com.example.ventasmovilcompose.core.utils

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

object EventBus {
    private val _events = Channel<Any>()
    val events = _events.receiveAsFlow()
    suspend fun sendEvents(event: Event) {
        _events.send(event)
    }
}

sealed interface Event {
    data class Toast(val message: String) : Event
}