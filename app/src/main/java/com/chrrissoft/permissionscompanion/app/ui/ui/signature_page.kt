package com.chrrissoft.permissionscompanion.app.ui.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chrrissoft.permissionscompanion.app.ui.ScreenEvent.SignatureEvent
import com.chrrissoft.permissionscompanion.app.ui.ScreenEvent.SignatureEvent.OnEnableAsk
import com.chrrissoft.permissionscompanion.app.ui.ScreenState.SignatureState
import com.chrrissoft.permissionscompanion.ui.components.NormalPermission

@Composable
fun SignaturePage(
    state: SignatureState,
    onEvent: (SignatureEvent) -> Unit,
    modifier: Modifier,
) {
    LaunchedEffect(Unit) { onEvent(OnEnableAsk) }

    LazyColumn(modifier = modifier) {
        items(state.items) { item ->
            NormalPermission(state = item)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
