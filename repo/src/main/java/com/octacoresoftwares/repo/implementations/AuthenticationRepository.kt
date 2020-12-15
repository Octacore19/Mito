package com.octacoresoftwares.repo.implementations

import com.octacoresoftwares.domain.ResultCallback
import com.octacoresoftwares.domain.firebase.*
import com.octacoresoftwares.domain.models.BaseDomainModel
import com.octacoresoftwares.repo.IAuthenticationRepository
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(
    private val createAuth: ICreateAccountAuthentication,
    private val loginAuth: ILoginAuthentication,
    private val updateAuth: IUpdateUsernameAuthentication
) : IAuthenticationRepository {
    override fun loginUser(email: String, password: String, result: ResultCallback) {
        loginAuth.loginWithEmailAndPassword(email, password, result)
    }

    override fun registerUser(email: String, password: String, result: ResultCallback) {
        createAuth.createAccountWithEmailAndPassword(email, password, result)
    }

    override fun updateUsername(username: String, result: ResultCallback) {
        updateAuth.updateUsername(username, result)
    }
}