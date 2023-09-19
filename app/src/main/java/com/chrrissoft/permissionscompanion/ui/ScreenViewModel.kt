package com.chrrissoft.permissionscompanion.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ScreenViewModel : ViewModel() {
    private val _state = MutableStateFlow(ScreenState())
    val stateFlow = _state.asStateFlow()

    fun handleEvent(event: ScreenEvent) {

    }


    inner class EventsHandler {

    }
}
