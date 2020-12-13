package com.octacoresoftwares.domain.navigation.auth

interface IRegistrationNav {
    fun <T> setBackNavController(t: T)
    fun <T> actionRegistrationToMain(t: T)
}