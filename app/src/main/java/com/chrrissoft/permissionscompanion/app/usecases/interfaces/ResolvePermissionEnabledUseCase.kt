package com.chrrissoft.permissionscompanion.app.usecases.interfaces

import com.chrrissoft.permissionscompanion.Permission


interface ResolvePermissionEnabledUseCase {
    operator fun invoke(data: Permission): Permission
}
