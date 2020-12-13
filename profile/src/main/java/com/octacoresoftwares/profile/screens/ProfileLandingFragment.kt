package com.octacoresoftwares.profile.screens

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.core.base.BaseFragment
import com.octacoresoftwares.profile.R
import com.octacoresoftwares.profile.databinding.FragmentProfileLandingBinding
import com.octacoresoftwares.profile.viewmodels.ProfileLandingViewModel
import javax.inject.Inject

class ProfileLandingFragment :
    BaseFragment<FragmentProfileLandingBinding, ProfileLandingViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val model by viewModels<ProfileLandingViewModel> { factory }

    private lateinit var binding: FragmentProfileLandingBinding

    override fun getViewModel(): ProfileLandingViewModel = model

    override fun getLayoutId(): Int = R.layout.fragment_profile_landing

    override fun getViewModelBindingVariable(): Int = 0

    override fun setViewDataBinding(binding: FragmentProfileLandingBinding?) {
        binding?.let {
            this.binding = it
        }
    }
}