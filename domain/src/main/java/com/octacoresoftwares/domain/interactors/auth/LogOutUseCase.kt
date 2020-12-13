package com.octacoresoftwares.domain.interactors.auth

import com.octacoresoftwares.domain.interactors.base.FirebaseUseCaseNoParam
import com.octacoresoftwares.domain.interactors.base.FirebaseUseCaseWithParam
import com.octacoresoftwares.domain.repository.ILoginRepository
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val auth: ILoginRepository
): FirebaseUseCaseNoParam() {

    override fun <C> buildFirebaseTask(callback: C) {
        auth.signOut()
    }
}