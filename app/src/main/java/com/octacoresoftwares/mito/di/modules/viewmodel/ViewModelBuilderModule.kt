package com.octacoresoftwares.mito.di.modules.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.mito.di.factories.AppViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelBuilderModule {

    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}