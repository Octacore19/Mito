package com.octacoresoftwares.repo.implementations

import com.octacoresoftwares.domain.ResultCallback
import com.octacoresoftwares.domain.local.IAppLocalDatabase
import com.octacoresoftwares.domain.local.IAppLocalPreferences
import com.octacoresoftwares.domain.repository.IRegistrationRepository
import com.octacoresoftwares.repo.IAuthenticationRepository
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private val auth: IAuthenticationRepository,
    /*private val database: IAppLocalDatabase,
    private val preferences: IAppLocalPreferences*/
): IRegistrationRepository {
    override fun <C> createAccount(email: String, password: String, callback: C) {
        auth.registerUser(email, password, callback as ResultCallback)
    }

    override fun <C> updateUsername(username: String, callback: C) {
        auth.updateUsername(username, callback as ResultCallback)
    }
}