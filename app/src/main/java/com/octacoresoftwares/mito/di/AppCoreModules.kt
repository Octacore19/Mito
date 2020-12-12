package com.octacoresoftwares.mito.di

import com.octacoresoftwares.mito.di.modules.AppMainModules
import com.octacoresoftwares.mito.di.modules.firebase.FirebaseInstanceModules
import com.octacoresoftwares.mito.di.modules.viewmodel.ViewModelBuilderModule
import dagger.Module

@Module(
    includes = [
        ViewModelBuilderModule::class,
        FirebaseInstanceModules::class,
        AppMainModules::class
    ]
)
object AppCoreModules