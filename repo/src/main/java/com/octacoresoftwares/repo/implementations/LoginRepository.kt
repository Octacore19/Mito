package com.octacoresoftwares.repo.implementations

import com.octacoresoftwares.domain.ResultCallback
import com.octacoresoftwares.domain.local.IAppLocalDatabase
import com.octacoresoftwares.domain.local.IAppLocalPreferences
import com.octacoresoftwares.domain.repository.ILoginRepository
import com.octacoresoftwares.repo.IAuthenticationRepository
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val auth: IAuthenticationRepository/*,
    private val database: IAppLocalDatabase,
    private val preferences: IAppLocalPreferences*/
): ILoginRepository {

    override fun <C> loginUser(email: String, password: String, callback: C) {
        auth.loginUser(email, password, callback as ResultCallback)
    }
}