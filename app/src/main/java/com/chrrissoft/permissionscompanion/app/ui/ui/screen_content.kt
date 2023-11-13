package com.chrrissoft.permissionscompanion.app.ui.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chrrissoft.permissionscompanion.app.ui.ScreenEvent
import com.chrrissoft.permissionscompanion.app.ui.ScreenState
import com.chrrissoft.permissionscompanion.app.ui.ScreenState.Page.*

@Composable
fun ScreenContent(
    state: ScreenState,
    onEvent: (ScreenEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    when (state.page) {
        NORMAL -> NormalPage(state = state.normal, onEvent = onEvent, modifier = modifier)
        RUN_TIME -> RunTimePage(state = state.runTime, onEvent = onEvent, modifier = modifier)
        SIGNATURE -> SignaturePage(state = state.signature, onEvent = onEvent, modifier = modifier)
    }
}
