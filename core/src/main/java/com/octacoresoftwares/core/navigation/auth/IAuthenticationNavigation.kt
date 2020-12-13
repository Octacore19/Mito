package com.octacoresoftwares.core.navigation.auth

import androidx.fragment.app.Fragment

interface IAuthenticationNavigation {

    fun setNavController(fragment: Fragment)

    fun authenticationBackTo(fragment: Fragment)
}