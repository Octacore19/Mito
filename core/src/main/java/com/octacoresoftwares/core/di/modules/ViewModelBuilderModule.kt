package com.octacoresoftwares.core.di.modules

import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.core.di.factories.AppViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelBuilderModule {

    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}