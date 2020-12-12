package com.octacoresoftwares.repo.implementations

import com.octacoresoftwares.domain.local.IAppLocalDatabase
import com.octacoresoftwares.domain.local.IAppLocalPreferences
import com.octacoresoftwares.domain.repository.IRegistrationRepository
import com.octacoresoftwares.repo.IAuthenticationRepository
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private val auth: IAuthenticationRepository,
    private val database: IAppLocalDatabase,
    private val preferences: IAppLocalPreferences
): IRegistrationRepository {
    override fun createAccount(email: String, password: String) {
        /*auth.registerUser(email, password, object : ResultCallback {
            override fun <D> success(data: D) {
                TODO("Not yet implemented")
            }

            override fun <E> error(exception: E) {
                TODO("Not yet implemented")
            }
        })*/
    }

    override fun updateUsername(username: String) {
        /*auth.updateUsername(username, object : ResultCallback {
            override fun <D> success(data: D) {
                TODO("Not yet implemented")
            }

            override fun <E> error(exception: E) {
                TODO("Not yet implemented")
            }
        })*/
    }
}