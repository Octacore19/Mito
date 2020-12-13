package com.octacoresoftwares.auth.di.screens.login

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.auth.viewmodels.LoginViewModel
import com.octacoresoftwares.core.di.keys.ViewModelKey
import com.octacoresoftwares.core.navs.auth.LoginNav
import com.octacoresoftwares.domain.navigation.auth.ILoginNav
import com.octacoresoftwares.domain.repository.ILoginRepository
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
    abstract fun bindsLoginNavigation(nav: LoginNav): ILoginNav
}