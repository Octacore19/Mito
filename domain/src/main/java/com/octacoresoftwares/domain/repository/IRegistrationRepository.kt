package com.octacoresoftwares.domain.repository

interface IRegistrationRepository {
    fun <C> createAccount(email: String, password: String, callback: C)
    fun <C> updateUsername(username: String, callback: C)
}