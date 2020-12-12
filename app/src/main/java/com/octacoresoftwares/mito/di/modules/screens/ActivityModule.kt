package com.octacoresoftwares.mito.di.modules.screens

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.core.base.BaseViewModel
import com.octacoresoftwares.mito.di.keys.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(BaseViewModel::class)
    abstract fun bindLoginViewModel(viewModel: BaseViewModel): ViewModel
}