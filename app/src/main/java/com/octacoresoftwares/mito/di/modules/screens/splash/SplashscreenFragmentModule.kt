package com.octacoresoftwares.mito.di.modules.screens.splash

import com.octacoresoftwares.mito.screens.SplashScreenFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SplashscreenFragmentModule {

    @ContributesAndroidInjector
    abstract fun bindSplashscreenFragment(): SplashScreenFragment
}