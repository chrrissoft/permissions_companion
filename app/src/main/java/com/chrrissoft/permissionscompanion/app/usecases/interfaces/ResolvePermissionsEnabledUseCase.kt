package com.chrrissoft.permissionscompanion.app.usecases.interfaces

import com.chrrissoft.permissionscompanion.Permission


interface ResolvePermissionsEnabledUseCase {
    operator fun invoke(data: List<Permission>): List<Permission>
}
