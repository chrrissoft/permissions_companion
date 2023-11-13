package com.chrrissoft.permissionscompanion.app.ui

import androidx.lifecycle.ViewModel
import com.chrrissoft.permissionscompanion.Permission
import com.chrrissoft.permissionscompanion.app.ui.ScreenState.NormalState
import com.chrrissoft.permissionscompanion.app.ui.ScreenState.Page
import com.chrrissoft.permissionscompanion.app.ui.ScreenState.RunTimeState
import com.chrrissoft.permissionscompanion.app.ui.ScreenState.SignatureState
import com.chrrissoft.permissionscompanion.app.usecases.interfaces.ResolvePermissionsEnabledUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import com.chrrissoft.permissionscompanion.app.ui.ScreenEvent.RunTimeEvent.OnChangePermission as OnChangePermissionRunTime


@HiltViewModel
class ScreenViewModel @Inject constructor(
    private val ResolvePermissionsEnabledUseCase: ResolvePermissionsEnabledUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(ScreenState())
    val stateFlow = _state.asStateFlow()
    private val state get() = stateFlow.value
    private val _page get() = state.page
    private val _normals get() = state.normal
    private val _runTime get() = state.runTime
    private val _signature get() = state.signature

    private val handler = EventHandler()

    fun handleEvent(event: ScreenEvent) {
        event.resolve(handler)
    }

    inner class EventHandler {
        val normal = NormalEventHandler()
        val runTime = RunTimeEventHandler()
        val signature = SignatureEventHandler()

        fun onEvent(event: ScreenEvent.OnChangePage) {
            updateState(page = event.data)
        }

        inner class NormalEventHandler {
            fun onEnableAsk() {
                updateNormalState(ResolvePermissionsEnabledUseCase(_normals.items))
            }
        }

        inner class RunTimeEventHandler {
            fun onEvent(event: OnChangePermissionRunTime) {
                _runTime
                    .items.map { if (event.data.name == it.name) event.data else it }
                    .let { updateRunTimeState(items = it) }
            }

            fun onEnableAsk() {
                updateRunTimeState(ResolvePermissionsEnabledUseCase(_runTime.items))
            }
        }

        inner class SignatureEventHandler {
            fun onEnableAsk() {
                updateSignatureState(ResolvePermissionsEnabledUseCase(_signature.items))
            }
        }
    }

    private fun updateNormalState(items: List<Permission> = _normals.items) {
        val copy = _normals.copy(items = items)
        updateState(normal = copy)
    }

    private fun updateRunTimeState(items: List<Permission> = _runTime.items) {
        val copy = _runTime.copy(items = items)
        updateState(runTime = copy)
    }

    private fun updateSignatureState(items: List<Permission> = _runTime.items) {
        val copy = _signature.copy(items = items)
        updateState(signature = copy)
    }


    private fun updateState(
        page: Page = _page,
        normal: NormalState = _normals,
        runTime: RunTimeState = _runTime,
        signature: SignatureState = _signature,
    ) {
        _state.update {
            it.copy(
                page = page,
                normal = normal,
                runTime = runTime,
                signature = signature,
            )
        }
    }
}
