package com.chrrissoft.permissionscompanion

import android.Manifest.permission.*
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

object Util {
    @SuppressLint("ComposableNaming")
    @Composable
    fun setBarsColors(
        status: Color = colorScheme.primaryContainer,
        bottom: Color = colorScheme.primaryContainer,
    ) {
        val systemUiController = rememberSystemUiController()
        val useDarkIcons = !isSystemInDarkTheme()

        DisposableEffect(systemUiController, useDarkIcons) {
            systemUiController.setStatusBarColor(status, useDarkIcons)
            systemUiController.setNavigationBarColor(bottom)
            onDispose {}
        }
    }

    fun Context.hasPermission(permission: String): Boolean {
        return checkSelfPermission(permission) == PERMISSION_GRANTED
    }
}
