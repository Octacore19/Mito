package com.octacoresoftwares.auth.di.screens

import com.octacoresoftwares.core.navs.auth.AuthenticationNav
import com.octacoresoftwares.domain.navigation.auth.IAuthenticationNav
import dagger.Binds
import dagger.Module

@Module
abstract class AuthNavigationModule {

    @Binds
    abstract fun bindsAuthenticationNav(nav: AuthenticationNav): IAuthenticationNav
}