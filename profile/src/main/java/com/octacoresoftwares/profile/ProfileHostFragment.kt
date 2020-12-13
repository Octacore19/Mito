package com.octacoresoftwares.profile

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.core.base.BaseFragment
import com.octacoresoftwares.core.base.BaseViewModel
import com.octacoresoftwares.profile.databinding.FragmentProfileHostBinding
import javax.inject.Inject

class ProfileHostFragment : BaseFragment<FragmentProfileHostBinding, BaseViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val model by viewModels<BaseViewModel> { factory }

    private lateinit var binding: FragmentProfileHostBinding

    override fun getViewModel(): BaseViewModel = model

    override fun getLayoutId(): Int = R.layout.fragment_profile_host

    override fun getViewModelBindingVariable(): Int = 0

    override fun setViewDataBinding(binding: FragmentProfileHostBinding?) {
        binding?.let {
            this.binding = it
        }
    }
}