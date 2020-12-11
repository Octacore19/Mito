package com.octacoresoftwares.domain.repository

interface IRegistrationRepository {
    fun createAccount(email: String, password: String)
    fun updateUsername(username: String)
}