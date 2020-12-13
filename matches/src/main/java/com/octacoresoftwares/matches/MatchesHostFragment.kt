package com.octacoresoftwares.matches

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.core.base.BaseFragment
import com.octacoresoftwares.core.base.BaseViewModel
import com.octacoresoftwares.matches.databinding.FragmentMatchesHostBinding
import javax.inject.Inject

class MatchesHostFragment: BaseFragment<FragmentMatchesHostBinding, BaseViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val model by viewModels<BaseViewModel> { factory }

    private lateinit var binding: FragmentMatchesHostBinding

    override fun getViewModel(): BaseViewModel = model

    override fun getLayoutId(): Int = R.layout.fragment_matches_host

    override fun getViewModelBindingVariable(): Int = 0

    override fun setViewDataBinding(binding: FragmentMatchesHostBinding?) {
        binding?.let {
            this.binding = it
        }
    }
}