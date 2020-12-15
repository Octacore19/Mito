package com.octacoresoftwares.mito.di.modules.screens.splash

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.core.di.keys.ViewModelKey
import com.octacoresoftwares.mito.screens.AppViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SplashscreenModule {

    @Binds
    @IntoMap
    @ViewModelKey(AppViewModel::class)
    abstract fun bindsAppViewModel(viewModel: AppViewModel): ViewModel
}