package com.chrrissoft.permissionscompanion.ui

sealed interface ScreenEvent {
    fun resolve(handler: ScreenViewModel.EventsHandler) {

    }
}
