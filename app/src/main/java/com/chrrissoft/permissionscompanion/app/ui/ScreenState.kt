package com.chrrissoft.permissionscompanion.app.ui

import android.Manifest.permission.*
import android.annotation.SuppressLint
import android.provider.Settings.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.ui.graphics.vector.ImageVector
import com.chrrissoft.permissionscompanion.Constants.NORMAL_ACTIVITY_0
import com.chrrissoft.permissionscompanion.Constants.NORMAL_ACTIVITY_1
import com.chrrissoft.permissionscompanion.Constants.NORMAL_ACTIVITY_2
import com.chrrissoft.permissionscompanion.Constants.NORMAL_PERMISSION_0
import com.chrrissoft.permissionscompanion.Constants.NORMAL_PERMISSION_1
import com.chrrissoft.permissionscompanion.Constants.NORMAL_PERMISSION_2
import com.chrrissoft.permissionscompanion.Constants.NORMAL_RECEIVER_0
import com.chrrissoft.permissionscompanion.Constants.NORMAL_RECEIVER_1
import com.chrrissoft.permissionscompanion.Constants.NORMAL_RECEIVER_2
import com.chrrissoft.permissionscompanion.Constants.NORMAL_SERVICE_0
import com.chrrissoft.permissionscompanion.Constants.NORMAL_SERVICE_1
import com.chrrissoft.permissionscompanion.Constants.NORMAL_SERVICE_2
import com.chrrissoft.permissionscompanion.Constants.RUN_TIME_ACTIVITY_0
import com.chrrissoft.permissionscompanion.Constants.RUN_TIME_ACTIVITY_1
import com.chrrissoft.permissionscompanion.Constants.RUN_TIME_ACTIVITY_2
import com.chrrissoft.permissionscompanion.Constants.RUN_TIME_PERMISSION_0
import com.chrrissoft.permissionscompanion.Constants.RUN_TIME_PERMISSION_1
import com.chrrissoft.permissionscompanion.Constants.RUN_TIME_PERMISSION_2
import com.chrrissoft.permissionscompanion.Constants.RUN_TIME_RECEIVER_0
import com.chrrissoft.permissionscompanion.Constants.RUN_TIME_RECEIVER_1
import com.chrrissoft.permissionscompanion.Constants.RUN_TIME_RECEIVER_2
import com.chrrissoft.permissionscompanion.Constants.RUN_TIME_SERVICE_0
import com.chrrissoft.permissionscompanion.Constants.RUN_TIME_SERVICE_1
import com.chrrissoft.permissionscompanion.Constants.RUN_TIME_SERVICE_2
import com.chrrissoft.permissionscompanion.Constants.SIGNATURE_ACTIVITY_0
import com.chrrissoft.permissionscompanion.Constants.SIGNATURE_ACTIVITY_1
import com.chrrissoft.permissionscompanion.Constants.SIGNATURE_ACTIVITY_2
import com.chrrissoft.permissionscompanion.Constants.SIGNATURE_PERMISSION_0
import com.chrrissoft.permissionscompanion.Constants.SIGNATURE_PERMISSION_1
import com.chrrissoft.permissionscompanion.Constants.SIGNATURE_PERMISSION_2
import com.chrrissoft.permissionscompanion.Constants.SIGNATURE_RECEIVER_0
import com.chrrissoft.permissionscompanion.Constants.SIGNATURE_RECEIVER_1
import com.chrrissoft.permissionscompanion.Constants.SIGNATURE_RECEIVER_2
import com.chrrissoft.permissionscompanion.Constants.SIGNATURE_SERVICE_0
import com.chrrissoft.permissionscompanion.Constants.SIGNATURE_SERVICE_1
import com.chrrissoft.permissionscompanion.Constants.SIGNATURE_SERVICE_2
import com.chrrissoft.permissionscompanion.Permission

@SuppressLint("InlinedApi")
data class ScreenState(
    val page: Page = Page.NORMAL,
    val normal: NormalState = NormalState(),
    val runTime: RunTimeState = RunTimeState(),
    val signature: SignatureState = SignatureState(),
) {
    enum class Page(val icon: ImageVector, val label: String) {
        NORMAL(Icons.Rounded.Favorite, "Normal"),
        RUN_TIME(Icons.Rounded.Favorite, "Run time"),
        SIGNATURE(Icons.Rounded.Favorite, "Signature");

        companion object {
            val pages = listOf(NORMAL, RUN_TIME, SIGNATURE)
        }
    }

    data class NormalState(val items: List<Permission> = list) {
        private companion object {
            private val list = listOf(
                Permission(NORMAL_PERMISSION_0, (1), NORMAL_SERVICE_0, NORMAL_ACTIVITY_0, NORMAL_RECEIVER_0),
                Permission(NORMAL_PERMISSION_1, (1), NORMAL_SERVICE_1, NORMAL_ACTIVITY_1, NORMAL_RECEIVER_1),
                Permission(NORMAL_PERMISSION_2, (1), NORMAL_SERVICE_2, NORMAL_ACTIVITY_2, NORMAL_RECEIVER_2),
            )
        }
    }

    data class RunTimeState(val items: List<Permission> = list) {
        private companion object {
            private val list = listOf(
                Permission(RUN_TIME_PERMISSION_0, (1), RUN_TIME_SERVICE_0, RUN_TIME_ACTIVITY_0, RUN_TIME_RECEIVER_0),
                Permission(RUN_TIME_PERMISSION_1, (1), RUN_TIME_SERVICE_1, RUN_TIME_ACTIVITY_1, RUN_TIME_RECEIVER_1),
                Permission(RUN_TIME_PERMISSION_2, (1), RUN_TIME_SERVICE_2, RUN_TIME_ACTIVITY_2, RUN_TIME_RECEIVER_2),
            )
        }
    }

    data class SignatureState(val items: List<Permission> = list) {
        private companion object {
            private val list = listOf(
                Permission(SIGNATURE_PERMISSION_0, (1), SIGNATURE_SERVICE_0, SIGNATURE_ACTIVITY_0, SIGNATURE_RECEIVER_0),
                Permission(SIGNATURE_PERMISSION_1, (1), SIGNATURE_SERVICE_1, SIGNATURE_ACTIVITY_1, SIGNATURE_RECEIVER_1),
                Permission(SIGNATURE_PERMISSION_2, (1), SIGNATURE_SERVICE_2, SIGNATURE_ACTIVITY_2, SIGNATURE_RECEIVER_2),
            )
        }
    }
}
