package com.chrrissoft.permissionscompanion.app.ui.ui

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Launch
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import com.chrrissoft.permissionscompanion.Util.setBarsColors
import com.chrrissoft.permissionscompanion.app.ui.ScreenEvent
import com.chrrissoft.permissionscompanion.app.ui.ScreenEvent.OnChangePage
import com.chrrissoft.permissionscompanion.app.ui.ScreenState
import com.chrrissoft.permissionscompanion.app.ui.ScreenState.Page.*
import com.chrrissoft.permissionscompanion.app.ui.ScreenState.Page.Companion.pages
import com.chrrissoft.permissionscompanion.ui.theme.centerAlignedTopAppBarColors
import com.chrrissoft.permissionscompanion.ui.theme.navigationBarItemColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(
    state: ScreenState,
    onEvent: (ScreenEvent) -> Unit,
) {
    setBarsColors()

    val multiPermissionLauncher = rememberLauncherForActivityResult(
        contract = RequestMultiplePermissions(),
        onResult = { onEvent(ScreenEvent.RunTimeEvent.OnEnableAsk) }
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = centerAlignedTopAppBarColors,
                title = { Text(text = "Permissions Companion App", fontWeight = Bold) }
            )
        },
        floatingActionButton = {
            if (state.page != RUN_TIME) return@Scaffold
            ExtendedFloatingActionButton(
                onClick = {
                    state.runTime.items
                        .mapNotNull { if (it.checkToShow) it.permission else null }
                        .let { multiPermissionLauncher.launch(it.toTypedArray()) }
                }
            ) {
                Text(text = "Ask for the selected")
                Spacer(Modifier.width(10.dp))
                Icon(Icons.AutoMirrored.Rounded.Launch, (null))
            }
        },
        bottomBar = {
            NavigationBar(
                contentColor = colorScheme.primary,
                containerColor = colorScheme.primaryContainer,
            ) {
                pages.forEach {
                    NavigationBarItem(
                        selected = state.page == it,
                        colors = navigationBarItemColors,
                        onClick = { onEvent(OnChangePage(it)) },
                        icon = { Icon(imageVector = it.icon, contentDescription = null) },
                        label = if (state.page == it) {
                            { Text(text = it.label) }
                        } else null,
                    )
                }
            }
        },
        containerColor = colorScheme.onPrimary,
        content = {
            ScreenContent(
                state = state,
                onEvent = onEvent,
                modifier = Modifier
                    .padding(it)
                    .padding(10.dp)
            )
        },
    )
}
