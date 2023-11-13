package com.chrrissoft.permissionscompanion.ui.components

import android.content.ComponentName
import android.content.Intent
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startForegroundService
import com.chrrissoft.permissionscompanion.Permission
import com.chrrissoft.permissionscompanion.app.ui.ui.LaunchComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NormalPermission(
    state: Permission,
) {
    val (showComponents, changeShowComponents) = remember {
        mutableStateOf((false))
    }

    if (showComponents) {
        MyModalBottomSheet(
            title = "Start components",
            onDismissRequest = { changeShowComponents(false) },
            content = {
                val ctx = LocalContext.current
                val packageName = "com.chrrissoft.permissions"
                val activityIntent = Intent().apply {
                    component = ComponentName(packageName, state.activity)
                }
                val serviceIntent = Intent().apply {
                    component = ComponentName(packageName, state.service)
                }
                val receiverIntent = Intent(state.receiverAction)

                LaunchComponent(
                    label = "service",
                    onLaunch = { startForegroundService(ctx, serviceIntent) }
                )
                LaunchComponent(
                    label = "activity",
                    onLaunch = { ctx.startActivity(activityIntent) })
                LaunchComponent(
                    label = "receiver",
                    onLaunch = { ctx.sendBroadcast(receiverIntent) })
            }
        )
    }

    MyTextField(
        enabled = false,
        value = state.name,
        onValueChange = {},
        leadingIcon = {
            val icon = if (state.enabled) Rounded.Done else Rounded.Cancel
            Icon(icon, (null))
        },
        trailingIcon = {
            val icon = if (!showComponents) Rounded.ExpandMore else Rounded.ExpandLess
            IconToggleButton(
                checked = showComponents,
                onCheckedChange = changeShowComponents,
                content = { Icon(icon, (null)) }
            )
        },
    )
}
