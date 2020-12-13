package com.octacoresoftwares.mito.di.modules.screens.auth

import com.octacoresoftwares.core.navigation.auth.IAuthenticationNavigation
import com.octacoresoftwares.core.navigation.auth.ILoginNavigation
import com.octacoresoftwares.core.navigation.auth.IRegistrationNavigation
import com.octacoresoftwares.mito.navigation.auth.AuthenticationNavigation
import com.octacoresoftwares.mito.navigation.auth.LoginNavigation
import com.octacoresoftwares.mito.navigation.auth.RegistrationNavigation
import dagger.Binds
import dagger.Module

@Module
abstract class NavigationModule {

    @Binds
    abstract fun bindsNavigationLogin(nav: LoginNavigation): ILoginNavigation

    @Binds
    abstract fun bindsNavigationRegistration(nav: RegistrationNavigation): IRegistrationNavigation

    @Binds
    abstract fun bindsNavigationAuthentication(nav: AuthenticationNavigation): IAuthenticationNavigation
}