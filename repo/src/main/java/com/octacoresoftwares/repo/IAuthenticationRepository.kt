package com.octacoresoftwares.repo

import com.octacoresoftwares.domain.ResultCallback

interface IAuthenticationRepository {
    fun loginUser(email: String, password: String, result: ResultCallback)
    fun registerUser(email: String, password: String, result: ResultCallback)
    fun updateUsername(username: String, result: ResultCallback)
    /*fun getCurrentUser(): BaseDomainModel<*>
    fun signOut()*/
}