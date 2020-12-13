package com.octacoresoftwares.matches.screens

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.core.base.BaseFragment
import com.octacoresoftwares.matches.R
import com.octacoresoftwares.matches.databinding.FragmentMatchesLandingBinding
import com.octacoresoftwares.matches.viewmodels.MatchesLandingViewModel
import javax.inject.Inject

class MatchesLandingFragment: BaseFragment<FragmentMatchesLandingBinding, MatchesLandingViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val model by viewModels<MatchesLandingViewModel> { factory }

    private lateinit var binding: FragmentMatchesLandingBinding

    override fun getViewModel(): MatchesLandingViewModel = model

    override fun getLayoutId(): Int = R.layout.fragment_matches_landing

    override fun getViewModelBindingVariable(): Int = 0

    override fun setViewDataBinding(binding: FragmentMatchesLandingBinding?) {
        binding?.let {
            this.binding = it
        }
    }
}