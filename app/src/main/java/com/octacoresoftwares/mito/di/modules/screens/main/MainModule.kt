package com.octacoresoftwares.mito.di.modules.screens.main

import com.octacoresoftwares.main.di.MainFragmentModule
import dagger.Module

@Module(
    includes = [
        MainFragmentModule::class,
        NavigationModule::class
    ]
)
object MainModule