package com.octacoresoftwares.mito.di.modules.screens.main

import com.octacoresoftwares.core.navigation.IMainNavigation
import com.octacoresoftwares.mito.navigation.MainNavigation
import dagger.Binds
import dagger.Module

@Module
abstract class NavigationModule {

    @Binds
    abstract fun bindsMainNavigation(nav: MainNavigation): IMainNavigation
}