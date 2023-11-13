package com.chrrissoft.permissionscompanion.di

import android.app.AlarmManager
import androidx.core.content.getSystemService
import com.chrrissoft.permissionscompanion.PermissionCompanionApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AlarmManagerModule {
    @Provides
    fun provide(app: PermissionCompanionApp): AlarmManager = app.getSystemService()!!
}
