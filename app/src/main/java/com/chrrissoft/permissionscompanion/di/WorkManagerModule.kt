package com.chrrissoft.permissionscompanion.di

import android.content.Context
import androidx.work.*
import androidx.work.WorkManager.getInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object WorkManagerModule {
    @Provides
    fun provide(@ApplicationContext ctx: Context): WorkManager {
        return getInstance(ctx)
    }
}
