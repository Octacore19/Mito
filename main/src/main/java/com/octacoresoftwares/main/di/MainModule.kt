package com.octacoresoftwares.main.di

import com.octacoresoftwares.core.navs.MainNav
import com.octacoresoftwares.domain.navigation.IMainNav
import dagger.Binds
import dagger.Module

@Module
abstract class MainModule {

    @Binds
    abstract fun bindsMainNavigation(navigation: MainNav): IMainNav
}