package com.chrrissoft.permissionscompanion.app.usecases.classes

import com.chrrissoft.permissionscompanion.app.usecases.interfaces.ResolvePermissionEnabledUseCase
import com.chrrissoft.permissionscompanion.app.usecases.interfaces.ResolvePermissionsEnabledUseCase
import com.chrrissoft.permissionscompanion.Permission
import javax.inject.Inject

class ResolvePermissionsEnabledUseCaseImpl @Inject constructor(
    private val ResolvePermissionEnabledUseCase: ResolvePermissionEnabledUseCase,
) : ResolvePermissionsEnabledUseCase {
    override fun invoke(data: List<Permission>): List<Permission> {
        return data.map { ResolvePermissionEnabledUseCase(it) }
    }
}
