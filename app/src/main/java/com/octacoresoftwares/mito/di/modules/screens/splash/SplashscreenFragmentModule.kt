package com.octacoresoftwares.mito.di.modules.screens.splash

import com.octacoresoftwares.mito.screens.SplashScreenFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SplashscreenFragmentModule {

    @ContributesAndroidInjector(modules = [SplashscreenModule::class])
    abstract fun bindSplashscreenFragment(): SplashScreenFragment
}