package com.octacoresoftwares.mito.di.modules.screens.auth.login

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.auth.viewmodels.LoginViewModel
import com.octacoresoftwares.core.navigation.ILoginNavigation
import com.octacoresoftwares.domain.repository.ILoginRepository
import com.octacoresoftwares.mito.di.keys.ViewModelKey
import com.octacoresoftwares.mito.navigation.LoginNavigation
import com.octacoresoftwares.repo.implementations.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [LoginUseCaseModule::class])
abstract class LoginModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindsLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    abstract fun bindsLoginRepo(repo: LoginRepository): ILoginRepository

    @Binds
    abstract fun bindsLoginNavigation(nav: LoginNavigation): ILoginNavigation
}