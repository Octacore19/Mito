package com.octacoresoftwares.domain.repository

interface ILoginRepository {
    fun <C> loginUser(email: String, password: String, callback: C)
    fun signOut()
}