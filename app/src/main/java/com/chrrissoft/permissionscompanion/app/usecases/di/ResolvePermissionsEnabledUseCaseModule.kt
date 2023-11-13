package com.chrrissoft.permissionscompanion.app.usecases.di

import com.chrrissoft.permissionscompanion.app.usecases.classes.ResolvePermissionsEnabledUseCaseImpl
import com.chrrissoft.permissionscompanion.app.usecases.interfaces.ResolvePermissionsEnabledUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ResolvePermissionsEnabledUseCaseModule {
    @Binds
    abstract fun binds(impl: ResolvePermissionsEnabledUseCaseImpl) : ResolvePermissionsEnabledUseCase
}
