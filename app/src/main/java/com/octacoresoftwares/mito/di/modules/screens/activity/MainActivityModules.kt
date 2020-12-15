package com.octacoresoftwares.mito.di.modules.screens.activity

import com.octacoresoftwares.mito.di.modules.screens.auth.AuthModule
import com.octacoresoftwares.mito.di.modules.screens.main.MainModule
import com.octacoresoftwares.mito.di.modules.screens.splash.SplashscreenFragmentModule
import com.octacoresoftwares.mito.screens.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModules {

    @ContributesAndroidInjector(
        modules = [
            ActivityModule::class,
            AuthModule::class,
            MainModule::class,
            SplashscreenFragmentModule::class,
            UserModule::class
        ]
    )
    abstract fun bindMainActivity(): MainActivity
}