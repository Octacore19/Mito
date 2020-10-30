package com.octacoresoftwares.mito.screens.login.di

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.mito.di.ViewModelKey
import com.octacoresoftwares.mito.repos.LoginRepository
import com.octacoresoftwares.mito.repos.LoginRepositoryImpl
import com.octacoresoftwares.mito.screens.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    abstract fun bindLoginRepo(repo: LoginRepositoryImpl): LoginRepository
}