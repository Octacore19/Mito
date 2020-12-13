package com.octacoresoftwares.domain.interactors.auth

import com.octacoresoftwares.domain.interactors.base.FirebaseUseCaseWithParam
import com.octacoresoftwares.domain.interactors.auth.LoginUseCase.LoginParams
import com.octacoresoftwares.domain.repository.ILoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val auth: ILoginRepository
): FirebaseUseCaseWithParam<LoginParams>() {

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