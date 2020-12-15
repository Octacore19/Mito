package com.octacoresoftwares.mito.screens

import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.octacoresoftwares.core.base.BaseActivity
import com.octacoresoftwares.core.base.BaseViewModel
import com.octacoresoftwares.core.utils.AppLog
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val model by viewModels<BaseViewModel> { factory }

    private lateinit var binding: ActivityMainBinding

    override fun getViewModel(): BaseViewModel = model

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModelBindingVariable(): Int = 0

    override fun getViewDataBinding(binding: ActivityMainBinding?) {
        if (binding != null) {
            this.binding = binding
        }
    }

    override fun onDestroy() {
        model.signOutUser()
        super.onDestroy()
    }
}