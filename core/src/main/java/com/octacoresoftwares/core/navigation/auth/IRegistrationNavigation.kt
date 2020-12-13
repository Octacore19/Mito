package com.octacoresoftwares.core.navigation.auth

import androidx.fragment.app.Fragment
import androidx.navigation.NavController

interface IRegistrationNavigation {
    fun setBackNavController(fragment: Fragment)
    fun actionRegistrationToMain(controller: NavController)
}