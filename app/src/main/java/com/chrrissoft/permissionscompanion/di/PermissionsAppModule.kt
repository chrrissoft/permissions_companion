package com.chrrissoft.permissionscompanion.di

import android.content.Context
import com.chrrissoft.permissionscompanion.PermissionCompanionApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PermissionsAppModule {
    @Provides
    fun provide(@ApplicationContext ctx: Context): PermissionCompanionApp = ctx as PermissionCompanionApp
}
