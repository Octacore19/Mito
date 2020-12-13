package com.octacoresoftwares.domain.interactors.auth

import com.octacoresoftwares.domain.ResultCallback
import com.octacoresoftwares.domain.interactors.auth.CreateAccountUpdateUsernameUseCase.Params
import com.octacoresoftwares.domain.interactors.base.FirebaseUseCaseWithParam
import com.octacoresoftwares.domain.models.BaseDomainModel
import javax.inject.Inject

class CreateAccountUpdateUsernameUseCase @Inject constructor(
    private val createAccountUseCase: CreateAccountUseCase,
    private val updateUsernameUseCase: UpdateUsernameUseCase
) : FirebaseUseCaseWithParam<Params>() {

    override fun <C> buildFirebaseTask(params: Params?, callback: C) {
        params?.let {
            createAccountUseCase.buildFirebaseTask(params = CreateAccountUseCase.Params(
                email = it.email,
                password = it.password
            ), callback = object : ResultCallback {
                override fun <R> result(r: R) {
                    val result = r as BaseDomainModel<*>
                    if (result.successful) {
                        updateUsernameUseCase.buildFirebaseTask(
                            params = it.username,
                            callback = callback
                        )
                    } else {
                        (callback as ResultCallback).result(r)
                    }
                }
            })
        }
    }

    data class Params(
        val email: String,
        val password: String,
        val username: String
    )
}