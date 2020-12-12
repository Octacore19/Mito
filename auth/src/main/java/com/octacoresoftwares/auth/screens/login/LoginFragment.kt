package com.octacoresoftwares.auth.screens.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.auth.BR
import com.octacoresoftwares.auth.R
import com.octacoresoftwares.auth.databinding.FragmentLoginBinding
import com.octacoresoftwares.auth.viewmodels.LoginViewModel
import com.octacoresoftwares.core.base.BaseFragment
import com.octacoresoftwares.core.navigation.ILoginNavigation
import com.octacoresoftwares.domain.models.firebase.AuthUserModel
import javax.inject.Inject

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var navigation: ILoginNavigation

    private val model by viewModels<LoginViewModel> { factory }

    private lateinit var binding: FragmentLoginBinding

    override fun getViewModel(): LoginViewModel = model

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun getViewModelBindingVariable(): Int = BR.vm

    override fun setViewDataBinding(binding: FragmentLoginBinding?) {
        binding?.let {
            this.binding = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentNavController()
    }

    override fun setViewModelObservers() {
        model.loginResult.observe({ lifecycle }) {
            it?.let { model ->
                when (model.data) {
                    is AuthUserModel -> {
                        getFragmentNavController()?.let { controller ->
                            navigation.actionLoginToMain(controller)
                        }
                    }

                    is Exception -> {
                        getFragmentNavController()?.let { controller ->
                            navigation.actionLoginToMain(controller)
                        }
                    }
                }
            }
        }
    }
}