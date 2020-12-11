package com.octacoresoftwares.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayoutMediator
import com.octacoresoftwares.auth.adapters.AuthenticationChooserAdapter
import com.octacoresoftwares.auth.databinding.FragmentAuthenticationBinding
import com.octacoresoftwares.core.base.BaseFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class AuthenticationFragment : BaseFragment<FragmentAuthenticationBinding, AuthenticationViewModel>() {

    private lateinit var binding: FragmentAuthenticationBinding

    private val appComponent by lazy {
//        (requireActivity().application as Mi)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pager.adapter = AuthenticationChooserAdapter(this)
        TabLayoutMediator(binding.tabs, binding.pager) {tab, position ->
            when (position) {
                0 -> {
                    tab.text = "SIGN IN"
                }
                1 -> tab.text = "SIGN UP"
            }
        }.attach()
    }

    override fun getViewModel(): AuthenticationViewModel? = null

    override fun getLayoutId(): Int = R.layout.fragment_authentication

    override fun getViewModelBindingVariable(): Int = 0

    override fun getViewDataBinding(binding: FragmentAuthenticationBinding?) {
        binding?.let {
            this.binding = it
        }
    }
}