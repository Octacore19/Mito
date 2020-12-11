package com.octacoresoftwares.mito.di.modules.screens.auth

import com.octacoresoftwares.auth.AuthenticationFragment
import com.octacoresoftwares.mito.di.modules.repo.AuthenticationRepositoryModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AuthModules {

    @ContributesAndroidInjector(modules = [LoginModule::class, AuthenticationRepositoryModule::class])
    abstract fun bindAuthenticationFragment(): AuthenticationFragment
}