package com.octacoresoftwares.nearby

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.core.base.BaseFragment
import com.octacoresoftwares.core.base.BaseViewModel
import com.octacoresoftwares.nearby.databinding.FragmentNearbyHostBinding
import javax.inject.Inject

class NearbyHostFragment : BaseFragment<FragmentNearbyHostBinding, BaseViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val model by viewModels<BaseViewModel> { factory }

    private lateinit var binding: FragmentNearbyHostBinding

    override fun getViewModel(): BaseViewModel = model

    override fun getLayoutId(): Int = R.layout.fragment_nearby_host

    override fun getViewModelBindingVariable(): Int = 0

    override fun setViewDataBinding(binding: FragmentNearbyHostBinding?) {
        binding?.let {
            this.binding = binding
        }
    }
}