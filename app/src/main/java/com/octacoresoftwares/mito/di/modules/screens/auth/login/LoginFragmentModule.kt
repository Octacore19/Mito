package com.octacoresoftwares.mito.di.modules.screens.auth.login

import com.octacoresoftwares.auth.screens.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginFragmentModule {

    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun bindLoginFragment(): LoginFragment
}