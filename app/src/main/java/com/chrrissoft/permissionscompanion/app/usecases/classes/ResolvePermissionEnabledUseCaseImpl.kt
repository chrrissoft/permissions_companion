package com.chrrissoft.permissionscompanion.app.usecases.classes

import com.chrrissoft.permissionscompanion.app.usecases.interfaces.ResolvePermissionEnabledUseCase
import com.chrrissoft.permissionscompanion.Permission
import com.chrrissoft.permissionscompanion.PermissionCompanionApp
import com.chrrissoft.permissionscompanion.Util.hasPermission
import javax.inject.Inject

class ResolvePermissionEnabledUseCaseImpl @Inject constructor(
    private val app: PermissionCompanionApp,
) : ResolvePermissionEnabledUseCase {
    override fun invoke(data: Permission): Permission {
        return data.copy(enabled = app.hasPermission(data.permission))
    }
}
