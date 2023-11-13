package com.chrrissoft.permissionscompanion.app.ui.ui

import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons.AutoMirrored.Rounded
import androidx.compose.material.icons.automirrored.rounded.Launch
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier

@Composable
fun LaunchComponent(
    label: String,
    onLaunch: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        content = {
            Row(Modifier.fillMaxWidth(), SpaceBetween, CenterVertically) {
                Text(text = "Launch $label")
                Icon(Rounded.Launch, (null))
            }
        },
        onClick = { onLaunch() },
        shape = shapes.medium,
        modifier = modifier.fillMaxWidth()
    )
}
