package com.octacoresoftwares.mito.navigation.auth

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.octacoresoftwares.auth.AuthenticationFragmentDirections
import com.octacoresoftwares.core.navigation.auth.IRegistrationNavigation
import com.octacoresoftwares.core.utils.AppLog
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.screens.MainActivity
import javax.inject.Inject

class RegistrationNavigation @Inject constructor(): IRegistrationNavigation {

    override fun setBackNavController(fragment: Fragment) {
        fragment.requireActivity().finish()
    }

    override fun actionRegistrationToMain(controller: NavController) {
        controller.navigate(AuthenticationFragmentDirections.actionNavigationAuthenticationToNavigationMain())
    }
}