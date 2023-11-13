package com.chrrissoft.permissionscompanion.app.ui.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chrrissoft.permissionscompanion.app.ui.ScreenEvent
import com.chrrissoft.permissionscompanion.app.ui.ScreenEvent.RunTimeEvent.OnChangePermission
import com.chrrissoft.permissionscompanion.app.ui.ScreenEvent.RunTimeEvent.OnEnableAsk
import com.chrrissoft.permissionscompanion.app.ui.ScreenState
import com.chrrissoft.permissionscompanion.ui.components.Permission

@Composable
fun RunTimePage(
    state: ScreenState.RunTimeState,
    onEvent: (ScreenEvent.RunTimeEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    LaunchedEffect(Unit) { onEvent(OnEnableAsk) }
    Column(modifier = modifier.fillMaxWidth()) {
        LazyColumn {
            items(state.items) { item ->
                Permission(
                    state = item,
                    onRequestResult = { onEvent(OnEnableAsk) },
                    onChangeItem = { onEvent(OnChangePermission(it)) },
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}
