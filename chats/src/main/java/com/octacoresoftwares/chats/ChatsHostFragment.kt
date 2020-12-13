package com.octacoresoftwares.chats

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.chats.databinding.FragmentChatsHostBinding
import com.octacoresoftwares.core.base.BaseFragment
import com.octacoresoftwares.core.base.BaseViewModel
import javax.inject.Inject

class ChatsHostFragment: BaseFragment<FragmentChatsHostBinding, BaseViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val model by viewModels<BaseViewModel> { factory }

    private lateinit var binding: FragmentChatsHostBinding

    override fun getViewModel(): BaseViewModel = model

    override fun getLayoutId(): Int = R.layout.fragment_chats_host

    override fun getViewModelBindingVariable(): Int = 0

    override fun setViewDataBinding(binding: FragmentChatsHostBinding?) {
        binding?.let {
            this.binding = it
        }
    }
}