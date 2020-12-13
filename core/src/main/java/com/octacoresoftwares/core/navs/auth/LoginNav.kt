package com.octacoresoftwares.core.navs.auth

import androidx.navigation.NavController
import com.octacoresoftwares.core.navigation.auth.ILoginNavigation
import com.octacoresoftwares.domain.navigation.auth.ILoginNav
import javax.inject.Inject

class LoginNav @Inject constructor(
    private val nav: ILoginNavigation
): ILoginNav {

    override fun <T> actionLoginToMain(t: T) {
        nav.actionLoginToMain(t as NavController)
    }
}