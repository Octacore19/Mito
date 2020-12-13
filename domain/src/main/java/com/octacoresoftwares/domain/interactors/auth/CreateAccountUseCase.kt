package com.octacoresoftwares.domain.interactors.auth

import com.octacoresoftwares.domain.interactors.auth.CreateAccountUseCase.Params
import com.octacoresoftwares.domain.interactors.base.FirebaseUseCaseWithParam
import com.octacoresoftwares.domain.repository.IRegistrationRepository
import javax.inject.Inject

class CreateAccountUseCase @Inject constructor(
    private val repo: IRegistrationRepository
): FirebaseUseCaseWithParam<Params>() {

    override fun <C> buildFirebaseTask(params: Params?, callback: C) {
        params?.let {
            repo.createAccount(it.email, it.password, callback)
        }
    }

    data class Params(
        val email: String,
        val password: String
    )
}