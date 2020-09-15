package com.octacoresoftwares.mito.repos

import com.octacoresoftwares.mito.models.Result.Callback

interface LoginRepository {
    fun login(email: String, password: String, callback: Callback)
}

interface RegistrationRepository {
    fun register(email: String, password: String)
}