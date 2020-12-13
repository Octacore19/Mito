package com.octacoresoftwares.auth.screens.registration

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.auth.BR
import com.octacoresoftwares.auth.R
import com.octacoresoftwares.auth.databinding.FragmentNameRegistrationBinding
import com.octacoresoftwares.auth.viewmodels.NameRegistrationViewModel
import com.octacoresoftwares.core.base.BaseFragment
import javax.inject.Inject

class NameRegistrationFragment: BaseFragment<FragmentNameRegistrationBinding, NameRegistrationViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val model by viewModels<NameRegistrationViewModel> { factory }

    private lateinit var binding: FragmentNameRegistrationBinding

    override fun getViewModel(): NameRegistrationViewModel = model

    override fun getLayoutId(): Int = R.layout.fragment_name_registration

    override fun getViewModelBindingVariable(): Int = BR.vm

    override fun setViewDataBinding(binding: FragmentNameRegistrationBinding?) {
        binding?.let {
            this.binding = binding
        }
    }
}