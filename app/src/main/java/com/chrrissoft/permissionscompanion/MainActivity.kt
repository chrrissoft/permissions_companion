package com.chrrissoft.permissionscompanion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chrrissoft.permissionscompanion.ui.Screen
import com.chrrissoft.permissionscompanion.ui.ScreenViewModel
import com.chrrissoft.permissionscompanion.ui.components.App
import com.chrrissoft.permissionscompanion.ui.theme.PermissionsCompanionTheme

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
