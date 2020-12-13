package com.octacoresoftwares.auth.di

import com.octacoresoftwares.auth.AuthenticationFragment
import com.octacoresoftwares.auth.di.repo.AuthenticationRepositoryModule
import com.octacoresoftwares.auth.di.screens.AuthNavigationModule
import com.octacoresoftwares.auth.di.screens.login.LoginFragmentModule
import com.octacoresoftwares.auth.di.screens.registration.host.RegistrationFragmentHostModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AuthFragmentModules {

    @ContributesAndroidInjector(
        modules = [
            AuthenticationRepositoryModule::class,
            LoginFragmentModule::class,
            RegistrationFragmentHostModule::class,
            AuthNavigationModule::class
        ]
    )
    abstract fun bindAuthenticationFragment(): AuthenticationFragment
}