package com.octacoresoftwares.firebase.implementations

import com.octacoresoftwares.domain.firebase.ISignOutAuthentication
import com.octacoresoftwares.firebase.contracts.IFirebaseAuth
import javax.inject.Inject

class SignOutAuthentication @Inject constructor(
    private val auth: IFirebaseAuth
) : ISignOutAuthentication {
    override fun signOut() {
        auth.signOut()
    }
}