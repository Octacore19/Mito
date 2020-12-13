package com.octacoresoftwares.mito.navigation

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.octacoresoftwares.core.navigation.IMainNavigation
import com.octacoresoftwares.mito.R
import javax.inject.Inject

class MainNavigation @Inject constructor(): IMainNavigation {

    override fun actionBackMain(fragment: Fragment) {
        fragment.requireActivity().findNavController(R.id.app_host_fragment).navigateUp()
    }
}