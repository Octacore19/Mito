package com.octacoresoftwares.domain.navigation.auth

interface IAuthenticationNav {
    fun <T> setNavController(t: T)
    fun <T> actionAuthenticationBackTo(t: T)
}