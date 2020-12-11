package com.octacoresoftwares.mito.di.modules.screens

import com.octacoresoftwares.mito.di.modules.screens.auth.AuthModules
import com.octacoresoftwares.mito.di.modules.screens.main.MainModule
import com.octacoresoftwares.mito.screens.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModules {

    @ContributesAndroidInjector(modules = [AuthModules::class, MainModule::class])
    abstract fun bindMainActivity(): MainActivity
}