package com.chrrissoft.permissionscompanion.app.usecases.di

import com.chrrissoft.permissionscompanion.app.usecases.classes.ResolvePermissionEnabledUseCaseImpl
import com.chrrissoft.permissionscompanion.app.usecases.interfaces.ResolvePermissionEnabledUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ResolvePermissionEnabledUseCaseModule {
    @Binds
    abstract fun binds(impl: ResolvePermissionEnabledUseCaseImpl) : ResolvePermissionEnabledUseCase
}
