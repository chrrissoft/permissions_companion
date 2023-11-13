package com.chrrissoft.permissionscompanion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.chrrissoft.permissionscompanion.app.ui.ScreenViewModel
import com.chrrissoft.permissionscompanion.app.ui.ui.Screen
import com.chrrissoft.permissionscompanion.ui.components.App
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: ScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App {
                val state by viewModel.stateFlow.collectAsState()
                Screen(state = state, onEvent = { viewModel.handleEvent(event = it) } )
            }
        }
    }
}
