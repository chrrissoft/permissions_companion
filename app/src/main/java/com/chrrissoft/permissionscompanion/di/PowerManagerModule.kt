package com.chrrissoft.permissionscompanion.di

import android.os.PowerManager
import androidx.core.content.getSystemService
import com.chrrissoft.permissionscompanion.PermissionCompanionApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PowerManagerModule {
    @Provides
    fun provide(app: PermissionCompanionApp): PowerManager = app.getSystemService()!!
}
