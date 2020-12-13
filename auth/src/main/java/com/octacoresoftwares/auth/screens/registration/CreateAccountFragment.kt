package com.octacoresoftwares.auth.screens.registration

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.octacoresoftwares.auth.BR
import com.octacoresoftwares.auth.R
import com.octacoresoftwares.auth.databinding.FragmentCreateAccountBinding
import com.octacoresoftwares.auth.viewmodels.CreateAccountViewModel
import com.octacoresoftwares.auth.viewmodels.LoginViewModel
import com.octacoresoftwares.core.base.BaseFragment
import com.octacoresoftwares.core.utils.AppLog
import javax.inject.Inject

class CreateAccountFragment : BaseFragment<FragmentCreateAccountBinding, CreateAccountViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val model by viewModels<CreateAccountViewModel> { factory }

    private val controller by lazy {
        (requireParentFragment() as NavHostFragment).navController
    }

    private lateinit var binding: FragmentCreateAccountBinding

    override fun getViewModel(): CreateAccountViewModel = model

    override fun getLayoutId(): Int = R.layout.fragment_create_account

    override fun getViewModelBindingVariable(): Int = BR.vm

    override fun setViewDataBinding(binding: FragmentCreateAccountBinding?) {
        binding?.let {
            this.binding = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AppLog.d("Fragment in create: $controller")
    }

    override fun setViewModelObservers() {
        model.createAccountResult.observe({ lifecycle }) {
            it?.let { data ->
                if (data.successful) {
                    controller.navigate(R.id.action_create_account_fragment_to_name_registration_fragment)
                }
            }
        }
    }
}