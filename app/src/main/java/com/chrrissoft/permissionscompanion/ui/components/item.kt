package com.chrrissoft.permissionscompanion.ui.components

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.TIRAMISU
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Launch
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.chrrissoft.permissionscompanion.Permission
import com.chrrissoft.permissionscompanion.ui.theme.inputChipBorder
import com.chrrissoft.permissionscompanion.ui.theme.inputChipColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Permission(
    state: Permission,
    onChangeItem: (Permission) -> Unit,
    modifier: Modifier = Modifier,
    onRequestResult: () -> Unit,
) {
    val launcher = run {
        rememberLauncherForActivityResult(
            contract = RequestPermission(),
            onResult = { onRequestResult() }
        )
    }

    val (showPermissionUnsupported, changeShowPermissionUnsupported) = remember {
        mutableStateOf(false)
    }

    if (showPermissionUnsupported) {
        AlertDialog(
            onDismissRequest = {
                changeShowPermissionUnsupported(false)
            },
            title = {
                Text(text = "Unsupported permission")
            },
            text = {
                Text(text = "".plus(state.supportedApi))
            },
            confirmButton = {
                Button(onClick = { changeShowPermissionUnsupported(false) }) {
                    Text(text = "Ok")
                }
            },
            containerColor = colorScheme.primaryContainer,
            textContentColor = colorScheme.onPrimaryContainer,
            titleContentColor = colorScheme.onPrimaryContainer,
            iconContentColor = colorScheme.onPrimaryContainer,
        )
    }

    val background = if (!state.isSupported) colorScheme.primaryContainer.copy((.5f))
    else colorScheme.primaryContainer
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .clickable(!state.isSupported) { changeShowPermissionUnsupported(true) }
            .clip(shapes.medium)
            .background(background)
            .padding(20.dp)
    ) {
        NormalPermission(state = state)
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            val (showDisableUnsupported, changeShowDisableUnsupported) = remember {
                mutableStateOf(false)
            }

            if (showDisableUnsupported) {
                AlertDialog(
                    onDismissRequest = {
                        changeShowDisableUnsupported(false)
                    },
                    title = {
                        Text(text = "Unsupported action")
                    },
                    text = {
                        Text(text = "")
                    },
                    confirmButton = {
                        Button(onClick = { changeShowDisableUnsupported(false) }) {
                            Text(text = "Ok")
                        }
                    },
                    containerColor = colorScheme.primaryContainer,
                    textContentColor = colorScheme.onPrimaryContainer,
                    titleContentColor = colorScheme.onPrimaryContainer,
                    iconContentColor = colorScheme.onPrimaryContainer,
                )
            }

            InputChip(
                colors = inputChipColors,
                selected = state.disableOnKill,
                border = inputChipBorder,
                enabled = state.isSupported && SDK_INT >= TIRAMISU,
                onClick = { onChangeItem(state.copy(disableOnKill = !state.disableOnKill)) },
                label = { Text(text = "Disable on kill", style = typography.labelMedium) }
            )

            InputChip(
                selected = state.checkToShow,
                colors = inputChipColors,
                border = inputChipBorder,
                enabled = state.isSupported && !state.enabled,
                onClick = { onChangeItem(state.copy(checkToShow = !state.checkToShow)) },
                label = { Text(text = "Show in group", style = typography.labelMedium) }
            )

            FilledIconButton(
                shape = shapes.medium,
                onClick = { launcher.launch(state.permission) },
                enabled = state.isSupported && !state.enabled,
                content = { Icon(Icons.AutoMirrored.Rounded.Launch, (null)) },
            )
        }
    }
}
