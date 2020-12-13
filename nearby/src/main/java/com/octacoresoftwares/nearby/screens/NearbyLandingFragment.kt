package com.octacoresoftwares.nearby.screens

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.core.base.BaseFragment
import com.octacoresoftwares.nearby.R
import com.octacoresoftwares.nearby.databinding.FragmentNearbyLandingBinding
import com.octacoresoftwares.nearby.viewmodels.NearbyLandingViewModel
import javax.inject.Inject

class NearbyLandingFragment : BaseFragment<FragmentNearbyLandingBinding, NearbyLandingViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val model by viewModels<NearbyLandingViewModel> { factory }

    private lateinit var binding: FragmentNearbyLandingBinding

    override fun getViewModel(): NearbyLandingViewModel = model

    override fun getLayoutId(): Int = R.layout.fragment_nearby_landing

    override fun getViewModelBindingVariable(): Int = 0

    override fun setViewDataBinding(binding: FragmentNearbyLandingBinding?) {
        binding?.let {
            this.binding = it
        }
    }
}