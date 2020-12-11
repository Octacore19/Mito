package com.octacoresoftwares.domain.interactors

import com.octacoresoftwares.domain.interactors.LoginUseCase.LoginParams
import com.octacoresoftwares.domain.repository.ILoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val auth: ILoginRepository
): FirebaseUseCaseNoParam<LoginParams>() {

    override fun <C> buildFirebaseTask(params: LoginParams?, callback: C) {
        params?.let {
            auth.loginUser(it.email, it.password, callback)
        }
    }

    data class LoginParams(
        val email: String,
        val password: String
    )
}