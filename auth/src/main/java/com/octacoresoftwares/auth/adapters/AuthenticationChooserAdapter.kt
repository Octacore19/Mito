package com.octacoresoftwares.auth.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.octacoresoftwares.auth.AuthenticationFragment
import com.octacoresoftwares.auth.screens.RegistrationHostFragment
import com.octacoresoftwares.auth.screens.LoginFragment

class AuthenticationChooserAdapter(fragment: AuthenticationFragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LoginFragment()
            1 -> RegistrationHostFragment()
            else -> RegistrationHostFragment()
        }
    }
}