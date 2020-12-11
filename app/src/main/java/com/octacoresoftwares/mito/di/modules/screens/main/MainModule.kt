package com.octacoresoftwares.mito.di.modules.screens.main

import com.octacoresoftwares.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {

    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment
}