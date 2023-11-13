package com.chrrissoft.permissionscompanion.app.ui

import com.chrrissoft.permissionscompanion.Permission
import com.chrrissoft.permissionscompanion.app.ui.ScreenViewModel.EventHandler
import com.chrrissoft.permissionscompanion.app.ui.ScreenViewModel.EventHandler.NormalEventHandler
import com.chrrissoft.permissionscompanion.app.ui.ScreenViewModel.EventHandler.RunTimeEventHandler
import com.chrrissoft.permissionscompanion.app.ui.ScreenViewModel.EventHandler.SignatureEventHandler

sealed interface ScreenEvent {
    fun resolve(handler: EventHandler) {
        when (this) {
            is OnChangePage -> handler.onEvent(event = this)
            is NormalEvent -> resolve(handler.normal)
            is RunTimeEvent -> resolve(handler.runTime)
            is SignatureEvent -> resolve(handler.signature)
        }
    }

    data class OnChangePage(val data: ScreenState.Page) : ScreenEvent

    sealed interface NormalEvent : ScreenEvent {
        fun resolve(handler: NormalEventHandler) {
            when (this) {
                is OnEnableAsk -> handler.onEnableAsk()
            }
        }

        object OnEnableAsk : NormalEvent
    }

    sealed interface RunTimeEvent : ScreenEvent {
        fun resolve(handler: RunTimeEventHandler) {
            when (this) {
                is OnEnableAsk -> handler.onEnableAsk()
                is OnChangePermission -> handler.onEvent(event = this)
            }
        }

        data class OnChangePermission(val data: Permission) : RunTimeEvent

        object OnEnableAsk : RunTimeEvent
    }

    sealed interface SignatureEvent : ScreenEvent {
        fun resolve(handler: SignatureEventHandler) {
            when (this) {
                is OnEnableAsk -> handler.onEnableAsk()
            }
        }
        object OnEnableAsk : SignatureEvent
    }
}
