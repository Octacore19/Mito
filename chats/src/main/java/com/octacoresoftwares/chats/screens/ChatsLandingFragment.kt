package com.octacoresoftwares.chats.screens

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.chats.R
import com.octacoresoftwares.chats.databinding.FragmentChatsLandingBinding
import com.octacoresoftwares.chats.viewmodels.ChatsLandingViewModel
import com.octacoresoftwares.core.base.BaseFragment
import javax.inject.Inject

class ChatsLandingFragment : BaseFragment<FragmentChatsLandingBinding, ChatsLandingViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val model by viewModels<ChatsLandingViewModel> { factory }

    private lateinit var binding: FragmentChatsLandingBinding

    override fun getViewModel(): ChatsLandingViewModel = model

    override fun getLayoutId(): Int = R.layout.fragment_chats_landing

    override fun getViewModelBindingVariable(): Int = 0

    override fun setViewDataBinding(binding: FragmentChatsLandingBinding?) {
        binding?.let {
            this.binding = it
        }
    }
}