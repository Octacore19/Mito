package com.octacoresoftwares.domain.interactors.auth

import com.octacoresoftwares.domain.interactors.base.FirebaseUseCaseWithParam
import com.octacoresoftwares.domain.repository.IRegistrationRepository
import javax.inject.Inject

class UpdateUsernameUseCase @Inject constructor(
    private val auth: IRegistrationRepository
) : FirebaseUseCaseWithParam<String>() {

    override fun <C> buildFirebaseTask(params: String?, callback: C) {
        params?.let {
            auth.updateUsername(params, callback)
        }
    }
}