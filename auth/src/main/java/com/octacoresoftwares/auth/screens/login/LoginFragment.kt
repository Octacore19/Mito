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
import com.octacoresoftwares.core.utils.AppLog
import com.octacoresoftwares.domain.navigation.auth.ILoginNav
import javax.inject.Inject

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var navigation: ILoginNav

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
        setBackPressedListener(this) {
            requireActivity().finish()
        }
    }

    override fun setViewModelObservers() {
        model.loginResult.observe({ lifecycle }) {
            it?.let { model ->
                if (model.successful) {
                    getFragmentNavController()?.let { controller ->
                        navigation.actionLoginToMain(controller)
                    }
                } else {
                    AppLog.e("Errors: ${model.data}")
                }
            }
        }
    }
}