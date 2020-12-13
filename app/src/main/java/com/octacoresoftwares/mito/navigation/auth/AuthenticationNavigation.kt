package com.octacoresoftwares.mito.navigation.auth

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.octacoresoftwares.core.navigation.auth.IAuthenticationNavigation
import com.octacoresoftwares.core.utils.AppLog
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.screens.MainActivity
import javax.inject.Inject

class AuthenticationNavigation @Inject constructor() : IAuthenticationNavigation {

    override fun setNavController(fragment: Fragment) {
        fragment.requireActivity().findNavController(R.id.app_host_fragment)
    }

    override fun authenticationBackTo(fragment: Fragment) {
        AppLog.d("authenticationBackTo is called")
        val activity = fragment.requireActivity()
        activity.findNavController(R.id.app_host_fragment)
            .addOnDestinationChangedListener { _, destination, _ ->
                if (destination.id == R.id.navigation_authentication) {
                    activity.finish()
                }
            }
    }
}