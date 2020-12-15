package com.octacoresoftwares.repo.implementations

import com.octacoresoftwares.domain.firebase.ICurrentAuthenticatedUser
import com.octacoresoftwares.domain.firebase.ISignOutAuthentication
import com.octacoresoftwares.domain.models.BaseDomainModel
import com.octacoresoftwares.domain.repository.IUserRepository
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val currentUser: ICurrentAuthenticatedUser,
    private val signOutAuth: ISignOutAuthentication
) : IUserRepository {

    override fun getCurrentUser(): BaseDomainModel<*> =
        if (currentUser.getCurrentUser().isNotEmpty()) BaseDomainModel(
            successful = true,
            data = currentUser.getCurrentUser()
        )
        else BaseDomainModel(successful = false, data = null)

    override fun signOut() {
        signOutAuth.signOut()
    }
}