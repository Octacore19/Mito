package com.octacoresoftwares.auth.screens.registration

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.auth.R
import com.octacoresoftwares.auth.databinding.FragmentRegistrationHostBinding
import com.octacoresoftwares.core.base.BaseFragment
import com.octacoresoftwares.core.base.BaseViewModel
import com.octacoresoftwares.core.utils.AppLog
import com.octacoresoftwares.domain.navigation.auth.IRegistrationNav
import javax.inject.Inject

class RegistrationHostFragment :
    BaseFragment<FragmentRegistrationHostBinding, BaseViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var navigation: IRegistrationNav

    private val model by viewModels<BaseViewModel> { factory }

    private lateinit var binding: FragmentRegistrationHostBinding

    override fun getViewModel(): BaseViewModel = model

    override fun getLayoutId(): Int = R.layout.fragment_registration_host

    override fun getViewModelBindingVariable(): Int = 0

    override fun setViewDataBinding(binding: FragmentRegistrationHostBinding?) {
        binding?.let {
            this.binding = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavigationGraph(R.id.auth_host_fragment, R.navigation.auth_navigation)
        setFragmentNavController(R.id.auth_host_fragment)

        setBackPressedListener(this) {
            getFragmentNavController()?.let {
                if (it.currentBackStackEntry == null) {
                    requireActivity().finish()
                } else {
                    AppLog.d("Registration host back button")
                    it.navigateUp()
                }
            }
        }
    }
}