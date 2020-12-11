package com.octacoresoftwares.mito.di.modules.screens.auth

import com.octacoresoftwares.auth.screens.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginModule {

    @ContributesAndroidInjector
    abstract fun bindLoginFragment(): LoginFragment
}