package com.octacoresoftwares.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.octacoresoftwares.core.base.BaseFragment
import com.octacoresoftwares.core.base.BaseViewModel
import com.octacoresoftwares.main.databinding.FragmentMainBinding
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding, BaseViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val model by viewModels<BaseViewModel> { factory }

    private lateinit var binding: FragmentMainBinding

    override fun getViewModel(): BaseViewModel = model

    override fun getLayoutId(): Int = R.layout.fragment_main

    override fun getViewModelBindingVariable(): Int = 0

    override fun setViewDataBinding(binding: FragmentMainBinding?) {
        binding?.let {
            this.binding = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentNavController(R.id.main_host_fragment)
        val navView: BottomNavigationView = view.findViewById(R.id.nav_view)
        getFragmentNavController()?.let { NavigationUI.setupWithNavController(navView, it) }
    }
}