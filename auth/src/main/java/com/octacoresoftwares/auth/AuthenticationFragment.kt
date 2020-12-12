package com.octacoresoftwares.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.octacoresoftwares.auth.adapters.AuthenticationChooserAdapter
import com.octacoresoftwares.auth.databinding.FragmentAuthenticationBinding
import com.octacoresoftwares.core.base.BaseFragment
import com.octacoresoftwares.core.base.BaseViewModel
import javax.inject.Inject

class AuthenticationFragment :
    BaseFragment<FragmentAuthenticationBinding, BaseViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val model by viewModels<BaseViewModel> { factory }

    private lateinit var binding: FragmentAuthenticationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentNavController()
        binding.pager.adapter = AuthenticationChooserAdapter(this)
        TabLayoutMediator(binding.tabs, binding.pager) { tab, position ->
            when (position) {
                0 -> tab.text = "SIGN IN"
                1 -> tab.text = "SIGN UP"
            }
        }.attach()
    }

    override fun getViewModel(): BaseViewModel = model

    override fun getLayoutId(): Int = R.layout.fragment_authentication

    override fun getViewModelBindingVariable(): Int = 0

    override fun setViewDataBinding(binding: FragmentAuthenticationBinding?) {
        binding?.let {
            this.binding = it
        }
    }
}