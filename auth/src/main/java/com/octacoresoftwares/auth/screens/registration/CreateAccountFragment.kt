package com.octacoresoftwares.auth.screens.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.octacoresoftwares.auth.R
import com.octacoresoftwares.core.base.BaseFragment
import com.octacoresoftwares.core.base.BaseViewModel

class CreateAccountFragment : BaseFragment<ViewDataBinding, BaseViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_account, container, false)
    }

    override fun getViewModel(): BaseViewModel? {
        TODO("Not yet implemented")
    }

    override fun getLayoutId(): Int {
        TODO("Not yet implemented")
    }

    override fun getViewModelBindingVariable(): Int {
        TODO("Not yet implemented")
    }

    override fun setViewDataBinding(binding: ViewDataBinding?) {
        TODO("Not yet implemented")
    }
}