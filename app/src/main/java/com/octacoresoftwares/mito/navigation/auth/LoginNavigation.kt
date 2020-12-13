package com.octacoresoftwares.mito.navigation.auth

import androidx.navigation.NavController
import com.octacoresoftwares.auth.AuthenticationFragmentDirections
import com.octacoresoftwares.core.navigation.auth.ILoginNavigation
import javax.inject.Inject

class LoginNavigation @Inject constructor(): ILoginNavigation {

    override fun actionLoginToMain(controller: NavController) {
        controller.navigate(AuthenticationFragmentDirections.actionNavigationAuthenticationToNavigationMain())
    }
}