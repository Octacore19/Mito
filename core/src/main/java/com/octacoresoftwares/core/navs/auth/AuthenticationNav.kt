package com.octacoresoftwares.core.navs.auth

import androidx.fragment.app.Fragment
import com.octacoresoftwares.core.navigation.auth.IAuthenticationNavigation
import com.octacoresoftwares.domain.navigation.auth.IAuthenticationNav
import javax.inject.Inject

class AuthenticationNav @Inject constructor(
    private val nav: IAuthenticationNavigation
) : IAuthenticationNav {

    override fun <T> setNavController(t: T) {
        nav.setNavController(t as Fragment)
    }

    override fun <T> actionAuthenticationBackTo(t: T) {
        nav.authenticationBackTo(t as Fragment)
    }
}