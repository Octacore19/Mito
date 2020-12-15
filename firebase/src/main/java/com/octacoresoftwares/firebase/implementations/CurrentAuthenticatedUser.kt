package com.octacoresoftwares.firebase.implementations

import com.octacoresoftwares.domain.firebase.ICurrentAuthenticatedUser
import com.octacoresoftwares.domain.models.BaseDomainModel
import com.octacoresoftwares.firebase.contracts.IFirebaseAuth
import javax.inject.Inject

class CurrentAuthenticatedUser @Inject constructor(
    private val auth: IFirebaseAuth
): ICurrentAuthenticatedUser {

    override fun getCurrentUser(): HashMap<String, Any?> {
        return auth.getCurrentUser()?.let {
            hashMapOf(
                "email" to it.email,
                "uid" to it.uid,
                "displayName" to it.displayName,
                "tenantId" to it.tenantId,
                "phoneNumber" to it.phoneNumber,
                "photoUrl" to it.photoUrl,
                "isEmailVerified" to it.isEmailVerified,
                "isAnonymous" to it.isAnonymous,
                "providerId" to it.providerId
            )
        } ?: hashMapOf()
    }
}