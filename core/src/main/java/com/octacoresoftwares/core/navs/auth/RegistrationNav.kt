package com.octacoresoftwares.core.navs.auth

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.octacoresoftwares.core.navigation.auth.IRegistrationNavigation
import com.octacoresoftwares.domain.navigation.auth.IRegistrationNav
import javax.inject.Inject

class RegistrationNav @Inject constructor(
    private val nav: IRegistrationNavigation
) : IRegistrationNav {

    override fun <T> setBackNavController(t: T) {
        nav.setBackNavController(t as Fragment)
    }

    override fun <T> actionRegistrationToMain(t: T) {
        nav.actionRegistrationToMain(t as NavController)
    }
}